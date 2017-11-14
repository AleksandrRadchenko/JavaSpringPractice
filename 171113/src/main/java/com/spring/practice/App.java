package com.spring.practice;

import com.spring.practice.logger.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
//    private Client client;
    private List<Client> clients;
    private EventLogger logger;

    public App(final List<Client> clients, final EventLogger logger) {
        this.clients = clients;
        this.logger = logger;
    }

    private void logEvent(final Event event) {
        String message = event.getMsg();
        for (Client cl : clients) {
            message = message.replace(cl.getId(), cl.getFullName());
        }
        event.setMsg(message);
        logger.logEvent(event);
    }

    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        ctx.registerShutdownHook();
        final App app = ctx.getBean(App.class);
        Event event1 = (Event) ctx.getBean("event");
        Event event2 = (Event) ctx.getBean("event");
        event1.setMsg("Some message for user 1");
        event2.setMsg("Some message for user 2");
        app.logEvent(event1);
        app.logEvent(event2);
    }
}
