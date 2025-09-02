package com.jetbrains.test

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PaymentController (@Qualifier("gateway") val paymentGateway: PaymentGateway) {

    @PostMapping("pay")
    fun payMoney(@RequestBody amount: Int): ResponseEntity<String> {
        val paymentStatus: PaymentStatus = paymentGateway.pay(amount)
        return ResponseEntity.ok("Payment status: ${paymentStatus}")
    }

}
