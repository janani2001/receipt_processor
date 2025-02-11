package com.example.receipt_processor.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.receipt_processor.model.FinalPoints;
import com.example.receipt_processor.model.Receipt;
import com.example.receipt_processor.model.ReceiptResponse;
import com.example.receipt_processor.service.PointsService;


@RestController
@RequestMapping("/receipts")
public class ReceiptController {
private final PointsService pointsService = new PointsService();

// In-memory database to store receipts
private final Map<String, Receipt> receiptsDb = new HashMap<>();

// Endpoint to process the receipt
@PostMapping("/process")
public ReceiptResponse processReceipt(@RequestBody Receipt receipt) {
String id = UUID.randomUUID().toString();
receiptsDb.put(id, receipt); // Save receipt to "DB"
// logger.info("Receipt processed with ID: " + id);
return new ReceiptResponse(id);
}

// Endpoint to get points by receipt ID
@GetMapping("/{id}/points")
public FinalPoints getPoints(@PathVariable String id) {
Receipt receipt = receiptsDb.get(id);
if (receipt == null) {
throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Receipt not found");
}
int points = pointsService.calculatePoints(receipt);
return new FinalPoints(points);
}
}















