package com.lss.SpringCloud;

import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {


        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
        System.out.println("Hello world!");
    }
}