package org.niiish32x.fxsmsapp.user.app.impl;

import cn.hutool.http.HttpUtil;

import org.niiish32x.fxsmsapp.user.app.UserService;
import org.niiish32x.fxsmsapp.user.app.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserServiceImpl
 *
 * @author shenghao ni
 * @date 2024.12.05 16:24
 */

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<UserDTO> geyUsersFromSupos() {
        String res = HttpUtil.get("http://47.129.0.177:8080/open-api/auth/v2/users");
        System.out.println(res);
        return null;
    }
}
