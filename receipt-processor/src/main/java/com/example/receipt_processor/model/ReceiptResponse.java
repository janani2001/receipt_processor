package com.example.receipt_processor.model;

public class ReceiptResponse {
    private String id;
    public ReceiptResponse(String id2) {
        this.id = id2;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ReceiptResponse [id=" + id + "]";
    }
    
    
}
