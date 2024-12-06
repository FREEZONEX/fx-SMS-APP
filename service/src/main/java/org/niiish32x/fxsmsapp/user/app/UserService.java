package org.niiish32x.fxsmsapp.user.app;


import org.niiish32x.fxsmsapp.user.app.dto.UserDTO;

import java.util.List;

/**
 * UserService
 *
 * @author shenghao ni
 * @date 2024.12.05 16:24
 */
public interface UserService {
    List<UserDTO> geyUsersFromSupos() throws Exception;

    List<UserDTO> getSugarSmsUsersFromSupos () throws Exception;
}
