package kr.flab.momukji.auth.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import kr.flab.momukji.auth.dto.request.CallUserDto;
import kr.flab.momukji.auth.dto.request.GetUserDto;
import kr.flab.momukji.auth.dto.request.CallUserDto.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private final UserServiceClient userServiceClient;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String email) {
        GetUserDto getUserDto = new GetUserDto(email, "code");
        CallUserDto result = userServiceClient.getUser(getUserDto).getBody();
       
        if(result.getResultCode() != "SUCCESS") {
            new UsernameNotFoundException(email + " -> 데이터베이스에서 찾을 수 없습니다.");
        }

        String userEmail = result.getUser().getEmail();
        return createUser(userEmail, result.getUser());
    }

    private org.springframework.security.core.userdetails.User createUser(String username, User user) {
        if (user.getDeleted()) {
            throw new RuntimeException(username + " -> 활성화되어 있지 않습니다.");
        }
        List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }
}