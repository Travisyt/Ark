package com.yu.arksys.grasp.service.imp;

import com.yu.arksys.bean.RecordTuple;
import com.yu.arksys.bean.TableMapInfo;
import com.yu.arksys.bean.api.MappableBean;
import com.yu.arksys.bean.api.ResponseBean;
import com.yu.arksys.component.BeanMapper;
import com.yu.arksys.grasp.dao.BusinessRelatedUnitDao;
import com.yu.arksys.grasp.dao.EmployeeDao;
import com.yu.arksys.grasp.dao.MapperDao;
import com.yu.arksys.grasp.service.BeanMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BeanMappingServiceImp implements BeanMappingService {

    @Autowired
    MapperDao mapperDao;

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public List<ResponseBean> mapBean(List<? extends MappableBean> beans, List<TableMapInfo> tableMapInfos) {
        Map<String, Map<String, String>> mapInfos = new HashMap<>();//各字段的键值对列表
        tableMapInfos.forEach(item -> {
            Map<String, String> map = new HashMap<>();//键值对
            mapperDao.getMapper(item.getKeyFieldName(), item.getValueFieldName(), item.getTableName()).forEach(tuple -> {
                map.put(tuple.getId(), tuple.getName());
            });
            mapInfos.put(item.getKeyFieldName(), map);
        });
        List<ResponseBean> res = new ArrayList<>();
        beans.forEach(item -> {
            res.add(item.getMappedBean(mapInfos));
        });
        return res;
    }

    @Override
    public List<RecordTuple> getEmployeeMap() {
        return employeeDao.getEmployeeMap();
    }

    @Autowired
    BusinessRelatedUnitDao businessRelatedUnitDao;

    @Override
    public List<RecordTuple> getMapByIdList(List<String> idList, String nameField) {
        List<RecordTuple> res = new ArrayList<>();
        idList.forEach(item -> {
            res.add(new RecordTuple(item, businessRelatedUnitDao.findFullNameById(item)));
        });
        return res;
    }

}
