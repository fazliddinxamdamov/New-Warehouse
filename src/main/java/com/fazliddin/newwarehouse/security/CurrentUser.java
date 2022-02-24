package com.fazliddin.newwarehouse.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//return spring useri kim bo'lsa qaytarish
@AuthenticationPrincipal
public @interface CurrentUser {
}
