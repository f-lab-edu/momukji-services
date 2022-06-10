package kr.flab.momukji.dto.response;

import kr.flab.momukji.dto.response.common.CommonResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto extends CommonResponse {
    private String token;
}
