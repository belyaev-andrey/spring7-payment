package com.jetbrains.test.payment;

import com.jetbrains.test.PaymentGateway;
import com.jetbrains.test.PaymentStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaypalGateway implements PaymentGateway {

    private static final Logger log = LoggerFactory.getLogger(PaypalGateway.class);

    @Override
    public PaymentStatus pay(int amount) {
        log.info("Paying {} in Paypal", amount);
        if (amount > 100) {
            return PaymentStatus.FAILURE;
        }
        return PaymentStatus.SUCCESS;
    }
}
