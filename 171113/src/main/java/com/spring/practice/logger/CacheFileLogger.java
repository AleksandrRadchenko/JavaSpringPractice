package com.spring.practice.logger;

import com.spring.practice.Event;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CacheFileLogger extends FileLogger {
    private int cacheSize;
    private List<Event> cache;

    @Override
    @PostConstruct
    public void init() throws IOException {
        super.init();
        cache = new ArrayList<>(cacheSize);
    }

    @PreDestroy
    public void destroy() {
        if (!cache.isEmpty()) writeEventsFromCache();
    }

    public CacheFileLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        cache.forEach(super::logEvent);
    }
}
