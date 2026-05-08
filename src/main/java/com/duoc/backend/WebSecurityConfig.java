package com.duoc.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfig {

    @Autowired
    private JWTAuthorizationFilter jwtAuthorizationFilter;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .headers(headers -> headers
                .contentSecurityPolicy(csp -> csp
                    .policyDirectives(
                        "default-src 'self'; " +
                        "script-src 'self'; " +
                        "style-src 'self' 'unsafe-inline'; " +
                        "img-src 'self' data:; " +
                        "font-src 'self'; " +
                        "object-src 'none'; " +
                        "base-uri 'self'; " +
                        "frame-ancestors 'none';"
                    )
                )
            )

            .authorizeHttpRequests(auth -> auth

                // frontend
                .requestMatchers("/", "/dashboard", "/pets", "/pets/**").permitAll()

                // static
                .requestMatchers("/css/**", "/js/**").permitAll()

                // login
                .requestMatchers("/login").permitAll()

                // APIs protegidas
                .requestMatchers("/adoption").authenticated()
                .requestMatchers("/adoption/**").authenticated()

                .anyRequest().authenticated()
            )

            .addFilterBefore(jwtAuthorizationFilter,
                    UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}