package com.spring.practice.SpringConfig;

import com.spring.practice.EventType;
import com.spring.practice.logger.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class LoggersConfig {

    private final static String LOG_FILENAME = "log171113.txt";
    private final static int CACHE_SIZE = 4;

    @Bean
    public EventLogger consoleLogger() {
        return new ConsoleLogger();
    }

    @Bean
    public EventLogger fileLogger() {
        return new FileLogger(LOG_FILENAME);
    }

    @Bean
    public EventLogger cacheFileLogger() throws IOException {
        return new CacheFileLogger(LOG_FILENAME, CACHE_SIZE);
    }

    @Bean
    public EventLogger combinedLogger() throws IOException {
        return new CombinedLogger(Arrays.asList(consoleLogger(), cacheFileLogger()));
    }

    @Bean
    public Map<EventType, EventLogger> loggers() throws IOException {
        Map<EventType, EventLogger> result = new HashMap<>();
        result.put(EventType.INFO, consoleLogger());
        result.put(EventType.ERROR, combinedLogger());
        return result;
    }

}
