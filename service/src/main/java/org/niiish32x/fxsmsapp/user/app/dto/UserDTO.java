package org.niiish32x.fxsmsapp.user.app.dto;



import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * UserDTO
 *
 * @author shenghao ni
 * @date 2024.12.05 16:20
 */
public class UserDTO implements Serializable {
    String username;
    String userDesc;
    int accountType;
    int lockStatus;
    int valid;
    String personCode;
    String personName;
    Date modifyTime;
    Date createTime;
    List<RoleDTO> userRoleList;
}
