package org.balaji.multiplex.application.controller;

import org.balaji.multiplex.application.domain.Users;
import org.balaji.multiplex.application.service.UsersService;
import org.balaji.multiplex.application.service.mapping.UsersVoMappingService;
import org.balaji.multiplex.application.utils.co.UserCo;
import org.balaji.multiplex.application.utils.vo.UserVo;
import org.balaji.multiplex.commons.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController<Users, UserCo, UserVo> {


    private UsersService usersService;
    private UsersVoMappingService usersVoMappingService;

    public UserController(UsersService usersService, UsersVoMappingService usersVoMappingService) {
        super(usersService, usersVoMappingService);
        this.usersService = usersService;
        this.usersVoMappingService = usersVoMappingService;
    }
}
