package com.task.accbook.model.web.service;

import com.task.accbook.core.orika.mapper.Mapper;
import com.task.accbook.model.web.dto.WebUserInfo;
import com.task.accbook.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebUserServiceImpl implements WebUserService {

    @Autowired
    private UserService userService;

    @Autowired
    private Mapper mapper;

    @Override
    public WebUserInfo getUserInfo() {
        return mapper.map(userService.getUserInfo(), WebUserInfo.class);
    }
}
