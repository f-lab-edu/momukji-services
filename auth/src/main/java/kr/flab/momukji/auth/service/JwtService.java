package kr.flab.momukji.auth.service;

import org.springframework.stereotype.Service;
import kr.flab.momukji.auth.dto.response.CommonResponse;
import kr.flab.momukji.auth.dto.response.ResultCode;
import kr.flab.momukji.auth.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final TokenProvider tokenProvider;

    public CommonResponse checkToken(String token) {

        if(!tokenProvider.validateToken(token)) {
            return new CommonResponse(ResultCode.INVALID);
        }

        return new CommonResponse(ResultCode.VALID);
    }
    
}
