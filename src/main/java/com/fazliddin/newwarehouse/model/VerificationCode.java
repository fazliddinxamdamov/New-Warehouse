package com.fazliddin.newwarehouse.model;

import com.fazliddin.newwarehouse.templete.AbsMain;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author Murtazayev Muhammad
 * @since 14.01.2022
 */
@Entity
@Table(name = "verification_code")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Where(clause = "deleted=false")
@SQLDelete(sql = "update verification_code set deleted = false where id = ?")
public class VerificationCode extends AbsMain {
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "code", nullable = false)
    private String code;

    private boolean used;

    private Timestamp expireTime = new Timestamp(System.currentTimeMillis() + ((1000 * 60) * 3));

    public VerificationCode(String phoneNumber, String code) {
        this.phoneNumber = phoneNumber;
        this.code = code;
    }
}
