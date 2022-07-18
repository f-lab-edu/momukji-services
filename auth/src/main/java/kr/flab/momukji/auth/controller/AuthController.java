package kr.flab.momukji.auth.controller;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.flab.momukji.auth.dto.request.GetUserDto;
import kr.flab.momukji.auth.dto.request.LoginDto;
import kr.flab.momukji.auth.dto.request.TokenDto;
import kr.flab.momukji.auth.dto.request.CallUserDto;
import kr.flab.momukji.auth.dto.request.ValidateDto;
import kr.flab.momukji.auth.dto.response.CommonResponse;
import kr.flab.momukji.auth.jwt.JwtFilter;
import kr.flab.momukji.auth.jwt.TokenProvider;
import kr.flab.momukji.auth.service.JwtService;
import kr.flab.momukji.auth.service.UserCallService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {

    private final JwtService jwtService;
    private final UserCallService userCallService;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    
    @PostMapping("/validate")
    public CommonResponse checkValidate(@RequestBody ValidateDto validateDto) {
        return jwtService.checkToken(validateDto.getToken());
    }

    @GetMapping("/callUser")
    public CallUserDto callUser(@RequestBody GetUserDto getUserDto) {
        return  userCallService.callUser(getUserDto).getBody();
    }

    @PostMapping("/authenticate")
    public ResponseEntity<TokenDto> authorize(@Valid @RequestBody LoginDto loginDto) {

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
