package com.lss.SpringCloud.service;

import com.lss.SpringCloud.entities.Order;
import io.seata.spring.annotation.GlobalTransactional;

public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);

}
