package com.fazliddin.newwarehouse.model;

import com.fazliddin.newwarehouse.enums.Permission;
import com.fazliddin.newwarehouse.templete.AbsMain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Set;

/**
 * @author Fazliddin Xamdamov
 * @date 18.02.2022  10:52
 * @project New-Warehouse
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role extends AbsMain {
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Set<Permission> permissions;

    public Role(Integer id, String name, boolean active, Set<Permission> permissions) {
        super(id, name, active);
        this.permissions = permissions;
    }
}
