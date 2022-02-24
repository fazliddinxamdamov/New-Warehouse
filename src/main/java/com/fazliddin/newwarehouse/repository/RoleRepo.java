package com.fazliddin.newwarehouse.repository;

import com.fazliddin.newwarehouse.enums.RoleTypeEnum;
import com.fazliddin.newwarehouse.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Fazliddin Xamdamov
 * @date 18.02.2022  16:59
 * @project New-Warehouse
 */

@Repository
public interface RoleRepo extends JpaRepository<Role , UUID> {

    Boolean existsByName(String name);

    Role findByRoleType(RoleTypeEnum user);
}
