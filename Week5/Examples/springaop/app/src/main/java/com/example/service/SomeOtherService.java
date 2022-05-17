package com.example.service;

import org.springframework.stereotype.Component;

@Component("SomeOtherService")
public class SomeOtherService {

    public void printHello(){
        System.out.println("Hello");
    }

}
