package kr.flab.momukji.auth.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserDto {
    private String email;
    private String authCode;
}
