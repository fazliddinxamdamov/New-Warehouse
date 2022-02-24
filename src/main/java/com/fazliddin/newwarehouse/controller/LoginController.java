package com.fazliddin.newwarehouse.controller;

import com.fazliddin.newwarehouse.model.Role;
import com.fazliddin.newwarehouse.payload.ApiResponse;
import com.fazliddin.newwarehouse.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

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
