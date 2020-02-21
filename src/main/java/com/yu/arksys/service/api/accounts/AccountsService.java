package com.yu.arksys.service.api.accounts;

import java.util.List;
import java.util.Map;

public interface AccountsService {

    Map<String, Object> getData(Integer pageSize, Integer pageNum, String orderBy, Map<String, String> conditions);

    Map<String, Object> getData(Integer pageSize, Integer pageNum, Map<String, String> conditions);

    Map<String, Object> getData(Integer pageSize, Integer pageNum, String orderBy);

    Map<String, Object> getData(Integer pageSize, Integer pageNum);

}
