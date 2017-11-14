package com.spring.practice.logger;

import com.spring.practice.Event;

public class ConsoleLogger implements EventLogger{
    public void logEvent(Event event) {
        System.out.println(event.getMsg());
    }
}
