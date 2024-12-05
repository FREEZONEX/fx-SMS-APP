package org.niiish32x.fxsmsapp.user.app.impl;

import org.junit.runner.RunWith;
import org.niiish32x.fxsmsapp.sms.app.SendSMSCService;
import org.niiish32x.fxsmsapp.sms.app.impl.SendSMSCServiceImpl;
import org.niiish32x.fxsmsapp.user.app.UserService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * UserServiceTest
 *
 * @author shenghao ni
 * @date 2024.12.05 16:29
 */
@SpringBootTest(classes ={UserService.class, UserServiceImpl.class})
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Resource
    UserService userService;

    public void test() {
        userService.geyUsersFromSupos();
    }
}
