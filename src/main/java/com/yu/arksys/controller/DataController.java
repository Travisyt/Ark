package com.yu.arksys.controller;

import com.yu.arksys.bean.OrderRecord;
import com.yu.arksys.service.api.MappingService;
import com.yu.arksys.service.api.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DataController {

    @Autowired
    MappingService mappingService;

    @Autowired
    OrderService orderService;

    @RequestMapping("/fullyMapping")
    @ResponseBody
    public Map<String, Object> getFullyMapping() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", mappingService.getFullyMapping());
        map.put("status", "200");
        return map;
    }

    @RequestMapping("/getOrders")
    @ResponseBody
    public List<OrderRecord> getOrders(@PathVariable Integer pageSize, @PathVariable Integer pageNum) {
        return orderService.getOrders(pageSize, pageNum);
    }

}
