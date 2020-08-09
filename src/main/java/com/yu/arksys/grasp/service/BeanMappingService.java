package com.yu.arksys.grasp.service;

import com.yu.arksys.bean.RecordTuple;
import com.yu.arksys.bean.TableMapInfo;
import com.yu.arksys.bean.api.MappableBean;
import com.yu.arksys.bean.api.ResponseBean;

import java.util.List;
import java.util.Map;

public interface BeanMappingService {

    /**
     *
     * 把原始为ID字段的Bean对应成内容字段
     */
    List<ResponseBean> mapBean(List<? extends MappableBean> beans, List<TableMapInfo> tableMapInfos);

    List<RecordTuple> getEmployeeMap();

    List<RecordTuple> getMapByIdList(List<String> idList, String nameField);

}
