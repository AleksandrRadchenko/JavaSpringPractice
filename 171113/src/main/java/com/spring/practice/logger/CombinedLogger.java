package com.spring.practice.logger;

import com.spring.practice.Event;

import java.util.List;

public class CombinedLogger implements EventLogger {
    private List<EventLogger> loggers;

    public CombinedLogger(List<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        loggers.forEach(logger -> logger.logEvent(event));
    }
}
