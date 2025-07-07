package com.example.exception;

import lombok.Getter;

@Getter
public enum MessageType {

    POLICY_BULUNAMADI("555","Policy Bulunamadi!");

    private String message;
    private String code;

    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }


}
