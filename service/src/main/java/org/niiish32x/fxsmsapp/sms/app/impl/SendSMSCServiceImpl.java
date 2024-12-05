package org.niiish32x.fxsmsapp.sms.app.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;

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

    private static final String APIKEY = "hyRZM0cdlk2Ey4FzBM6qiA";

    @Override
    public Result send(String number, String text) {
        Map<String, Object> paramMap = buildPostBody(number, text);
        String res = HttpRequest.get(URL).form(paramMap).timeout(2000).execute().body();
        return Result.success(res);
    }

    Map<String,Object> buildPostBody(String number,String text){
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("senderid",SEND_ID);
        paramMap.put("channel",CHANNEL);
        paramMap.put("number",number);
        paramMap.put("text",text);
        paramMap.put("APIKey",APIKEY);
        paramMap.put("DCS","");
        paramMap.put("flashsms","0");
        paramMap.put("route","15");
        return paramMap;
    }
}


























