package com.yu.arksys.service.api;

import java.util.List;

public interface IdService {

    /**
     * 获取所有已经使用的id
     */
    List<Integer> getIdList(String table);

    /**
     * 取出并占用一个Id
     */
    Integer nextId(String table);

}
