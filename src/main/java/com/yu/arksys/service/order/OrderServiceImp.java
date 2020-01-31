package com.yu.arksys.service.order;

import com.yu.arksys.bean.OrderRecord;
import com.yu.arksys.dao.orders.OrderDao;
import com.yu.arksys.service.api.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public List<OrderRecord> getOrders(Integer pageSize, Integer pageNum) {
        return orderDao.getOrder(pageSize, pageNum);
    }

    @Override
    public Integer getNum() {
        return orderDao.getCount("");
    }

    @Override
    public void addOrder() {

    }
}
