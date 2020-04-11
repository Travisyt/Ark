package com.yu.arksys.configure;

import com.yu.arksys.utils.SQLUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduleTask {

    // 每天23:59将时间更新一天
    @Scheduled(cron = "50 59 23 * * ?")
    public void refreshCurrentDate() {
        Date date = new Date(System.currentTimeMillis() + 3600000);
        SQLUtils.refreshCurrentDate(date);
    }

}
