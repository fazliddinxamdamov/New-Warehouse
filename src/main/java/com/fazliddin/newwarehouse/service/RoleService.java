package com.fazliddin.newwarehouse.service;

import com.fazliddin.newwarehouse.model.Role;
import com.fazliddin.newwarehouse.payload.ApiResponse;
import com.fazliddin.newwarehouse.repository.RoleRepo;
import org.springframework.stereotype.Service;

/**
 * @author Fazliddin Xamdamov
 * @date 18.02.2022  16:57
 * @project New-Warehouse
 */
@Service
public class RoleService {

   private final RoleRepo roleRepo;

    public RoleService(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public ApiResponse add(Role role) {
        Role newRole = new Role();
        if (!roleRepo.existsByName(role.getName())) {
            newRole = roleRepo.save(
                    new Role(role.getId(), role.getName(), role.isActive(), role.getPermissions())
            );
        }
        return new ApiResponse("Saved Role", true, newRole);
    }
}
