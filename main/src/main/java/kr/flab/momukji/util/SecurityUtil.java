package kr.flab.momukji.util;

import org.springframework.beans.factory.annotation.Autowired;

import kr.flab.momukji.jwt.TokenProvider;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SecurityUtil {

    @Autowired
    private TokenProvider tokenProvider;
    
    public String getEmailByToken(String token) {
        return tokenProvider.getPrincipal(token);
    }
}