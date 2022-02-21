package com.fazliddin.security;

import com.fazliddin.newwarehouse.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Fazliddin Xamdamov
 * @date 18.02.2022  17:30
 * @project New-Warehouse
 */
@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {


    private final JwtProvider jwtProvider;
    private final AuthService myAuthService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer")) {
            token = token.substring(7);
            boolean validateToken = jwtProvider.validateToken(token);
            if (validateToken) {
                String username = jwtProvider.getUsernameFromToken(token);

                UserDetails userDetails = myAuthService.loadUserByUsername(username);

                UsernamePasswordAuthenticationToken passwordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

//                System.out.println(SecurityContextHolder.getContext().getAuthentication());
                SecurityContextHolder.getContext().setAuthentication(passwordAuthenticationToken);
//                System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
            }
        }
        filterChain.doFilter(request, response);
    }
}
