package com.lss.SpringCloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //服务注册和发现
public class Main9527 {
    public static void main(String[] args) {



        SpringApplication.run(Main9527.class,args);
        System.out.println("欢迎雒世松来到网关Gateway-Main9527!");
    }
}