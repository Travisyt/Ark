package com.yu.arksys.controller;

import com.yu.arksys.bean.raw.EmployeeRecord;
import com.yu.arksys.bean.api.ResponseBean;
import com.yu.arksys.grasp.dao.EmployeeDao;
import com.yu.arksys.grasp.service.ActionLogService;
import com.yu.arksys.grasp.service.DetailedBillDraftService;
import com.yu.arksys.service.api.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class TestController {

    @Autowired
    MappingService mappingService;

    /**
     * 测试后台数据是否正确
     * @return json
     */
    @RequestMapping("/test")
    public ModelAndView test() {
        return new ModelAndView("test");
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
//    @RequestMapping("/accountsData")
//    @ResponseBody
//    public Map<String, Object> accounts(String pageSize, String pageNum) {
//        List<AccountsRecord> accountsRecords = new ArrayList<>();
//        int ps = Integer.parseInt(pageSize);
//        for (int i=1;i<=ps;++i) {
//            accountsRecords.add(AccountsRecord.test());
//        }
//        Map<String, Object> map = new HashMap<>();
//        map.put("num", 1020);
//        map.put("data", accountsRecords);
//        map.put("status", "200");
//        return map;
//    }

    @RequestMapping("/deleteAccountsRecord")
    @ResponseBody
    public String deleteAccountsRecord(Integer id) {
        System.out.println("deleted where id = " + id.toString());
        return "200";
    }

    @RequestMapping("/checkAccountsRecord")
    @ResponseBody
    public String checkAccountsRecord(Integer id) {
        System.out.println("checked where id = " + id.toString());
        return "200";
    }

    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping("/employee")
    @ResponseBody
    public List<EmployeeRecord> employee() {
        return employeeDao.getEmployeeList();
    }

    @RequestMapping("/testPage")
    public ModelAndView testPage() {
        return new ModelAndView("test");
    }

    @RequestMapping("/actionWatch")
    public ModelAndView actionWatch() { return new ModelAndView("actionwatch"); }

    @Autowired
    ActionLogService actionLogService;

    @RequestMapping("/conditions")
    @ResponseBody
    public Map<String, Object> conditions(String field, String keyword) {
        Map<String, Object> map = new HashMap<>();
        if (field==null||field.equals("")) {
            map.put("status", "302");
        } else {
            List<String> list = actionLogService.getFieldEnum(field, keyword!=null?keyword:"");
            map.put("status", "200");
            map.put("data", list);
        }
        return map;
    }


    @Autowired
    DetailedBillDraftService detailedBillDraftService;

    @RequestMapping("/getDetailedBillDraft")
    @ResponseBody
    public List<ResponseBean> getDetailedBillDraft() {
        return detailedBillDraftService.getCurrentBillDraft(new HashMap<>());
    }


}
