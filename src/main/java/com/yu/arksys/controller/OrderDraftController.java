package com.yu.arksys.controller;

import com.yu.arksys.bean.response.DetailedBillDraftResponse;
import com.yu.arksys.grasp.dao.DetailedBillDraftDao;
import com.yu.arksys.grasp.service.DetailedBillDraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/saleDraft")
public class OrderDraftController {

    @Autowired
    DetailedBillDraftService detailedBillDraftService;

    @Autowired
    DetailedBillDraftDao detailedBillDraftDao;

    @RequestMapping("/saleDraftCheck")
    @ResponseBody
    public Map<String, Object> saleDraftCheck(String etypeid) {
        System.out.println("<-------- saleDraftCheck -------->");
        System.out.println("employee: " + etypeid);
        Map<String, Object> result = new HashMap<>();
        if (detailedBillDraftService.checkSaleDraft(etypeid)) result.put("status", "200");
        else result.put("status", "0");
        System.out.println("<-------- --------------- -------->");
        return result;
    }

    @RequestMapping("/getCheckedSaleDrafts")
    @ResponseBody
    public Map<String, Object> getCheckedSaleDrafts(String etypeid) {
        System.out.println("<-------- getCheckedSaleDrafts -------->");
        Map<String, Object> result = new HashMap<>();
        System.out.println("employee: " + etypeid);
        result.put("data", detailedBillDraftService.getCheckedSaleDraft(etypeid));
        result.put("status", "200");
        System.out.println("<-------- -------------------- -------->");
        return result;
    }

    @RequestMapping("/unsetModified")
    @ResponseBody
    public Map<String, Object> unsetModified(String etypeid) {
        Map<String, Object> res = new HashMap<>();
        try {
            detailedBillDraftDao.unsetModified(etypeid);
            res.put("status", "200");
        } catch (Exception e) {
            e.printStackTrace();
            res.put("status", "0");
        }
        return res;
    }



}
