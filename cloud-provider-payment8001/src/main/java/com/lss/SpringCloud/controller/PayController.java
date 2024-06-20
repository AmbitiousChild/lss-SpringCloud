package com.lss.SpringCloud.controller;


import cn.hutool.core.util.BooleanUtil;
import com.lss.SpringCloud.entities.Pay;
import com.lss.SpringCloud.entities.PayDTO;
import com.lss.SpringCloud.resp.ResultData;
import com.lss.SpringCloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.concurrent.TimeUnit;

//Controller，作为对外暴露的接口，前端来调用

@RestController
@Slf4j   //日志
@Tag(name = "雒世松支付微服务模块",description = "雒世松支付CRUD")  //swagger.v3测试的Controller注解
public class PayController {


    //调用PayService接口
    @Resource
    private PayService payService;

    //
    //定义Controller的addPay接口,调用PayService接口add
    @PostMapping(value = "/pay/add")
    @Operation(summary = "雒世松新增",description = "新增支付流水方法,json串做参数") //swagger.v3测试的方法注解
    public ResultData<String> addPay(@RequestBody Pay pay){//包含请求体@RequestBody

        System.out.println(pay.toString());
        int add = payService.add(pay);
//        return "雒世松成功插入记录，返回值" + add;
        return ResultData.success("雒世松成功插入记录，返回值" + add);
    }


    //定义Controller的deletePay接口,调用PayService接口delete
    @DeleteMapping (value = "/pay/del/{id}")
    @Operation(summary = "雒世松删除",description = "删除支付流水方法")//swagger.v3测试的方法注解
    public ResultData<Integer> deletePay(@PathVariable("id")Integer id){

        int i = payService.delete(id);
//        return payService.delete(id) ;
        return ResultData.success(i);

    }

    //定义Controller的updatePay接口,调用PayService接口update
    @PutMapping(value = "/pay/update")
    @Operation(summary = "雒世松修改",description = "修改支付流水方法")//swagger.v3测试的方法注解
    public  ResultData<String> updatePay(@RequestBody PayDTO payDTO){


        //故意写暂停60秒程序，故意写Bug,测试出feign的默认调用超时时间
        try {
            TimeUnit.SECONDS.sleep(62);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        Pay pay = new Pay();

        BeanUtils.copyProperties(payDTO,pay);

        int i = payService.update(pay);
//        return "雒世松成功修改记录，返回值：" + update;
        return ResultData.success("雒世松成功修改记录，返回值：" + i);



    }

    //定义Controller的getById接口,调用PayService接口getByID
    @GetMapping(value = "/pay/get/{id}")
    @Operation(summary = "雒世松按照ID查流水",description = "查询支付流水方法")//swagger.v3测试的方法注解
    public ResultData<Pay> getById(@PathVariable("id") Integer id){

        if(id == -4) throw new RuntimeException("id不能为负数");

        Pay pay = payService.getByID(id);
//        return payService.getByID(id);
        return ResultData.success(pay);

    }

//    @GetMapping(value = "/pay/get/{id}")
//    public List<Pay> getAll(@PathVariable("id") Integer id){
//
//        return payService.getAll(id);
//
//    }


    //测试consul服务配置功能
//    @Value("${server.port}")
//    private String port;
//
//    @GetMapping(value = "/pay/get/info")
//    private String getInfoByConsul(@Value("${lss.info}") String lssInfo)
//    {
//        return "lssInfo: "+ lssInfo+"\t"+"port: "+port;
//    }

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/pay/get/info")
    public String getInfoByConsul(@Value("${lss.info}") String lssInfo)
    {
        return "雒世松Info: "+lssInfo+"\t"+"port: "+port;
    }
}
