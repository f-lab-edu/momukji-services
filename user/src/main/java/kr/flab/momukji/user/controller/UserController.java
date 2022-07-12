package kr.flab.momukji.user.controller;

import javax.validation.Valid;

import kr.flab.momukji.user.dto.request.GetUserDto;
import kr.flab.momukji.user.dto.request.UserDto;
import kr.flab.momukji.user.dto.response.common.CommonResponse;
import kr.flab.momukji.user.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<CommonResponse> signup(@Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.signup(userDto));
    }

    @GetMapping("/getUser")
    public CommonResponse getUser(@RequestBody GetUserDto userDto) {
        return userService.getUser(userDto);
    }
}