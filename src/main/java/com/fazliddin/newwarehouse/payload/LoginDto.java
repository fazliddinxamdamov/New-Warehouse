package com.fazliddin.newwarehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
public class LoginDto {
    @NotBlank(message = "{USERNAME_REQUIRED}")
    private String username;

    @NotBlank(message = "{PASSWORD_REQUIRED}")
    private String password;

}
