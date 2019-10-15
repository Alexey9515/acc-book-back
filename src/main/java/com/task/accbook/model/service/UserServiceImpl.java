package com.task.accbook.model.service;

import com.task.accbook.core.exception.CommonException;
import com.task.accbook.model.entity.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserInfo getUserInfo() {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            throw new CommonException("Пустой Security context");
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        userInfo.setRoles(SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()));
        return userInfo;
    }
}
