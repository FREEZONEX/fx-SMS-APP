package org.niiish32x.fxsmsapp.user.app.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * RoleDTO
 *
 * @author shenghao ni
 * @date 2024.12.05 16:21
 */
@Data
public class RoleDTO implements Serializable {
    String name;
    String showname;
    String description;
    String avatar;
}
