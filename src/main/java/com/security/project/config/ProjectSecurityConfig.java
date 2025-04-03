package com.security.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class ProjectSecurityConfig {
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // CSRF (Cross-Site Request Forgery)
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
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails admin= User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("12345")
//                .authorities("admin")
//                .build();
//        return new InMemoryUserDetailsManager(admin);
//    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
