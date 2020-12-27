package com.yu.arksys.utils;

import com.yu.arksys.bean.TableMapInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 存放表名、键值对信息
 */
public class DataInfo {

    private final static TableMapInfo atypeInfo = new TableMapInfo("atype", "atypeid", "afullname");
    private final static TableMapInfo btypeInfo = new TableMapInfo("btype", "btypeid", "bfullname");
    private final static TableMapInfo employeeInfo = new TableMapInfo("employee", "etypeid", "efullname");
    private final static TableMapInfo stockInfo = new TableMapInfo("Stock", "ktypeid", "kfullname");
    private final static TableMapInfo ptypeInfo = new TableMapInfo("ptype", "ptypeid", "pfullname");
    private final static TableMapInfo vchtypeInfo = new TableMapInfo("Vchtype", "vchtype", "vfullname");


    private static List<TableMapInfo> detailedBillDraftMapTables;

    private static List<TableMapInfo> checkedSaleDraftMapTables;

    private static List<TableMapInfo> stockAlertMapTables;

    static {

        detailedBillDraftMapTables = new ArrayList<>();
        detailedBillDraftMapTables.add(atypeInfo);
        detailedBillDraftMapTables.add(btypeInfo);
        detailedBillDraftMapTables.add(employeeInfo);
        detailedBillDraftMapTables.add(stockInfo);
        detailedBillDraftMapTables.add(ptypeInfo);
        detailedBillDraftMapTables.add(vchtypeInfo);

        checkedSaleDraftMapTables = new ArrayList<>();
        checkedSaleDraftMapTables.add(employeeInfo);
        checkedSaleDraftMapTables.add(ptypeInfo);
        checkedSaleDraftMapTables.add(stockInfo);
        checkedSaleDraftMapTables.add(btypeInfo);

        stockAlertMapTables = new ArrayList<>();
        stockAlertMapTables.add(ptypeInfo);
        stockAlertMapTables.add(stockInfo);
    }

    public static List<TableMapInfo> detailedBillDraftMapTables() {
        return detailedBillDraftMapTables;
    }

    public static List<TableMapInfo> detailedBillMapTables() {
        return detailedBillDraftMapTables;
    }

    public static List<TableMapInfo> checkedSaleDraftMapTables() {
        return checkedSaleDraftMapTables;
    }

    public static List<TableMapInfo> stockAlertMapTables() {
        return stockAlertMapTables;
    }

}
