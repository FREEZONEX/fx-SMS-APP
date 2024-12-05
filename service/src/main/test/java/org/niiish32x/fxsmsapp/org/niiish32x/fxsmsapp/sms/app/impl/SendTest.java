package org.niiish32x.fxsmsapp.org.niiish32x.fxsmsapp.sms.app.impl;

import com.alibaba.fastjson2.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.niiish32x.fxsmsapp.result.Result;
import org.niiish32x.fxsmsapp.sms.app.SendSMSCService;
import org.niiish32x.fxsmsapp.sms.app.impl.SendSMSCServiceImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * SendTest
 *
 * @author shenghao ni
 * @date 2024.12.05 10:21
 */

@SpringBootTest(classes ={SendSMSCService.class, SendSMSCServiceImpl.class})
@RunWith(SpringRunner.class)
public class SendTest {
    @Resource
    SendSMSCService sendSMSCService;

    String number = "919747934655";
    String text = "text";
    @Test
    public void sendTest() {
        Result result = sendSMSCService.send(number, text);

        System.out.println(JSON.toJSON(result));
    }
}
