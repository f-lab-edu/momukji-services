package kr.flab.momukji.user.dto.response.common;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {
    public ResultCode resultCode = ResultCode.SUCCESS;
}
