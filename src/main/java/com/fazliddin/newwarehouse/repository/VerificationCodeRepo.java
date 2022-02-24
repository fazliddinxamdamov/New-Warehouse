package com.fazliddin.newwarehouse.repository;

import com.fazliddin.newwarehouse.model.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * @author Fazliddin Xamdamov
 * @date 24.02.2022  11:13
 * @project New-Warehouse
 */
public interface VerificationCodeRepo extends JpaRepository<VerificationCode , UUID> {
    VerificationCode checkVerificationCode(String phoneNumber, String verificationCode, Timestamp timestamp);
}
