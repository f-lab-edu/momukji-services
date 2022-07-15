package kr.flab.momukji.auth.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import kr.flab.momukji.auth.dto.request.GetUserDto;

@FeignClient(name = "user", url = "http://localhost:8083")
public interface UserServiceClient {

    @GetMapping("/api/getUser")
    public ResponseEntity<?> getUser(@SpringQueryMap GetUserDto getUserDto);
}
