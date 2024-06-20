package com.lss.SpringCloud.service.impl;

import com.lss.SpringCloud.entities.Pay;
import com.lss.SpringCloud.mapper.PayMapper;
import com.lss.SpringCloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayServiceImpl implements PayService {

    @Resource
    private PayMapper payMapper;


    //增
    @Override
    public int add(Pay pay) {
        return payMapper.insertSelective(pay);
    }
    //删
    @Override
    public int delete(Integer id) {
        return payMapper.deleteByPrimaryKey(id);
    }
    //改
    @Override
    public int update(Pay pay) {
        return payMapper.updateByPrimaryKeySelective(pay);
    }
    //查
    @Override
    public Pay getByID(Integer id) {
        return payMapper.selectByPrimaryKey(id);
    }
    //全查
    @Override
    public List<Pay> getAll() {
        return payMapper.selectAll();
    }
}
