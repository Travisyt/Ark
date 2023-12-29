package com.yu.arksys;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.dnspod.v20210323.DnspodClient;
import com.tencentcloudapi.dnspod.v20210323.models.DescribeDomainRequest;
import com.tencentcloudapi.dnspod.v20210323.models.DescribeDomainResponse;

public class Test {

//    public static void main(String[] args) throws TencentCloudSDKException {
//        String testStr = "{\n" +
//                "    \"ip\": \"49.71.211.235\",\n" +
//                "    \"network\": \"49.71.208.0/22\",\n" +
//                "    \"version\": \"IPv4\",\n" +
//                "    \"city\": \"Nanjing\",\n" +
//                "    \"region\": \"Jiangsu\",\n" +
//                "    \"region_code\": \"JS\",\n" +
//                "    \"country\": \"CN\",\n" +
//                "    \"country_name\": \"China\",\n" +
//                "    \"country_code\": \"CN\",\n" +
//                "    \"country_code_iso3\": \"CHN\",\n" +
//                "    \"country_capital\": \"Beijing\",\n" +
//                "    \"country_tld\": \".cn\",\n" +
//                "    \"continent_code\": \"AS\",\n" +
//                "    \"in_eu\": false,\n" +
//                "    \"postal\": null,\n" +
//                "    \"latitude\": 32.0589,\n" +
//                "    \"longitude\": 118.7738,\n" +
//                "    \"timezone\": \"Asia/Shanghai\",\n" +
//                "    \"utc_offset\": \"+0800\",\n" +
//                "    \"country_calling_code\": \"+86\",\n" +
//                "    \"currency\": \"CNY\",\n" +
//                "    \"currency_name\": \"Yuan Renminbi\",\n" +
//                "    \"languages\": \"zh-CN,yue,wuu,dta,ug,za\",\n" +
//                "    \"country_area\": 9596960.0,\n" +
//                "    \"country_population\": 1411778724,\n" +
//                "    \"asn\": \"AS4134\",\n" +
//                "    \"org\": \"Chinanet\"\n" +
//                "}";
//
//        String result = testStr.substring(
//                testStr.indexOf("\"ip\":"),
//                testStr.indexOf("\"network\"")
//        ).split(":")[1].replace(" ", "").replace("\"", "").replace(",", "");
//        System.out.println(result);
//
//        String secretID = "AKIDq0tWJtZE1f4D4f47xWu51YruiQrWqJXZ";
//        String password = "tVqtfBl5HExPZWidGbf6GAdpoWw6nDMI";
//
//        try {
//            Credential credential = new Credential(secretID, password);
//            DnspodClient client = new DnspodClient(credential, "ap-shanghai");
//
//            DescribeDomainRequest request = new DescribeDomainRequest();
//            request.setDomain("hgswj.ltd");
//            DescribeDomainResponse response = client.DescribeDomain(request);
//
//            System.out.println(DescribeDomainResponse.toJsonString(response));
//            System.out.println("域名 hgwj.ltd 状态： " + response.getDomainInfo().getStatus());
//        } catch (TencentCloudSDKException e){
//            e.printStackTrace();
//        }
//
//    }

}
