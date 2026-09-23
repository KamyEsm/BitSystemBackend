package com.kamyesm.bitsystembackend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication
@Slf4j
public class BitSystemBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitSystemBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner testRedisConnection(StringRedisTemplate redisTemplate) {
        return args -> {
            try {
                log.info("REDIS STARTING ...");
                redisTemplate.opsForValue().set("ping", "pong");
                String response = redisTemplate.opsForValue().get("ping");
                log.info("REDIS CONNECTED");
            } catch (Exception e) {
                log.error("REDIS ERROR: {}", e.getMessage());
            }
        };
    }

}
