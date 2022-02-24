package com.fazliddin.newwarehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Murtazayev Muhammad
 * @since 21.12.2021
 */
@Setter
@Getter
@AllArgsConstructor
public class CheckUserRegisterDto {
    private String accessToken;
    private String refreshToken;
    private boolean registered;

    public CheckUserRegisterDto() {
        this.accessToken = null;
        this.refreshToken = null;
        this.registered = false;
    }

    public CheckUserRegisterDto(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.registered = true;
    }
}
