package com.lss.SpringCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class Main8401 {
    public static void main(String[] args) {


        SpringApplication.run(Main8401.class,args);
        System.out.println("欢迎雒世松进入cloudalibaba-sentinel-service8401!");
    }
}