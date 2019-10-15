package com.task.accbook.api;

import com.task.accbook.model.web.dto.WebUserInfo;
import com.task.accbook.model.web.service.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userinfo")
public class UserController {

    @Autowired
    private WebUserService webUserService;

    @RequestMapping(method = RequestMethod.GET)
    public WebUserInfo getUserInfo(){
        return webUserService.getUserInfo();
    }
}
