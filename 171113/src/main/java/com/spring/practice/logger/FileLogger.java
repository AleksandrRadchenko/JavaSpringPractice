package com.spring.practice.logger;

import com.spring.practice.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileLogger implements EventLogger {
    private final String filename;
    private File file;

    @SuppressWarnings("WeakerAccess")
    public FileLogger(String filename) {
        this.filename = filename;
    }

    public void init() throws IOException {
        this.file = FileUtils.getFile(filename);
        if (!file.canWrite()) throw new IOException("File " + filename + " is write protected.");
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString(), Charset.defaultCharset(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
