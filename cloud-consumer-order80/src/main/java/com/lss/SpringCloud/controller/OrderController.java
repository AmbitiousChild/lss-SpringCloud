package com.lss.SpringCloud.controller;


import com.lss.SpringCloud.entities.PayDTO;
import com.lss.SpringCloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class OrderController {


//    public static final String PaymentSrv_URL = "http://localhost:8001";//先写死，硬编码

    //使用consul服务注册中心
    public static final String PaymentSrv_URL = "http://cloud-payment-service";//服务注册中心上的微服务名称

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO){

        return restTemplate.postForObject(PaymentSrv_URL + "/pay/add", payDTO, ResultData.class);


    }

    @GetMapping(value = "/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id){

        return restTemplate.getForObject(PaymentSrv_URL+"/pay/get/"+id,ResultData.class,id);

    }

    @GetMapping(value = "/consumer/pay/get/info")
    private String getInfoByConsul()
    {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/info", String.class);
    }

    //编码使用DiscoveryClient动态获取所有上线的服务列表
    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping("/consumer/discovery")
    public String discovery()
    {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println(element);
        }

        System.out.println("===================================");

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
        }

        return instances.get(0).getServiceId()+":"+instances.get(0).getPort();
    }//轮询算法原理
}
