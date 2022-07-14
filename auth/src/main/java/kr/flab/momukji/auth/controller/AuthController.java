package kr.flab.momukji.auth.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestHeader;

import kr.flab.momukji.auth.dto.response.CommonResponse;

import kr.flab.momukji.auth.service.JwtService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {

    private final JwtService jwtService;
    
    @PostMapping("/validate")
    public CommonResponse checkValidate(@RequestHeader("Token") String token) {
        return jwtService.checkToken(token);
    }
}
