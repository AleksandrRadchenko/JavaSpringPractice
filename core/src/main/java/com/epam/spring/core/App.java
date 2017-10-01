package com.epam.spring.core;

import com.epam.spring.core.beans.Client;
import com.epam.spring.core.beans.Event;
import com.epam.spring.core.loggers.EventLogger;
import com.epam.spring.core.loggers.EventType;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

import static com.epam.spring.core.loggers.EventType.ERROR;
import static com.epam.spring.core.loggers.EventType.INFO;

public class App {
    private Client client;
    private Map<EventType, EventLogger> loggers;
    private static ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    private EventLogger defaultLogger;
//    private EventLogger defaultLogger = (EventLogger) ctx.getBean("cacheFileLogger");

    public App(Client client, EventLogger defaultLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger = defaultLogger;
        this.loggers = loggers;
    }

    public static void main(String[] args) {
        App app = (App) ctx.getBean(App.class);

        app.logEvent(INFO, "Some event for user 1");
        app.logEvent(ERROR, "Some event for user 2");
        app.logEvent(null, "Some event for user 3");

        ctx.close();
    }

    private void logEvent(EventType type, String msg) {
        EventLogger logger = loggers.get(type);
        if (logger == null) {
            logger = defaultLogger;
        }
        Event event = (Event) ctx.getBean("event");
        event.setMsg(msg.replaceAll(
                client.getId(), client.getFullName()));
        logger.logEvent(event);
    }
}
