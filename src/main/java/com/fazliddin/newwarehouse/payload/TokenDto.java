package com.fazliddin.newwarehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
public class TokenDto {

    @NotBlank(message = "{ACCESS_TOKEN_REQUIRED}")
    private String accessToken;

    @NotBlank(message = "{REFRESH_TOKEN_REQUIRED}")
    private String refreshToken;


}
