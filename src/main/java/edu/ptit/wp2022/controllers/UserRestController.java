package edu.ptit.wp2022.controllers;

import edu.ptit.wp2022.common.RestApi;
import edu.ptit.wp2022.dto.user.UserDto;
import edu.ptit.wp2022.services.UserServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestApi.User.MAIN)
public class UserRestController {
    private final UserServices userServices;

    public UserRestController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/{username}" + RestApi.Common.DETAIL)
    public UserDto getUserByUsername(@PathVariable String username) {
        return userServices.getUserInfoByUsername(username);
    }
}
