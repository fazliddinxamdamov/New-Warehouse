package com.fazliddin.newwarehouse.model;

import com.fazliddin.newwarehouse.enums.Permission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author Fazliddin Xamdamov
 * @date 30.01.2022  17:40
 * @project New-Warehouse
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(value = AuditingEntityListener.class)
public class User implements UserDetails {

    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false , unique = true)
    private String phoneNumber;

    private String code;

    @Column(nullable = false)
    private String password;
    private boolean active = true;

    @ManyToOne
    private Role role;

    private boolean enabled;
    private boolean accountNonLocked = true;
    private boolean accountNonExpired = true;
    private boolean credentialsNonExpired = true;

    @Column(updatable = false)
    @CreatedBy
    private UUID createdBy;

    @CreationTimestamp
    private Timestamp createdAt;

    @LastModifiedBy
    private UUID updatedBy;

    @UpdateTimestamp
    @LastModifiedDate
    private Timestamp updatedAt;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Permission> permissionSet = role.getPermissions();

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Permission permission : permissionSet) {
            grantedAuthorities.add(new SimpleGrantedAuthority(permission.name()));
        }
        return grantedAuthorities;
    }

    @Override
    public String getUsername() {
        return phoneNumber;
    }
}
