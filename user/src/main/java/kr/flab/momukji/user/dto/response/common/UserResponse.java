package kr.flab.momukji.user.dto.response.common;

import kr.flab.momukji.user.entity.User;
import lombok.Getter;

@Getter
public class UserResponse extends CommonResponse {
    private User user;

    public UserResponse(User user) {
        this.resultCode = ResultCode.SUCCESS;
        this.user = user;
    }
}
