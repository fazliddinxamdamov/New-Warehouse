package com.fazliddin.newwarehouse.repository;

import com.fazliddin.newwarehouse.model.Role;
import com.fazliddin.newwarehouse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Fazliddin Xamdamov
 * @date 18.02.2022  16:59
 * @project New-Warehouse
 */

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {

    Optional<User> findByPhoneNumber(String phoneNumber);

}
