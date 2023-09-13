package com.aixel.training.concurrency.configuration;

import com.aixel.training.concurrency.entity.Log;
import com.aixel.training.concurrency.repository.LogRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LogConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(LogRepository logRepository) {

        return args -> {
            List<Log> logs = new ArrayList<>();

            for (int i = 0; i < 200; i++) {
                logs.add(new Log());
            }

            logRepository.saveAll(logs);
        };
    }
}
