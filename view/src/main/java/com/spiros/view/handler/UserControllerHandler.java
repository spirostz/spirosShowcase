package com.spiros.view.handler;

import com.spiros.core.service.UserService;
import com.spiros.view.model.UserVo;
import com.spiros.view.transformer.UserVoTransformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserControllerHandler {

    @Autowired
    private UserService userService;

    @Autowired
    private UserVoTransformer userVoTransformer;

    public UserVo findUserByUsernameHandler(final String username) {

        return userVoTransformer.fromTransferToVisual(
                userService.fetchByUsername(username)
                        .orElse(null))
                .orElseThrow(() -> new IllegalArgumentException("User not found, please specify an existing user"));
    }

}
