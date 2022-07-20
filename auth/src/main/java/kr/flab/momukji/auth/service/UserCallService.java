package kr.flab.momukji.auth.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import kr.flab.momukji.auth.dto.request.CallUserDto;
import kr.flab.momukji.auth.dto.request.GetUserDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserCallService {

    private final UserServiceClient userServiceClient;

    public ResponseEntity<CallUserDto> callUser(GetUserDto userDto) {
        return userServiceClient.getUser(userDto);
    }
    
}