package kr.flab.momukji.auth.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import kr.flab.momukji.auth.dto.request.CallUserDto;
import kr.flab.momukji.auth.dto.request.GetUserDto;

@FeignClient(name = "user")
public interface UserServiceClient {

    @GetMapping(value = "/api/getUser")
    public ResponseEntity<CallUserDto> getUser(@SpringQueryMap GetUserDto userDto);
    
}
 