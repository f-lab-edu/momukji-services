package kr.flab.momukji.auth.dto.request;

import java.time.LocalDateTime;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class CallUserDto {
 
    private String resultCode;
    private User user;

    @Getter
    @ToString
    @Setter
    public static class User {
        
        private String email;
        private String password;
        private String contact;
        private String address;
        private Long money; 
        private Boolean deleted;
        private LocalDateTime createdTimestamp;
        private LocalDateTime updatedTimestamp;
        private Set<Authority> authorities;
    }

    @Getter
    @ToString
    @Setter
    public static class Authority {
        private String authorityName;
    }
}
