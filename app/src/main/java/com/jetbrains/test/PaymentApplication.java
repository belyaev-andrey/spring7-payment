package com.jetbrains.test;

import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

@SpringBootApplication
@Import(PaymentGatewayRegistrar.class)
class PaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }

}

class PaymentGatewayRegistrar implements BeanRegistrar {
    @Override
    public void register(BeanRegistry registry, Environment env) {
        String gatewayClass = env.getProperty("app.payment.gateway.class");
        if (gatewayClass == null) {
            registry.registerBean("gateway", NullGateway.class);
            return;
        }
        try {
            Class<?> aClass = Class.forName(gatewayClass);
            registry.registerBean("gateway", aClass);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}