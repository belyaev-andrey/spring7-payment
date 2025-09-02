package com.jetbrains.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NullGateway implements PaymentGateway {
    private static final Logger log = LoggerFactory.getLogger(NullGateway.class);

    @Override
    public PaymentStatus pay(int amount) {
        log.info("Paying {} in NullGateway", amount);
        return PaymentStatus.SUCCESS;
    }
}
