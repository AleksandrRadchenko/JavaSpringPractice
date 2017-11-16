package com.spring.practice.SpringConfig;

import com.spring.practice.App;
import com.spring.practice.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import java.io.IOException;
import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;

@Configuration
@Import({ClientsConfig.class, LoggersConfig.class})
public class AppConfig {
    @Autowired
    ClientsConfig clientsConfig;
    @Autowired
    LoggersConfig loggersConfig;

    @Bean
    @Scope("prototype")
    public Event event() {
        return new Event(Date.from(Instant.now()), DateFormat.getDateTimeInstance());
    }

    @Bean
    public App app() throws IOException {
        return new App(
                clientsConfig.clients(),
                loggersConfig.loggers(),
                loggersConfig.fileLogger());
    }
}
