package com.yu.arksys.bean.api;

public abstract class AccountsDataBean extends DataBean {

    public static final String ID = "id";

    public static final String CREAT_TIME = "create_time";

    public static final String TARGET_ID = "target_id";

    public static final String ACCOUNT_ID = "account_id";

    public static final String VALUE = "value";

    public static final String TYPE_ID = "type_id";

    public static final String STATUS_ID = "status_id";

    public static final String WAY_ID = "way_id";

    public static final String CHECK_TIME = "check_time";

    public static final String NOTE = "note";

    @Override
    public String getFieldsString() {
        return "id,create_time,target_id,account_id,value,type_id,status_id,way_id,check_time,note";
    }

    @Override
    public String getTableName() {
        return "accounts_data";
    }
}
