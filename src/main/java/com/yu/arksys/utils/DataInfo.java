package com.yu.arksys.utils;

import com.yu.arksys.bean.TableMapInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 存放表名、键值对信息
 */
public class DataInfo {

    private static List<TableMapInfo> detailedBillDraftMapTables;

    static {
        detailedBillDraftMapTables = new ArrayList<>();
        detailedBillDraftMapTables.add(new TableMapInfo("atype", "atypeid", "afullname"));
        detailedBillDraftMapTables.add(new TableMapInfo("btype", "btypeid", "bfullname"));
        detailedBillDraftMapTables.add(new TableMapInfo("employee", "etypeid", "efullname"));
        detailedBillDraftMapTables.add(new TableMapInfo("Stock", "ktypeid", "kfullname"));
        detailedBillDraftMapTables.add(new TableMapInfo("ptype", "ptypeid", "pfullname"));
        detailedBillDraftMapTables.add(new TableMapInfo("Vchtype", "vchtype", "vfullname"));
    }

    public static List<TableMapInfo> detailedBillDraftMapTables() {
        return detailedBillDraftMapTables;
    }

    public static List<TableMapInfo> detailedBillMapTables() {
        return detailedBillDraftMapTables;
    }

}
