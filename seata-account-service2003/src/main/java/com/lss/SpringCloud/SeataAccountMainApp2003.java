package com.lss.SpringCloud;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.lss.SpringCloud.mapper") //import tk.mybatis.spring.annotation.MapperScan;
@SpringBootApplication
public class SeataAccountMainApp2003 {
    public static void main(String[] args) {


        SpringApplication.run(SeataAccountMainApp2003.class,args);
        System.out.println("欢迎雒世松进入SeataAccountMainApp2003 ");
    }
}