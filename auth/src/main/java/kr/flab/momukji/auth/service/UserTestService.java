package kr.flab.momukji.auth.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import kr.flab.momukji.auth.dto.request.GetUserDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserTestService {
    
    private final UserServiceClient userServiceClient;

    public ResponseEntity<?> callUser(GetUserDto getUserDto) {
        System.out.println(getUserDto.getAuthCode()+ "수민2" +getUserDto.getEmail());
        return userServiceClient.getUser(getUserDto);
    }


}
