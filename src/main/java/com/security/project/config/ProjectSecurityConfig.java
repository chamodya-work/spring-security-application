package com.security.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true
) // this allow us to use method level security

public class ProjectSecurityConfig {
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // CSRF (Cross-Site Request Forgery)
                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/v1/account/my-account").authenticated()
//                        .requestMatchers("/api/v1/loan/my-loan").authenticated()

                                //this how we using another way using authorize role
//                        .requestMatchers("/api/v1/account/my-account").hasAuthority("admin")
//                        .requestMatchers("/api/v1/loan/my-loan").hasAuthority("user")

                                //how this using role based
//                                .requestMatchers("/api/v1/account/my-account").hasRole("USER")
//                                .requestMatchers("/api/v1/loan/my-loan").hasRole("ADMIN")

                                //now moved to general way to continue only authenticated
                                .requestMatchers("/api/v1/account/my-account").authenticated()
                                .requestMatchers("/api/v1/loan/my-loan").authenticated()
                                .anyRequest().permitAll()
                )
                .formLogin(form -> form
//                        .loginPage("/login") // Custom login page (optional, can be default)
//                        .defaultSuccessUrl("/dashboard", true) // Redirect after successful login
                                .permitAll()
                )
                .httpBasic(withDefaults()) // Enable HTTP Basic for API clients like Postman
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
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
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
