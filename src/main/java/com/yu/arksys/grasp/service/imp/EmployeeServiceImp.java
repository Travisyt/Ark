package com.yu.arksys.grasp.service.imp;

import com.yu.arksys.bean.raw.EmployeeRecord;
import com.yu.arksys.grasp.dao.EmployeeDao;
import com.yu.arksys.grasp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public List<EmployeeRecord> getEmployeeInfos() {
        return employeeDao.getEmployeeList();
    }
}
