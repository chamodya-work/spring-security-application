package com.security.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class ProjectSecurityConfig {
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/account/my-account", "/api/v1/loan/my-loan").authenticated()
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
//                        .defaultSuccessUrl("/dashboard", true) // Redirect after login
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // Logout endpoint
                        .logoutSuccessUrl("/") // Redirect after logout
                        .permitAll()
                );

        return http.build();
    }
}
