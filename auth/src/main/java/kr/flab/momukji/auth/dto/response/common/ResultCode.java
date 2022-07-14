package kr.flab.momukji.auth.dto.response.common;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS("성공");

    
    private final String message;

    private ResultCode(String message) {
        this.message = message;
    }
}
