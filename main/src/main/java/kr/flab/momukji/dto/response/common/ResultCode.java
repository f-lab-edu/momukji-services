package kr.flab.momukji.dto.response.common;

import lombok.Getter;

@Getter
public enum ResultCode {
    
    SUCCESS("성공"),
    DUPLICATED_EMAIL("중복된 이메일"),
    INVALID_STORE_ID("유효하지 않은 상점 ID"), INVALID_PRODUCT_ID("유효하지 않은 상품 ID"),
    INVALID_ORDER_ID("유효하지 않은 주문 ID"),
    LOGIN_REQUIRED("로그인 필요"), INVALID_ACCOUNT("유효하지 않은 계정"),
    STORE_CLOSED("가게 문이 아직 열리지 않았습니다");
    
    private final String message;

    private ResultCode(String message) {
        this.message = message;
    }
}
