package org.niiish32x.fxsmsapp.user.app.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;

import org.niiish32x.fxsmsapp.user.app.UserService;
import org.niiish32x.fxsmsapp.user.app.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserServiceImpl
 *
 * @author shenghao ni
 * @date 2024.12.05 16:24
 */

@Service
public class UserServiceImpl implements UserService {

    private static final String AK = "73101af46504b78d84d3b12fab482777";

    private static final String SK = "50fdd25963042ace27d3963cbe78c065";

    @Override
    public List<UserDTO> geyUsersFromSupos() {
        Map<String, Object> paramMap = buildGetParam();
        String res = HttpRequest.get("http://47.129.0.177:8080/open-api/auth/v2/users").form(paramMap).timeout(2000).execute().body();

        System.out.println(res);
        return null;
    }

    Map<String,Object> buildGetParam(){
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("ak",AK);
        paramMap.put("sj=k",SK);


        return paramMap;
    }
}
