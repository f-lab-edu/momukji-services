package kr.flab.momukji.user.service;

import java.util.Collections;

import kr.flab.momukji.user.dto.request.UserDto;
import kr.flab.momukji.user.dto.response.common.CommonResponse;
import kr.flab.momukji.user.dto.response.common.ResultCode;
import kr.flab.momukji.user.entity.Authority;
import kr.flab.momukji.user.entity.User;
import kr.flab.momukji.user.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public CommonResponse signup(UserDto userDto) {
        if (userRepository.findOneWithAuthoritiesByEmail(userDto.getEmail()).orElse(null) != null) {
            return new CommonResponse(ResultCode.DUPLICATED_EMAIL);
        }

        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        User user = User.builder()
                .email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .contact(userDto.getContact())
                .address(userDto.getAddress())
                .authorities(Collections.singleton(authority))
                .money(0L)
                .deleted(false)
                .build();
        userRepository.save(user);

        return new CommonResponse();
    }

    @Transactional(readOnly = true)
    public User getUserWithAuthorities(String email) {
        return userRepository.findOneWithAuthoritiesByEmail(email).orElse(null);
    }
}