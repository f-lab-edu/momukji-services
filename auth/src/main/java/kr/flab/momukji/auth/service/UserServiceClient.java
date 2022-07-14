package kr.flab.momukji.auth.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import kr.flab.momukji.auth.dto.request.GetUserDto;
import kr.flab.momukji.auth.dto.response.common.CommonResponse;

@FeignClient(name = "user", url = "http://localhost:8083")
public interface UserServiceClient {

    @GetMapping("/api/getUser")
    public CommonResponse getUser(@RequestBody GetUserDto getUserDto);
}
