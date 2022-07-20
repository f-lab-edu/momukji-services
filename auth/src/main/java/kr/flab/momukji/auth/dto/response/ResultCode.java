package kr.flab.momukji.auth.dto.response;

import lombok.Getter;

@Getter
public enum ResultCode {
    
    SUCCESS("성공"), VALID_TOKEN("유효한 토큰"), INVALID_TOKEN("잘못된 토큰");

    private final String message;

    private ResultCode(String message) {
        this.message = message;
    }
}
