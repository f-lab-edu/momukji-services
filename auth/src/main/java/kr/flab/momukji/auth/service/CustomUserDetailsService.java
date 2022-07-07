package kr.flab.momukji.auth.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String email) {
        // TODO 구현 필요
        //    return userRepository.findOneWithAuthoritiesByEmail(email)
        //       .map(user -> createUser(email, user))
        //       .orElseThrow(() -> new UsernameNotFoundException(email + " -> 데이터베이스에서 찾을 수 없습니다."));
        return null;
    }

    // private org.springframework.security.core.userdetails.User createUser(String username, User user) {
    //     if (user.getDeleted()) {
    //         throw new RuntimeException(username + " -> 활성화되어 있지 않습니다.");
    //     }
    //     List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
    //             .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName()))
    //             .collect(Collectors.toList());
    //     return new org.springframework.security.core.userdetails.User(user.getEmail(),
    //             user.getPassword(),
    //             grantedAuthorities);
    // }
}