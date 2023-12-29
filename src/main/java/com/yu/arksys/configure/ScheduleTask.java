package com.yu.arksys.configure;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.dnspod.v20210323.DnspodClient;
import com.tencentcloudapi.dnspod.v20210323.models.*;
import com.yu.arksys.utils.SQLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Component
public class ScheduleTask {

    // 每天23:59将时间更新一天
    @Scheduled(cron = "50 59 23 * * ?")
    public void refreshCurrentDate() {
        Date lastDate = new Date();
        Date date = new Date(System.currentTimeMillis() + 3600000);
        SQLUtils.refreshCurrentDate(date, lastDate);
        System.out.println("<================ Schedule Task ================>");
        System.out.println("日期已经更新为：" + date + " 。");
        System.out.println("<================ ------------- ================>");
    }


    // 本机IP接口
    public static String ThisIPRequestURL = "https://ipapi.co/json";
    //当前本机IP
    private String currentIP = "";

    @Value("${tencentcloud.dnspod.secretid}")
    private String secretID;
    @Value("${tencentcloud.dnspod.password}")
    private String password;
    private String domainName = "hgwj.ltd";
    private String subDomainName = "current";

    @Autowired
    private RestTemplate restTemplate;

    // 动态域名解析更新 每5分钟检查一次
//    @Scheduled(cron = "0 0/5 * * * ?")
//    public void DynamicDNSRefresh() {
//        String requestIP;
//        assert restTemplate != null;
//        String result = restTemplate.getForObject(ThisIPRequestURL, String.class);
//        assert result != null;
//        requestIP = result.substring(
//                result.indexOf("\"ip\":"),
//                result.indexOf("\"network\"")
//        ).split(":")[1].replace(" ", "").replace("\"", "").replace(",", "");
//
//        System.out.println("<================ Schedule Task ================>");
//
//        if (this.currentIP.equals(requestIP)) {
//            System.out.println("目前公网IP没有改变, " + this.currentIP);
//        } else {
//            this.currentIP = requestIP;
//            System.out.println("公网IP已经变为：" + requestIP);
//
//            try {
//                Credential credential = new Credential(secretID, password);
//                DnspodClient client = new DnspodClient(credential, "ap-shanghai");
//
//                DescribeDomainRequest request = new DescribeDomainRequest();
//                request.setDomain(this.domainName);
//                DescribeDomainResponse response = client.DescribeDomain(request);
//                System.out.println("域名 hgwj.ltd 状态： " + response.getDomainInfo().getStatus());
//
//                Long recordID = 0L;
//                DescribeRecordListRequest describeRecordListRequest = new DescribeRecordListRequest();
//                describeRecordListRequest.setDomain(this.domainName);
//                DescribeRecordListResponse describeRecordListResponse = client.DescribeRecordList(describeRecordListRequest);
//                for (RecordListItem recordListItem : describeRecordListResponse.getRecordList()) {
//                    if (recordListItem.getName().equals(this.subDomainName)) {
//                        recordID = recordListItem.getRecordId();
//                    }
//                }
//
//                if (recordID != -1L && recordID != 0L) {
//                    ModifyDynamicDNSRequest modifyRequest = new ModifyDynamicDNSRequest();
//                    modifyRequest.setDomain(this.domainName);
//                    modifyRequest.setSubDomain(this.subDomainName);
//                    modifyRequest.setRecordId(recordID);
//                    modifyRequest.setRecordLine("默认");
//                    modifyRequest.setValue(requestIP);
//                    ModifyDynamicDNSResponse modifyResponse = client.ModifyDynamicDNS(modifyRequest);
//                    if (modifyResponse.getRecordId().equals(recordID)) {
//                        System.out.println("域名解析更新成功，current.hgwj.ltd 域名的IP地址变更为: " + requestIP + " 。");
//                    } else {
//                        System.out.println("current.hgwj.ltd 域名解析记录更新失败！");
//                    }
//                } else {
//                    System.out.println("hgwj.ltd 域名解析记录查询错误！");
//                }
//            } catch (TencentCloudSDKException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//        System.out.println("<================ ------------- ================>");
//    }


}
