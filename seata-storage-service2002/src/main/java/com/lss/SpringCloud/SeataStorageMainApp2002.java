package com.lss.SpringCloud;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@MapperScan("com.lss.SpringCloud.mapper") //import tk.mybatis.spring.annotation.MapperScan;
@EnableDiscoveryClient //服务注册和发现
@EnableFeignClients
public class SeataStorageMainApp2002 {
    public static void main(String[] args) {


        SpringApplication.run(SeataStorageMainApp2002.class,args);
        System.out.println("欢迎雒世松进入SeataStorageMainApp2002!");
    }
}