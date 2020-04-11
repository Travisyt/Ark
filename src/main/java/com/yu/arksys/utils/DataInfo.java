package com.yu.arksys.utils;

import com.yu.arksys.bean.TableMapInfo;

import java.util.ArrayList;
import java.util.List;

public class DataInfo {

    public static List<TableMapInfo> DetailedBillDraftMapTables() {
        List<TableMapInfo> list = new ArrayList<>();
        list.add(new TableMapInfo("atype", "atypeid", "afullname"));
        list.add(new TableMapInfo("btype", "btypeid", "bfullname"));
        list.add(new TableMapInfo("employee", "etypeid", "efullname"));
        list.add(new TableMapInfo("Stock", "ktypeid", "kfullname"));
        list.add(new TableMapInfo("ptype", "ptypeid", "pfullname"));
        list.add(new TableMapInfo("Vchtype", "vchtype", "vfullname"));
        return list;
    }

}
