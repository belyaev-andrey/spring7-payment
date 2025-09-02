package com.jetbrains.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
class PaymentController {

    private final PaymentGateway paymentGateway;

    PaymentController(@Qualifier("gateway") PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @PostMapping("pay")
    public ResponseEntity<String> postMoney(@RequestBody Integer amount) {
        PaymentStatus paymentStatus = paymentGateway.pay(amount);
        return ResponseEntity.ok("Payment status: %s".formatted(paymentStatus));
    }

}
