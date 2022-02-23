package com.fazliddin.newwarehouse.service;

import com.fazliddin.newwarehouse.model.User;
import com.fazliddin.newwarehouse.repository.UserRepo;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Fazliddin Xamdamov
 * @date 18.02.2022  17:24
 * @project New-Warehouse
 */
@Service
public class AuthService implements UserDetailsService {

    private final UserRepo userRepo;

    @Lazy
    public AuthService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepo.findByPhoneNumber(username);
        return optionalUser.orElse(null);
    }
}
