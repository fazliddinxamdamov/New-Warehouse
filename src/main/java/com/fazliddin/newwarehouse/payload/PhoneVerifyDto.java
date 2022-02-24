package com.fazliddin.newwarehouse.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author Murtazayev Muhammad
 * @since 21.12.2021
 */
@Setter
@Getter
public class PhoneVerifyDto {

    @NotBlank(message = "{VERIFICATION_CODE_REQUIRED}")
    private String verificationCode;

    @Pattern(regexp = "\\+[9]{2}[8][0-9]{9}", message = "{WRONG_PHONE_NUMBER_FORMAT}")
    @NotBlank(message = "{PHONE_NUMBER_REQUIRED}")
    private String phoneNumber;
}
