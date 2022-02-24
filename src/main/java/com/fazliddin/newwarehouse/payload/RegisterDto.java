package com.fazliddin.newwarehouse.payload;

import ai.ecma.lib.enums.LanguageEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author Murtazayev Muhammad
 * @since 21.12.2021
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RegisterDto {
    @NotBlank(message = "{FIRST_NAME_REQUIRED}")
    private String firstName;

    private String lastName;

    @NotBlank(message = "{VERIFICATION_CODE_REQUIRED}")
    private String verificationCode;

    @Pattern(regexp = "\\+[9]{2}[8][0-9]{9}", message = "{WRONG_PHONE_NUMBER_FORMAT}")
    @NotBlank(message = "{PHONE_NUMBER_REQUIRED}")
    private String phoneNumber;

    private LanguageEnum language;

    @NotNull
    private Long districtId;

}
