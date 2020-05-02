package com.spiros.view.api.v1;

import com.spiros.view.handler.UserControllerHandler;
import com.spiros.view.model.UserVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserControllerHandler userControllerHandler;

    @ApiOperation(value = "Gets user info by username")
    @GetMapping(value = "/username/{username}")
    public UserVo findUserByUsername(@PathVariable String username) {
        return userControllerHandler.findUserByUsernameHandler(username);
    }
}
