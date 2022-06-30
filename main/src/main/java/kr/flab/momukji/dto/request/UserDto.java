package kr.flab.momukji.dto.request;

import java.util.stream.Collectors;
import java.util.Set;

import kr.flab.momukji.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotNull
    @Size(max = 100)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    @Size(max = 100)
    private String password;

    @NotNull
    @Size(max = 50)
    private String contact;

    @NotNull
    @Size(max = 100)
    private String address;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long money = 0L;

    private Set<AuthorityDto> authorityDtoSet;

    public static UserDto from(User user) {
        if(user == null) return null;

        return UserDto.builder()
            .email(user.getEmail())
            .contact(user.getContact())
            .address(user.getAddress())
            .authorityDtoSet(user.getAuthorities().stream()
                    .map(authority -> AuthorityDto.builder().authorityName(authority.getAuthorityName()).build())
                    .collect(Collectors.toSet()))
            .money(user.getMoney())
            .build();
    }

}