package com.payment.validation.service.payment_validation_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.validation.service.payment_validation_service.dto.PaymentValidationRequest;
import com.payment.validation.service.payment_validation_service.dto.PaymentValidationResponse;
import com.payment.validation.service.payment_validation_service.service.PaymentValidationService;

@RestController
@RequestMapping("/api/validate")
public class PaymentValidationController {
    private final PaymentValidationService validationService;

    public PaymentValidationController(PaymentValidationService validationService) {
        this.validationService = validationService;
    }

    @PostMapping
    public ResponseEntity<PaymentValidationResponse> validatePayment(@RequestBody PaymentValidationRequest request) {
        boolean isValid = validationService.validate(request);

        if (isValid) {
            return ResponseEntity.ok(new PaymentValidationResponse("SUCCESS", "Payment is valid"));
        } else {
            return ResponseEntity.badRequest().body(new PaymentValidationResponse("REJECTED", "Invalid payment"));
        }
    }
}
