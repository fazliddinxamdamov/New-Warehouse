package com.fazliddin.newwarehouse.controller;

import com.fazliddin.newwarehouse.model.Role;
import com.fazliddin.newwarehouse.payload.ApiResponse;
import com.fazliddin.newwarehouse.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

/**
 * @author Fazliddin Xamdamov
 * @date 18.02.2022  16:56
 * @project New-Warehouse
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/role")
public class RoleController {

   private final RoleService roleService;

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody Role role) throws ParseException {
        ApiResponse response = roleService.add(role);
        return ResponseEntity.ok(response);
    }


}
