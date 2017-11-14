package com.spring.practice.logger;

import com.spring.practice.Event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CacheFileLogger extends FileLogger {
    private int cacheSize;
    private List<Event> cache;

    @Override
    public void init() throws IOException {
        super.init();
        System.out.println("In init() of CacheFileLogger");
        cache = new ArrayList<>(cacheSize);
    }

    public void destroy() {
        System.out.println("In destroy() method");
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
        String allMessages = Stream.of(cache).map(event -> event.toString()).collect(Collectors.joining());
        System.out.println(allMessages);
        cache.forEach(super::logEvent);
    }
}
