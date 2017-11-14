package com.spring.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private Client client;
    private EventLogger logger;

    private void logEvent(final Event event) {
        String message = event.getMsg().replace(client.getId(), client.getFullName());
        event.setMsg(message);
        logger.logEvent(event);
    }

    public App(final Client client, final EventLogger logger) {
        this.client = client;
        this.logger = logger;
    }

    public static void main(String[] args) {
        final ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        final App app = ctx.getBean(App.class);
        Event event = (Event) ctx.getBean("event");
        event.setMsg("Some message for user 1");
        app.logEvent(event);
    }
}
