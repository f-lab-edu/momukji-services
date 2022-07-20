package kr.flab.momukji.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
    
    @NotNull
    private Long regionId;
    
    @NotNull
    private Long storeId;
    
    @NotNull
    private boolean isDelivery;
    
    @Size(max = 100)
    private String message;
    
    @NotNull
    private Long[] productIds;
}
