package kr.flab.momukji.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.flab.momukji.auth.dto.request.GetUserDto;
import kr.flab.momukji.auth.dto.response.common.CommonResponse;
import kr.flab.momukji.auth.service.UserTestService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthTestController {

    private final UserTestService userTestService;
    
    @GetMapping("/api/callUser")
    public CommonResponse getUser(@RequestBody GetUserDto getUserDto) {
        System.out.println(getUserDto.getAuthCode()+ "수민" +getUserDto.getEmail());
        return userTestService.callUser(getUserDto);
    }
}
