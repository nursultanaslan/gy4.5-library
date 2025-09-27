package com.example.library.core.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//Projenin globalinde config
@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    //Tüm uygulamada PasswordEncoder istendigi yerde burası calısacak
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)  //kendi yazdığımız filteri öne aldık
                .authorizeHttpRequests (auth ->
                        auth
                        .requestMatchers("/swagger-ui/**").permitAll()
                        .requestMatchers("/v3/api-docs/**").permitAll()
                        .requestMatchers("/api/v1/auth/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/v1/books").hasAnyAuthority("Admin", "book.create")
                                .requestMatchers(HttpMethod.GET, "/api/v1/books").hasAnyAuthority("Admin", "book.read")
                                .requestMatchers(HttpMethod.GET, "/api/v1/users").hasAnyAuthority("Admin", "user.read")
                        .anyRequest().authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable); //csrf koruması devre dışı bırakıldı
        return http.build();
    }

}
