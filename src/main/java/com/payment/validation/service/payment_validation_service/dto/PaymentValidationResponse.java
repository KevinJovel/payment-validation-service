package com.payment.validation.service.payment_validation_service.dto;

public class PaymentValidationResponse {
     private String status;
    private String message;

    public PaymentValidationResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }
    
}
