package kr.flab.momukji.user.dto.response.common;

import lombok.Getter;

@Getter
public enum ResultCode {
    
    SUCCESS("성공"),
    DUPLICATED_EMAIL("중복된 이메일"),
    INVALID_STORE_ID("유효하지 않은 상점 ID"), INVALID_PRODUCT_ID("유효하지 않은 상품 ID"),
    INVALID_ORDER_ID("유효하지 않은 주문 ID"),
    EMAIL_NOT_EXIST("존재하지 않는 아이디"),
    INVALID_AUTH_CODE("유효하지 않은 AUTH_CODE");
    
    private final String message;

    private ResultCode(String message) {
        this.message = message;
    }
}
