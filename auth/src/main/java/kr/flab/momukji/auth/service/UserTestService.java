package kr.flab.momukji.auth.service;

import org.springframework.stereotype.Service;

import kr.flab.momukji.auth.dto.request.GetUserDto;
import kr.flab.momukji.auth.dto.response.common.CommonResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserTestService {
    
    private final UserServiceClient userServiceClient;

    public CommonResponse callUser(GetUserDto getUserDto) {
        System.out.println(getUserDto.getAuthCode()+ "수민2" +getUserDto.getEmail());
        return userServiceClient.getUser(getUserDto);
    }


}
