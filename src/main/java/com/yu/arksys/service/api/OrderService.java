package com.yu.arksys.service.api;

import com.yu.arksys.bean.OrderRecord;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface OrderService {

    /**
     * 从数据库中读取
     * 将订单数量存入内存ku
     * @return 订单列表
     */
    List<OrderRecord> getOrders();

    /**
     * @return 返回订单数量
     */
    Integer getNum();

    /**
     * 生成一个初期订单，生成对应的详单
     */
    void addOrder();

}
