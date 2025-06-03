package com.payment.validation.service.payment_validation_service.service;

import org.springframework.stereotype.Service;

import com.payment.validation.service.payment_validation_service.dto.PaymentValidationRequest;

@Service
public class PaymentValidationService {

       public boolean validate(PaymentValidationRequest request) {
        return request.getAmount() != null &&
               request.getAmount().doubleValue() > 0 &&
               "PENDING".equalsIgnoreCase(request.getStatus());
    }
    
}
