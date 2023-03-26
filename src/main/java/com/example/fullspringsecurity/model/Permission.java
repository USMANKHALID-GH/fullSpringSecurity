package com.example.fullspringsecurity.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;


@AllArgsConstructor
@NoArgsConstructor
@Getter

public enum Permission {
    STUDENT_READ("student:write"),
    STUDENT_WRITE("student:read"),
    COURSE_READ("admin:write"),
    COURSE_WRITE("admin:read");

    private  String permission;


}
