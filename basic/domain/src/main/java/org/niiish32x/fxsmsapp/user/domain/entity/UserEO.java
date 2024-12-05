package org.niiish32x.fxsmsapp.user.domain.entity;

import org.niiish32x.fxsmsapp.role.domain.entity.RoleEO;

import java.util.Date;
import java.util.List;

/**
 * User
 *
 * @author shenghao ni
 * @date 2024.12.05 16:00
 */
public class UserEO {
    String username;
    String userDesc;
    int accountType;
    int lockStatus;
    int valid;
    String personCode;
    String personName;
    Date modifyTime;
    Date createTime;
    List<RoleEO> userRoleList;

}
