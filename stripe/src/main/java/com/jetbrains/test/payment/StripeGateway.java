package com.jetbrains.test.payment;

import com.jetbrains.test.PaymentGateway;
import com.jetbrains.test.PaymentStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StripeGateway implements PaymentGateway {

    private static final Logger log = LoggerFactory.getLogger(StripeGateway.class);

    @Override
    public PaymentStatus pay(int amount) {
        log.info("Paying {} in Stripe", amount);
        if (amount > 1000) {
            return PaymentStatus.FAILURE;
        }
        return PaymentStatus.SUCCESS;
    }
}
