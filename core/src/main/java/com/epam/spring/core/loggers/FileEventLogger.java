package com.epam.spring.core.loggers;

import com.epam.spring.core.beans.Event;

public class FileEventLogger implements EventLogger {
    private final String filename;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    @Override
    public void logEvent(Event event) {

    }
}
