package com.example.taskmanagement.dto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role /*implements GrantedAuthority */{
    USER("USER"), ADMIN("ADMIN");

    private final String vale;
//    @Override
//    public String getAuthority() {
//        return vale;
//    }
}