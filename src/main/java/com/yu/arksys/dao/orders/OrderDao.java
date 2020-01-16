package com.yu.arksys.dao.orders;

import com.yu.arksys.bean.Data;
import com.yu.arksys.bean.OrderRecord;

import java.util.List;

public interface OrderDao {

    List<OrderRecord> getOrder();

    List<OrderRecord> getOrder(Integer pageSize, Integer pageNum, String orderBy, Boolean desc);

    List<OrderRecord> getOrder(Integer pageSize, Integer pageNum);

    List<OrderRecord> getOrder(Integer pageSize, Integer pageNum, String condition, String orderBy, Boolean desc);

    Integer getCount(String condition);

    void delete(Integer orderId);

    void insert(OrderRecord orderRecord);

}
