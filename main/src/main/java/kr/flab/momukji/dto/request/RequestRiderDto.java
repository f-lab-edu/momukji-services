package kr.flab.momukji.dto.request;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestRiderDto {
    @NotNull
    Long orderId;
}
