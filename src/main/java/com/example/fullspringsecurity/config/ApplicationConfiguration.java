package com.example.fullspringsecurity.config;


import com.example.fullspringsecurity.model.Role_Permission;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.security.web.SecurityFilterChain;

import static com.example.fullspringsecurity.model.Permission.COURSE_READ;
import static com.example.fullspringsecurity.model.Role_Permission.ADMIN;
import static com.example.fullspringsecurity.model.Role_Permission.STUDENT;

@EnableWebSecurity
@Configuration
public class ApplicationConfiguration {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
//                .requestMatchers("/api/any/**").permitAll()
                .requestMatchers("/api/any/**").permitAll()
                .requestMatchers("/api/student/**").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/api/student/**").hasAuthority(COURSE_READ.name())
                .requestMatchers(HttpMethod.POST,"/api/student/**").hasAuthority(COURSE_READ.name())
//                .requestMatchers(HttpMethod.GET,"/api/student/**").hasAuthority(ADMIN.name())
//                .requestMatchers(HttpMethod.POST,"/api/student/**").hasAuthority(ADMIN.name())
                .anyRequest().authenticated()





//                anyRequest().authenticated()
                .and()
                .httpBasic();
        return http.build();
    }


    @Bean
    public UserDetailsService userDetailsService(){
        User.UserBuilder user =
                User.builder().username("usman")
                        .password(passwordEncoder().encode("123"))
//                        .roles(ADMIN.name())
                        .authorities(ADMIN.grantedAuthority());
        User.UserBuilder user1 =
                User.builder().username("usman1")
                        .password(passwordEncoder().encode("1234"))
                        .authorities(STUDENT.grantedAuthority());
        return  new InMemoryUserDetailsManager(user.build(),user1.build());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
         return  new BCryptPasswordEncoder();
    }
}
