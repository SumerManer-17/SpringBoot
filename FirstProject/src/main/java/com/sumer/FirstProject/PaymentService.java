package com.sumer.FirstProject;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    public void pay(){
        System.out.println("Paying.....");
    }

    @PostConstruct
    public void before(){
        System.out.println("Before payment");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("After payment");
    }


}
