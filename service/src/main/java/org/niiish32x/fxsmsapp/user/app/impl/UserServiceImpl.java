package org.niiish32x.fxsmsapp.user.app.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.niiish32x.fxsmsapp.aksk.SignUtil;
import org.niiish32x.fxsmsapp.aksk.SignUtils;
import org.niiish32x.fxsmsapp.user.app.UserService;
import org.niiish32x.fxsmsapp.user.app.dto.RoleDTO;
import org.niiish32x.fxsmsapp.user.app.dto.UserDTO;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    @Data
    class Pagination {
        int total;
        int pageSize;
        int pageIndex;
    }

    @Data
    class PageResp {
        private Pagination pagination;
        @JSONField(name = "list")
        private List<UserDTO> userDTOS;
    }


    /**
     * 从supos中获取指定 公司下所有 员工的信息
     * @return
     * @throws Exception
     */
    @Override
    public List<UserDTO> geyUsersFromSupos() throws Exception {
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("Authorization","Sign 73101af46504b78d84d3b12fab482777-78d654bc36ffc44ed46dcc02c11cb65c1ad9ce0039e0c6de977a27235601a74b");
        paramMap.put("Content-Type","application/json;charset=utf-8");
        HttpResponse response = HttpRequest.get("http://47.129.0.177:8080/open-api/auth/v2/users?companyCode=default_org_company")
                .addHeaders(paramMap)
                .execute();


        PageResp pagination = JSON.parseObject(response.body(), PageResp.class);

        System.out.println(JSON.toJSONString(pagination));

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");
        for (UserDTO userDTO : pagination.getUserDTOS()) {
            System.out.println(JSON.toJSONString(userDTO));
        }

        return pagination.getUserDTOS();
    }

    @Override
    public List<UserDTO> getSugarSmsUsersFromSupos() throws Exception {
        List<UserDTO> userDTOS = geyUsersFromSupos();

        List<UserDTO> sugarSmsUserDTO = new ArrayList<>();

        for (UserDTO userDTO : userDTOS) {
            for (RoleDTO roleDTO : userDTO.getUserRoleList()) {
                if (StringUtils.equals(roleDTO.getName(),"sugarsms")) {
                    sugarSmsUserDTO.add(userDTO);
                    break;
                }
            }
         }

        return sugarSmsUserDTO;
    }

    Map<String,String> buildGetParam(){
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("Context-Type","application/json;charset=utf-8");
//        paramMap.put("ak",AK);
//        paramMap.put("sk",SK);
        return paramMap;
    }

}
