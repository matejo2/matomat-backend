package com.wilfer.matomatdemo;

import com.wilfer.matomatdemo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Slf4j
@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(UserRepository repository){
        return args -> {
            log.info("saved this to Database: " + repository.save(new User("Joe Landa", BigDecimal.valueOf(42))));
            log.info("saved this to Database: " + repository.save(new User( "Hans Meier", BigDecimal.valueOf(23))));
        };
    }
}
