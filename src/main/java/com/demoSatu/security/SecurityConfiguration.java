package com.demoSatu.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration 
@EnableWebSecurity
public class SecurityConfiguration {
    @Value("${spring.security.user.name}")
    private String uName;

    @Value("${spring.security.user.password}")
    private String psswd;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            //.csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())) // Konfigurasi CSRF
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/getToken", "/receiveddata").authenticated() // URL yang memerlukan autentikasi
                .anyRequest().permitAll() // URL lain diperbolehkan tanpa autentikasi
            )
            .httpBasic(Customizer.withDefaults()); // Gunakan Customizer untuk konfigurasi default HTTP Basic
        return http.build();
    }

     @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername(uName)
                .password("{noop}" + psswd) // {noop} digunakan untuk menghindari encoding password
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
    
}
