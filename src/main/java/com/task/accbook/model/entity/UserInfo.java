package com.task.accbook.model.entity;

import lombok.Data;

import java.util.List;

@Data
public class UserInfo {
    private String username;
    private List<String> roles;
}
