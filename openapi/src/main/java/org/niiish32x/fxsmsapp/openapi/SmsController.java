package org.niiish32x.fxsmsapp.openapi;

import com.supcon.supfusion.notification.protocol.model.Ack;
import com.supcon.supfusion.notification.protocol.model.Notice;
import org.niiish32x.fxsmsapp.result.Result;
import org.niiish32x.fxsmsapp.sms.app.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * SmsController
 *
 * @author shenghao ni
 * @date 2024.12.04 15:10
 */

@RestController("/open-api/notification")
public class SmsController {
    @Autowired
    ReceiverService smsService;


    @PostMapping("/sms")
    @ResponseBody
    public Result<Ack> sendSms(@RequestBody Notice notice) {
        return Result.success(smsService.send(notice));
    }


//    @PostMapping("/sms/test")
//    @ResponseBody
//    public Result<Void> test(@RequestBody Map<String, String> notice) {
//
//        smsService.test(notice.get("sid"),notice.get("token"),notice.get("mobile"));
//        return Result.success(null);
//    }

}
