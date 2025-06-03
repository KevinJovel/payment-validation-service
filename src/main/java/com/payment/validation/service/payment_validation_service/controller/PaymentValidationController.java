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
        PaymentValidationResponse response = validationService.validate(request);

        if ("SUCCESS".equalsIgnoreCase(response.getStatus())) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.ok(response); // sigue siendo 200 OK, pero con status = "error" dentro del cuerpo
        }
    }
}
