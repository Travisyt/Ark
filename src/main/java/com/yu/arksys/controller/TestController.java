package com.yu.arksys.controller;

import com.yu.arksys.bean.AccountsRecord;
import com.yu.arksys.service.api.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    @Autowired
    MappingService mappingService;

    /**
     * 测试后台数据是否正确
     * @return json
     */
    @RequestMapping("/test")
    @ResponseBody
    public Map<String, List<Map<String, String>>> test() {
        System.out.println(mappingService.getFullyMapping());
        return mappingService.getFullyMapping();
    }

    @RequestMapping("/order")
    public ModelAndView order() {
        return new ModelAndView("main");
    }



    /**
     *
     * @return 返回记账信息列表
     */
//    @RequestMapping("/accountsData")
//    @ResponseBody
//    public List<AccountsRecord> accounts(String pageSize, String pageNum) {
//        List<AccountsRecord> accountsRecords = new ArrayList<>();
//        int ps = Integer.parseInt(pageSize);
//        for (int i=1;i<=ps;++i) {
//            accountsRecords.add(AccountsRecord.test());
//        }
//        return accountsRecords;
//    }
    @RequestMapping("/accountsData")
    @ResponseBody
    public Map<String, Object> accounts(String pageSize, String pageNum) {
        List<AccountsRecord> accountsRecords = new ArrayList<>();
        int ps = Integer.parseInt(pageSize);
        for (int i=1;i<=ps;++i) {
            accountsRecords.add(AccountsRecord.test());
        }
        Map<String, Object> map = new HashMap<>();
        map.put("num", 1020);
        map.put("data", accountsRecords);
        return map;
    }



}
