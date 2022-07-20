package kr.flab.momukji.user.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetUserDto {
    
    private String email;
    private String authCode;
}