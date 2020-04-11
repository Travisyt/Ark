package com.yu.arksys.grasp.service.imp;

import com.yu.arksys.bean.TableMapInfo;
import com.yu.arksys.bean.api.MappableBean;
import com.yu.arksys.bean.api.ResponseBean;
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

    @Override
    public List<ResponseBean> mapBean(List<? extends MappableBean> beans, List<TableMapInfo> tableMapInfos) {
        Map<String, Map<String, String>> mapInfos = new HashMap<>();
        tableMapInfos.forEach(item -> {
            Map<String, String> map = new HashMap<>();
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

}
