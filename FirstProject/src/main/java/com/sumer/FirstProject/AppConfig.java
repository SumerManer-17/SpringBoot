package com.sumer.FirstProject;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public PaymentService paymentService(){
        return new PaymentService();
    }
}
