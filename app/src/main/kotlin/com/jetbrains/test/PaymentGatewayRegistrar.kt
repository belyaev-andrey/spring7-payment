package com.jetbrains.test

import org.springframework.beans.factory.BeanRegistrar
import org.springframework.beans.factory.BeanRegistry
import org.springframework.core.env.Environment

class PaymentGatewayRegistrar: BeanRegistrar {
    override fun register(
        registry: BeanRegistry,
        env: Environment
    ) {
        val beanClass = env.getProperty("app.payment.gateway.class")?.let { 
            try {
                Class.forName(it) 
            } catch (e: ClassNotFoundException) {
                throw RuntimeException(e)
            }
        } ?: NullGateway::class.java

        registry.registerBean("gateway", beanClass)
    }
}