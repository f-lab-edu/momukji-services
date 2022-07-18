package kr.flab.momukji.auth.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserDto {

    private String email;
    private String authCode;

    public GetUserDto() { }

    public GetUserDto(String email, String authCode) {
        this.email = email;
        this.authCode = authCode;
    }
}
