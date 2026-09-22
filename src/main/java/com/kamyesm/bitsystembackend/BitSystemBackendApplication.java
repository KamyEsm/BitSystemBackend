package com.kamyesm.bitsystembackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication
public class BitSystemBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitSystemBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner testRedisConnection(StringRedisTemplate redisTemplate) {
        return args -> {
            try {
                redisTemplate.opsForValue().set("ping", "pong");
                String response = redisTemplate.opsForValue().get("ping");
                System.out.println("========== REDIS CONNECTED: " + response + " ==========");
            } catch (Exception e) {
                System.err.println("========== REDIS ERROR: " + e.getMessage() + " ==========");
            }
        };
    }

}
