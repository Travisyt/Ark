package com.yu.arksys.grasp.service.imp;

import com.yu.arksys.bean.raw.CheckedSaleDraft;
import com.yu.arksys.bean.raw.DetailedBillDraft;
import com.yu.arksys.bean.RecordTuple;
import com.yu.arksys.bean.api.ResponseBean;
import com.yu.arksys.bean.response.DetailedBillDraftResponse;
import com.yu.arksys.grasp.dao.DetailedBillDraftDao;
import com.yu.arksys.grasp.service.BeanMappingService;
import com.yu.arksys.grasp.service.DetailedBillDraftService;
import com.yu.arksys.utils.DataInfo;
import com.yu.arksys.utils.SQLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Consumer;

@Service
public class DetailedBillDraftServiceImp implements DetailedBillDraftService {

    @Autowired
    DetailedBillDraftDao detailedBillDraftDao;

    @Autowired
    BeanMappingService mappingService;

    @Override
    public List<ResponseBean> getCurrentBillDraft(Map<String, String> conditions) {
        List<DetailedBillDraft> detailedBillDrafts = detailedBillDraftDao.getDailyRecordsWithConditions(SQLUtils.getConditionString(conditions), SQLUtils.getCurrentDate());
        return mappingService.mapBean(detailedBillDrafts, DataInfo.detailedBillDraftMapTables());
    }

    /**
     * Vchtype: 单据类型
     * etypeid: 员工代码
     */
    @Override
    public List<ResponseBean> getCurrentSaleDraftWithEmployee(String employee) {
        Map<String, String> map = new HashMap<>();
        map.put("etypeid", "=" + employee);
        map.put("Vchtype", "=" + DetailedBillDraftDao.SALE_TYPE);
        return getCurrentBillDraft(map);
    }

    @Override
    public List<RecordTuple> getCurrentBtypeMap(String etypeid) {
        return mappingService.getMapByIdList(detailedBillDraftDao.getCurrentBtypeIdList(etypeid, SQLUtils.getCurrentDate()), "bfullname");
    }

    @Override
    public List<ResponseBean> getCheckedSaleDraft(String etypeid) {
        List<CheckedSaleDraft> checkedSaleDrafts = detailedBillDraftDao.getCheckedSaleDraftByEmployee(etypeid, SQLUtils.getCurrentDate());
        return mappingService.mapBean(checkedSaleDrafts, DataInfo.checkedSaleDraftMapTables());
    }

    @Override
    public boolean checkSaleDraft(String employee) {
        List<DetailedBillDraft> detailedBillDrafts;
        List<CheckedSaleDraft> checkedSaleDrafts;
        try {
            detailedBillDrafts = detailedBillDraftDao.getDetailedSaleDraftByEmployee(employee, SQLUtils.getCurrentDate());
            checkedSaleDrafts = detailedBillDraftDao.getCheckedSaleDraftByEmployee(employee, SQLUtils.getCurrentDate());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        Set<String> ignoreDlyOrders = new HashSet<>();
        boolean flag;
        String modifiedOrderId = "";
        for (CheckedSaleDraft csd : checkedSaleDrafts) {
            flag = true;
            // 是否已删除
            if (csd.getDeleted().equals("1")) {
                continue;
            }
            for (DetailedBillDraft dbd : detailedBillDrafts) {
                // 是否为同一条数据
                if(!csd.getDlyorder().equals(dbd.getDlyOrder())) {
                    // 是否属于同一个单据
                    if (csd.getVchcode().equals(dbd.getVchcode())) {
                        // 是否曾经是同一条数据
                        if (csd.getDistinguishCode().equals(dbd.getDistinguishCode())) {
                            // 将其视为已发货草稿记录，不再重复加入
                            ignoreDlyOrders.add(dbd.getDlyOrder());
                            flag = false;
                            break;
                        }
                    }
                } else {
                    ignoreDlyOrders.add(dbd.getDlyOrder());
                    flag = false;
                    break;
                }
            }
            // 标记为删除
            if (flag) {
                csd.setDeleted("1");
                try {
                    checkSaleDraftDeletedMark(csd.getDlyorder());
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        for (DetailedBillDraft dbd : detailedBillDrafts) {
            if (!ignoreDlyOrders.contains(dbd.getDlyOrder())) {
                try {
                    detailedBillDraftDao.insertCheckedSaleDraft(
                            dbd.getDlyOrder(),
                            dbd.getEtypeid(),
                            dbd.getPtypeId(),
                            dbd.getBtypeid(),
                            dbd.getKtypeid(),
                            dbd.getVchcode(),
                            String.valueOf(dbd.getQty()),
                            String.valueOf(dbd.getPrice()),
                            "0",
                            SQLUtils.getCurrentDate(),
                            "1"
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void checkSaleDraftDeletedMark(String dlyorder) throws Exception {
        detailedBillDraftDao.updateCheckedSaleDraftIdentifiedByDlyOrder(dlyorder, "deleted", "1");
        detailedBillDraftDao.updateCheckedSaleDraftIdentifiedByDlyOrder(dlyorder, "modified", "1");
    }

}
