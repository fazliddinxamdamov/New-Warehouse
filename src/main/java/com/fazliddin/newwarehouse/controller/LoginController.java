package com.fazliddin.newwarehouse.controller;

import com.fazliddin.newwarehouse.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fazliddin Xamdamov
 * @date 18.02.2022  16:56
 * @project New-Warehouse
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/login")
public class LoginController {
   private final RoleService roleService;
}
