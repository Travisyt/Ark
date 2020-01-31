package com.yu.arksys.service.api.order;

import com.yu.arksys.bean.OrderRecord;

import java.util.List;

public interface OrderService {

    /**
     * 从数据库中读取
     * 订单数量放入session
     * @return 订单列表
     */
    List<OrderRecord> getOrders(Integer pageSize, Integer pageNum);

    /**
     * @return 返回订单数量
     *
     */
    Integer getNum();

    /**
     * 生成一个初期订单，生成对应的详单
     */
    void addOrder();

}
