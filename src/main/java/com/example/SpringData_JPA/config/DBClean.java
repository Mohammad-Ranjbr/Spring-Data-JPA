package com.example.SpringData_JPA.config;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("clean")
@Configuration
public class DBClean {

    // This code allows you to clear the database and then run the migrations every time the program runs.
    // This is an effective solution for development and testing, but you should be very careful in production
    // environments because wiping the database will delete all data.
    @Bean
    public FlywayMigrationStrategy clean(){
        return flyway -> {
          flyway.clean();
          flyway.migrate();
        };
    }

}
