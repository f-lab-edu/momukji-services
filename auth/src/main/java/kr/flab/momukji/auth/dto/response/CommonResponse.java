package kr.flab.momukji.auth.dto.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {
    public ResultCode resultCode = ResultCode.SUCCESS;
}
