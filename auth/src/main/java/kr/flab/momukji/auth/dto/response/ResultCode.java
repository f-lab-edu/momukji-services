package kr.flab.momukji.auth.dto.response;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS("성공"),VALID("유효한 토큰"), INVALID("잘못된 토큰");

    private final String message;

    private ResultCode(String message) {
        this.message = message;
    }
}
