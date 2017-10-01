package com.epam.spring.core.loggers;

import com.epam.spring.core.beans.Event;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(String filename, int cacheSize, List<Event> cache) {
        super(filename);
        this.cacheSize = cacheSize;
        this.cache = cache;
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    @SneakyThrows
    private void writeEventsFromCache() {
        FileUtils.writeLines(file, cache, true);
    }

    public void destroy() {
        if (!cache.isEmpty())
            writeEventsFromCache();
    }
}
