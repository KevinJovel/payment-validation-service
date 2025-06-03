package com.payment.validation.service.payment_validation_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.payment.validation.service.payment_validation_service.dto.PaymentValidationRequest;
import com.payment.validation.service.payment_validation_service.dto.PaymentValidationResponse;

@Service
public class PaymentValidationService {
       private double maxAmount = 5000;// indica el monto maximo, o fondos disponibles.

       public PaymentValidationResponse validate(PaymentValidationRequest request) {

              if (request.getAmount().doubleValue() > maxAmount) {
                     return new PaymentValidationResponse("REJECTED", "Insufficient funds");
              }

              if (!isValidPaymentMethod(request.getPaymentMethod())) {
                     return new PaymentValidationResponse("REJECTED", "Invalid payment method");
              }

              if (!"PENDING".equalsIgnoreCase(request.getStatus())) {
                     return new PaymentValidationResponse("REJECTED", "Invalid payment status");
              }

              return new PaymentValidationResponse("SUCCESS", "Payment is valid");
       }

       private boolean isValidPaymentMethod(String method) {
              return method != null && List.of("CREDIT_CARD", "DEBIT_CARD").contains(method.toUpperCase());
       }

}
