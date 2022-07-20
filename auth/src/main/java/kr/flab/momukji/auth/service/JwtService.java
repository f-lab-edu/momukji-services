package kr.flab.momukji.auth.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import kr.flab.momukji.auth.dto.request.LoginDto;
import kr.flab.momukji.auth.dto.request.TokenDto;
import kr.flab.momukji.auth.dto.response.CommonResponse;
import kr.flab.momukji.auth.dto.response.ResultCode;
import kr.flab.momukji.auth.jwt.JwtFilter;
import kr.flab.momukji.auth.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public CommonResponse checkToken(String token) {

        if(!tokenProvider.validateToken(token)) {
            return new CommonResponse(ResultCode.INVALID_TOKEN);
        }

        return new CommonResponse(ResultCode.VALID_TOKEN);
    }

    public ResponseEntity<TokenDto> authorize(LoginDto loginDto) {
    
        UsernamePasswordAuthenticationToken authenticationToken =
        new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.createToken(authentication);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return new ResponseEntity<>(new TokenDto(jwt), httpHeaders, HttpStatus.OK);
    }
    
}
