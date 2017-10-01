package com.epam.spring.core.loggers;

import com.epam.spring.core.beans.Event;

public class ConsoleEventLoggerImpl implements ConsoleEventLogger {
    @Override
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
