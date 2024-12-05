package org.niiish32x.fxsmsapp.sms.app.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.impl.client.CloseableHttpClient;
import org.niiish32x.fxsmsapp.result.Result;
import org.niiish32x.fxsmsapp.sms.app.SendSMSCService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * SendServiceImpl
 *
 * @author shenghao ni
 * @date 2024.12.04 22:55
 */
@Slf4j
@Service
public class SendSMSCServiceImpl implements SendSMSCService {

    private static String SEND_ID = "DSMDPR";

    private static final String CHANNEL = "Transactional";

    private static final String AK = "73101af46504b78d84d3b12fab482777";

    private static final String SK = "50fdd25963042ace27d3963cbe78c065";

    private static final String URL = "http://cloudsms.zubrixtechnologies.com/api/mt/GetBalance";

    @Override
    public Result send(String number, String text) {
        Map<String, Object> paramMap = buildPostBody(number, text);
        String post = HttpUtil.post(URL, paramMap);
        return Result.success(post);
    }

    Map<String,Object> buildPostBody(String number,String text){
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("senderid",SEND_ID);
        paramMap.put("channel",CHANNEL);
        paramMap.put("ak",AK);
        paramMap.put("sk",SK);
        paramMap.put("number",number);
        paramMap.put("text",text);
        return paramMap;
    }
}


























