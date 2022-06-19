package kr.flab.momukji.dto.response.common;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS("성공"),
    DUPLICATED_EMAIL("중복된 이메일"),
    INVALID_STORE_ID("유효하지 않은 상점 ID"), INVALID_PRODUCT_ID("유효하지 않은 상품 ID"),
    INVALID_ORDER_ID("유효하지 않은 주문 ID");
    
    private final String message;

    private ResultCode(String message) {
        this.message = message;
    }
}
