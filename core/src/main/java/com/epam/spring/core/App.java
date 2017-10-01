package com.epam.spring.core;

import com.epam.spring.core.beans.Client;
import com.epam.spring.core.beans.Event;
import com.epam.spring.core.loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private Client client;
    private EventLogger eventLogger;
    private static ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {
        App app = (App) ctx.getBean(App.class);

        app.logEvent("Some event for user 1");
        long i = 0;
        while (i++ < 100000000) {
            double d = Math.random();
        }
        app.logEvent("Some event for user 2");
    }

    private void logEvent(String msg) {
        Event event = (Event) ctx.getBean("event");
        event.setMsg(msg.replaceAll(
                client.getId(), client.getFullName()));
        eventLogger.logEvent(event);
    }
}
