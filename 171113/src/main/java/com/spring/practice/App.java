package com.spring.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private Client client;
    private EventLogger logger;

    private void logEvent(final String msg) {
        String message = msg.replace(client.getId(), client.getFullName());
        logger.logEvent(message);
    }

    public App(final Client client, final EventLogger logger) {
        this.client = client;
        this.logger = logger;
    }

    public static void main(String[] args) {
        final ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        final App app = ctx.getBean(App.class);
        app.logEvent("Some message for user 1");
    }
}
