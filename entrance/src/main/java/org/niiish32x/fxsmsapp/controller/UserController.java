package org.niiish32x.fxsmsapp.controller;

import org.niiish32x.fxsmsapp.user.app.UserService;
import org.niiish32x.fxsmsapp.user.app.dto.UserDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * UserController
 *
 * @author shenghao ni
 * @date 2024.12.05 16:22
 */

@RestController
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/test/user")
    public List<UserDTO>  getUserFromSupos () {
        List<UserDTO> userDTOS = userService.geyUsersFromSupos();
        System.out.println(userDTOS);
        System.out.println("xxx");
        return new ArrayList<>();
    }
}
