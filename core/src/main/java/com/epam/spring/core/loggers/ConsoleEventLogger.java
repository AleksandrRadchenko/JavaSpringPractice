package com.epam.spring.core.loggers;

import com.epam.spring.core.beans.Event;

public interface ConsoleEventLogger {
    void logEvent(Event event);
}
