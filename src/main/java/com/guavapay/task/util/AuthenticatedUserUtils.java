package com.guavapay.task.util;

import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticatedUserUtils {

    public static CustomUserDetails CURRENT_USER() {
        return (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static String USERNAME() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getDetails());
        return ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    }

}
