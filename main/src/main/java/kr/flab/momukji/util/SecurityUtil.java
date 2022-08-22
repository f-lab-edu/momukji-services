package kr.flab.momukji.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.flab.momukji.jwt.TokenProvider;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Component
public class SecurityUtil {

    @Autowired
    private TokenProvider tokenProvider;
    
    public String getEmailByToken(String token) {
        return tokenProvider.getPrincipal(token);
    }
}