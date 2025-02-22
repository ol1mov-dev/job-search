package com.projects.project.commons;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum Role {
    USER(
            Set.of(
                    Permission.CAN_READ_POST
            )
    ),

    ADMIN(
            Set.of(
                    Permission.values()
            )
    ),

    MANAGER(Collections.emptySet());

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getGrantedAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission
                        -> new SimpleGrantedAuthority(permission.getPermission())
                )
                .collect(Collectors.toList());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
