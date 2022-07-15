package kr.flab.momukji.auth.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.flab.momukji.auth.dto.request.ValidateDto;
import kr.flab.momukji.auth.dto.response.CommonResponse;

import kr.flab.momukji.auth.service.JwtService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {

    private final JwtService jwtService;
    
    @PostMapping("/validate")
    public CommonResponse checkValidate(@RequestBody ValidateDto validateDto) {
        return jwtService.checkToken(validateDto.getToken());
    }
}
