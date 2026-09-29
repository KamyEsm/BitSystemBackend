package com.kamyesm.bitsystembackend.Config;

import com.kamyesm.bitsystembackend.Utils.Enum.StaffRole;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
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

    @Bean
    @Order(2)
    public SecurityFilterChain shopSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/api/shop/**")
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
                .httpBasic(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> {
                    request.requestMatchers("api/shop/public/**" , "api/shop/auth/**").permitAll()
                            .anyRequest().authenticated();
                });


        return http.build();
    }

    @Bean
    @Order(1)
    public SecurityFilterChain adminSecurityFilterChain(HttpSecurity http) throws Exception {

        http
                .securityMatcher("/api/admin/**")
                .formLogin(AbstractHttpConfigurer::disable)
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
                .httpBasic(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> {
                    request.requestMatchers("/api/admin/auth/**").permitAll()
                            .anyRequest().hasAnyRole(
                                    StaffRole.SUPER_ADMIN.name(),
                                    StaffRole.STORE_MANAGER.name()
                            );
                });
        return http.build();
    }
}
