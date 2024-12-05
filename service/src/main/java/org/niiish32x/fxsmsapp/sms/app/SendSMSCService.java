package org.niiish32x.fxsmsapp.sms.app;

import org.niiish32x.fxsmsapp.result.Result;

import java.util.Map;

/**
 * SendService
 *
 * 发送消息给下游APP
 *
 * @author shenghao ni
 * @date 2024.12.04 22:54
 */


public interface SendSMSCService {

    /**
     *
     * @param number 电话号码
     * @param text 短信内容
     * @return
     */
    Result send(String number,String text);
}
