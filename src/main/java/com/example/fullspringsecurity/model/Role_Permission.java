package com.example.fullspringsecurity.model;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.fullspringsecurity.model.Permission.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Role_Permission {
    STUDENT(new HashSet<>()),
    ADMIN(Sets.newHashSet(STUDENT_READ,COURSE_READ,COURSE_WRITE ,STUDENT_WRITE));

    private Set<Permission> permission;

    public Set<SimpleGrantedAuthority> grantedAuthority(){
        Set<SimpleGrantedAuthority> permissions=getPermission()
                .stream()
                .map(role-> new SimpleGrantedAuthority(role.getPermission()))
                .collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return permissions;
    }
}
