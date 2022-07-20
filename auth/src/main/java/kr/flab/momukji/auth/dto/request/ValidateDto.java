package kr.flab.momukji.auth.dto.request;

import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class ValidateDto {
    
    @NotNull
    private String token;
}
