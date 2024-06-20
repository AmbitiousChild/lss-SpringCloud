package com.lss.SpringCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class Main83 {
    public static void main(String[] args) {



        SpringApplication.run(Main83.class,args);
        System.out.println("\"欢迎雒世松进入alibaba-Nacos-order83!");
    }
}