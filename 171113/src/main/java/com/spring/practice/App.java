package com.spring.practice;

import com.spring.practice.SpringConfig.AppConfig;
import com.spring.practice.logger.EventLogger;
import lombok.AllArgsConstructor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static com.spring.practice.EventType.ERROR;
import static com.spring.practice.EventType.INFO;

@AllArgsConstructor
public class App {
//    private Client client;
    final private List<Client> clients;
    final private Map<EventType, EventLogger> loggers;
    final private EventLogger defaultLogger;

    private void logEvent(EventType type, final Event event) {
        String message = event.getMsg();
        for (Client cl : clients) {
            message = message.replace(cl.getId(), cl.getFullName());
        }
        event.setMsg(message);

        EventLogger logger = loggers.get(type);
        if (logger == null) logger = defaultLogger;

        logger.logEvent(event);
    }

    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ctx.registerShutdownHook();
        final App app = ctx.getBean(App.class);
        Event event1 = (Event) ctx.getBean("event");
        Event event2 = (Event) ctx.getBean("event");
        event1.setMsg("Some message for user 1");
        event2.setMsg("Some message for user 2");
        app.logEvent(INFO, event1);
        app.logEvent(ERROR, event2);
    }
}
