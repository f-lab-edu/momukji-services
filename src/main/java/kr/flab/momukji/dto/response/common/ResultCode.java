package kr.flab.momukji.dto.response.common;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS("성공"), DUPLICATED_EMAIL("중복된 이메일");
    
    private final String message;

    private ResultCode(String message) {
        this.message = message;
    }
}
