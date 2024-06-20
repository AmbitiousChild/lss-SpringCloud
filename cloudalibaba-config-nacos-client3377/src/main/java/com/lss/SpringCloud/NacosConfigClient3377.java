package com.lss.SpringCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigClient3377 {
    public static void main(String[] args) {


        SpringApplication.run(NacosConfigClient3377.class,args);
        System.out.println("欢迎 雒世松进入NacosConfigClient3377!");
    }
}