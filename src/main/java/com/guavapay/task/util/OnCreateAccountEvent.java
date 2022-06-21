package com.guavapay.task.util;

import com.guavapay.task.dto.UserDTO;
import org.springframework.context.ApplicationEvent;

public class OnCreateAccountEvent extends ApplicationEvent {
    private String appUrl;
    private UserDTO userDTO;

    public OnCreateAccountEvent(UserDTO userDTO, String appUrl) {
        super(userDTO);

        this.userDTO = userDTO;
        this.appUrl = appUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public UserDTO getAccount() {
        return userDTO;
    }
}
