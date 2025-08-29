package com.javatpoint.microservice.springjavaprogram.springSecurity;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import java.io.IOException;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/controller/public/**").permitAll()  // No login needed
                        .requestMatchers("/string/admin/**").hasRole("ADMIN") // Only admins
                        .anyRequest().authenticated()
                )
                .httpBasic(basic -> basic
                        .authenticationEntryPoint(new CustomBasicAuthenticationEntryPoint())
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        return http.build();
    }

    // Separate class for the entry point
    private static class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response,
                             AuthenticationException authException) throws IOException {
            response.addHeader("WWW-Authenticate", "Basic realm=\"MyApp\"");
            response.addHeader("Cache-Control", "no-store");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().println("HTTP 401 - " + authException.getMessage());
        }

        @Override
        public void afterPropertiesSet() {
            setRealmName("MyApp");
            super.afterPropertiesSet();
        }
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.
                withUsername("john")
                .password("{noop}1234")
                .roles("USER")
                .build();

        UserDetails admin = User.
                withUsername("admin")
                .password("{noop}admin123")
                .roles("ADMIN", "USER")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
