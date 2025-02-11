package com.example.receipt_processor.service;

import com.example.receipt_processor.model.Item;
import com.example.receipt_processor.model.Receipt;

public class PointsService {
        public int calculatePoints(Receipt receipt) {
        int points = 0;
        points += receipt.getRetailer().replaceAll("[^A-Za-z0-9]", "").length();
        if (Double.parseDouble(receipt.getTotal()) % 1 == 0) {
            points += 50;
        }

        if (Double.parseDouble(receipt.getTotal()) % 0.25 == 0) {
            points += 25;
        }

        points += (receipt.getItems().size() / 2) * 5;

        for (Item item : receipt.getItems()) {
            if (item.getShortDescription().trim().length() % 3 == 0) {
                points += Math.round(Double.parseDouble(item.getPrice()) * 0.2);
            }
        }

        String day = receipt.getPurchaseDate().split("-")[2];
        if (Integer.parseInt(day) % 2 != 0) {
            points += 6;
        }
        if (receipt.getPurchaseTime().compareTo("14:00") >= 0 && receipt.getPurchaseTime().compareTo("16:00") <= 0) {
            points += 10;
        }
        return points;
    }
    
}
