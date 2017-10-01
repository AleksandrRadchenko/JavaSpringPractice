package com.epam.spring.core.loggers;

import com.epam.spring.core.beans.Event;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.Charset;

public class FileEventLogger implements EventLogger {
    private final String filename;
    protected File file;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    private void init() { //IDEA doesn't ask for "throws IOException"... Why?
        this.file = new File(filename);
        assert file.canWrite();
    }

    @Override @SneakyThrows
    public void logEvent(Event event) {
        FileUtils.writeStringToFile(
                file, event.toString() +  System.lineSeparator(), Charset.defaultCharset(), true);
    }
}
