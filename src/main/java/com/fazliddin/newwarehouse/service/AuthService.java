package com.fazliddin.newwarehouse.service;

import com.fazliddin.newwarehouse.RestException;
import com.fazliddin.newwarehouse.enums.RoleTypeEnum;
import com.fazliddin.newwarehouse.model.Role;
import com.fazliddin.newwarehouse.model.User;
import com.fazliddin.newwarehouse.model.VerificationCode;
import com.fazliddin.newwarehouse.payload.*;
import com.fazliddin.newwarehouse.repository.RoleRepo;
import com.fazliddin.newwarehouse.repository.UserRepo;
import com.fazliddin.newwarehouse.repository.VerificationCodeRepo;
import com.fazliddin.newwarehouse.security.JwtFilter;
import com.fazliddin.newwarehouse.security.JwtProvider;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

/**
 * @author Fazliddin Xamdamov
 * @date 18.02.2022  17:24
 * @project New-Warehouse
 */
@Service
public class AuthService implements UserDetailsService {

    private final UserRepo userRepo;
    private final JwtFilter jwtFilter;
    private final JwtProvider jwtProvider;
    private final AuthenticationManager authenticationManager;
    private final RoleRepo roleRepo;
    private final VerificationCodeRepo verificationCodeRepo;



    @Lazy
    public AuthService(UserRepo userRepo, JwtFilter jwtFilter, JwtProvider jwtProvider, AuthenticationManager authenticationManager, RoleRepo roleRepo, VerificationCodeRepo verificationCodeRepo) {
        this.userRepo = userRepo;
        this.jwtFilter = jwtFilter;
        this.jwtProvider = jwtProvider;
        this.authenticationManager = authenticationManager;
        this.roleRepo = roleRepo;
        this.verificationCodeRepo = verificationCodeRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepo.findByPhoneNumber(username);
        return optionalUser.orElse(null);
    }

    public ApiResult<?> signUp(RegisterDto dto) {
        VerificationCode verificationCode = verificationCodeRepo.checkVerificationCode
                        (dto.getPhoneNumber(), dto.getVerificationCode(), new Timestamp(System.currentTimeMillis()));
        if (verificationCode == null) {
            throw RestException.restThrow(MessageService.getMessage("VERIFICATION_CODE_NOT_AVAILABLE"), HttpStatus.BAD_REQUEST);
        }
        Role roleUser = roleRepo.findByRoleType(RoleTypeEnum.USER);
        if (roleUser == null) {
            RestException.restThrow(MessageService.getMessage("ROLE_NOT_FOUND"), HttpStatus.NOT_FOUND);
        }

        verificationCode.setUsed(true);
        verificationCodeRepo.save(verificationCode);

        String accessToken = jwtProvider.generateToken(dto.getPhoneNumber());
        String refreshToken = jwtProvider.generateToken(dto.getPhoneNumber());

        return ApiResult.successResponse(new CheckUserRegisterDto(accessToken, refreshToken));
    }

//    public ApiResult<TokenDto> login(LoginDto loginDto) {
//        try {
//            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
//            UserPrincipal userPrincipal = (UserPrincipal) authenticate.getPrincipal();
////            User user = userPrincipal.getUser();
//            User user = (User) userPrincipal.getUser();
//            String accessToken = jwtProvider.generateToken(user.getPhoneNumber());
//            String refreshToken = jwtProvider.generateToken(user.getPhoneNumber());
//            return ApiResult.successResponse(new TokenDto(accessToken, refreshToken));
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw RestException.restThrow(MessageService.getMessage("WRONG_USERNAME_OR_PASSWORD"), HttpStatus.FORBIDDEN);
//        }
//    }

    // todo control signUp


//    public ApiResult<TokenDto> refreshToken(TokenDto dto) {
//        try {
//            jwtProvider.validateToken(dto.getAccessToken());
//            return ApiResult.successResponse(dto);
//        } catch (ExpiredJwtException exception) {
//            Claims claims = exception.getClaims();
//            String subject = claims.getSubject();
//
//            try {
//                jwtProvider.validateToken(dto.getRefreshToken());
//                String username = jwtProvider.getUsernameFromToken(dto.getRefreshToken());
//                if (!username.equals(subject)) {
//                    throw RestException.forbidden();
//                }
//                String accessToken = jwtProvider.generateToken(username, true);
//                String refreshToken = jwtProvider.generateToken(username, false);
//                return ApiResult.successResponse(new TokenDto(accessToken, refreshToken));
//            } catch (Exception e) {
//                throw RestException.forbidden();
//            }
//        } catch (Exception e) {
//            throw RestException.forbidden();
//        }
//
//    }
//    public String generateCode() {
//        StringBuilder verificationCode = new StringBuilder();
//        for (int i = 0; i < 5; i++) {
//            verificationCode.append((int) (Math.random() * 10));
//        }
//        return verificationCode.toString();
//    }


}
