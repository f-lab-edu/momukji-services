package kr.flab.momukji.dto.request;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcceptOrderDto {
    
    @NotNull
    private Long orderId;
    
    @NotNull
    private Long estimatedMinutes;
}