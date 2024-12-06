package org.niiish32x.fxsmsapp.user.app.dto;



import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * UserDTO
 *
 * @author shenghao ni
 * @date 2024.12.05 16:20
 */
@Data
public class UserDTO implements Serializable {

    @JSONField(name = "username")
    String username;


    String userDesc;
    int accountType;
    int lockStatus;
    int valid;
    String personCode;
    String personName;
    Date modifyTime;
    Date createTime;
    @JSONField(name = "userRoleList")
    List<RoleDTO> userRoleList;
}
