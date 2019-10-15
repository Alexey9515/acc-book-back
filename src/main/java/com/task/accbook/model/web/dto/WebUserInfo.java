package com.task.accbook.model.web.dto;

import lombok.Data;

import java.util.List;

@Data
public class WebUserInfo {
    private String name;
    private List<String> roles;
}
