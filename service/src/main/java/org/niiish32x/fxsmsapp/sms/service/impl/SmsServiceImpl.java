package org.niiish32x.fxsmsapp.sms.service.impl;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ImmutableMap;
import com.supcon.supfusion.notification.protocol.common.ReadStatus;
import com.supcon.supfusion.notification.protocol.common.SendStatus;
import com.supcon.supfusion.notification.protocol.model.Ack;
import com.supcon.supfusion.notification.protocol.model.AckResult;
import com.supcon.supfusion.notification.protocol.model.Notice;
import com.supcon.supfusion.notification.protocol.model.Receiver;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.tuple.Triple;
import org.niiish32x.fxsmsapp.CachabledOptional;
import org.niiish32x.fxsmsapp.sms.service.SmsService;
import org.niiish32x.fxsmsapp.sms.service.runner.ConfigRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * SmsServiceImpl
 *
 * @author shenghao ni
 * @date 2024.12.04 15:34
 */
@Service
@Slf4j
public class SmsServiceImpl implements SmsService {

    @Autowired
    ConfigRunner configRunner;
    CachabledOptional<Triple<String, String, String>> wsdlCacheAbleConfig = CachabledOptional.<Triple<String, String, String>>empty().setExpireMs(30 * 1000L);
    private static final Cache<String, Object> socketValid = CacheBuilder
            .newBuilder()
            .expireAfterWrite(1, TimeUnit.HOURS).build();

    static final String sendFail = "SEND_FAIL";
    static final String notConfig = "NOT_CONFIG";
    final String valid = "SocketOk";
    Map<Locale, Map<String, String>> i18n = ImmutableMap.of(Locale.forLanguageTag("zh-CN"),
            ImmutableMap.of(sendFail, "twilio 发送失败，%s",
                    notConfig, "twilio 短信未配置或错误，请联系管理员",
                    valid, "网络连接失败，api.twilio.com"),

            Locale.forLanguageTag("zh-HK"),
            ImmutableMap.of(sendFail, "twilio發送失敗，%s",
                    notConfig, "twilio簡訊未配寘或錯誤，請聯系管理員",
                    valid, "網絡連接失敗，api.twilio.com"),
            Locale.forLanguageTag("en-US"),
            ImmutableMap.of(sendFail, "Twilio sending failed,%s",
                    notConfig, "Twilio SMS is not configured or wrong, please contact the administrator",
                    valid, "Net connect error,api.twilio.com"), Locale.forLanguageTag("id-ID"),
            ImmutableMap.of(sendFail, "Pengiriman Twilio gaga,%s",
                    notConfig, "SMS Twilio tidak dikonfigurasi atau salah, silakan hubungi administrator",
                    valid, "Koneksi jaringan gagal, api.twilio.com"));



    @Override
    public Ack send(Notice notice) {

        return Ack.buildSuccess(notice,ReadStatus.READ);
    }
}
