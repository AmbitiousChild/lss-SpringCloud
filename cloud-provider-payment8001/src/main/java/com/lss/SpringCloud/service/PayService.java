package com.lss.SpringCloud.service;

import com.lss.SpringCloud.entities.Pay;

import java.util.List;


//封装接口
public interface PayService {


    public int add(Pay pay);
    public int delete(Integer id);
    public int update(Pay pay);

    public  Pay getByID(Integer id);

    public List<Pay>  getAll();
}
