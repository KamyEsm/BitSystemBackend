package com.kamyesm.bitsystembackend.Config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Profile("prod")
public class ProdConfig {
    private final Environment env;

    public ProdConfig(Environment env) {
        this.env = env;
    }

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration cors = new CorsConfiguration();
                        String rawOrigins = env.getProperty("ALLOWED_ORIGINS", "http://localhost:3000");
                        List<String> allowedOrigins = Arrays.stream(rawOrigins.split(","))
                                .map(String::trim)
                                .toList();
                        cors.setAllowedOrigins(allowedOrigins);
                        cors.setAllowedMethods(List.of("GET" , "POST" , "PUT", "DELETE"));
                        cors.setAllowCredentials(true);
                        cors.setAllowedHeaders(List.of("Authorization", "Content-Type"));
                        cors.setMaxAge(env.getProperty("MAX_AGE_CORS" , Long.class , 3600L));
                        return cors;
                    }
                }))
                .logout(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable);


        return http.build();
    }
}
