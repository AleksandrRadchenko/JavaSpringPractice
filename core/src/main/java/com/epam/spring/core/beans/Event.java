package com.epam.spring.core.beans;

import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.util.Date;

public class Event {
    private final int id;
    private final Date date;
    @Getter @Setter
    private String msg;
    private final DateFormat df;

    public Event(Date date, DateFormat df) {
        this.id = (int) Math.round(Math.random() * 100);
        this.date = date;
        this.df = df;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", date=" + df.format(date) +
                ", msg='" + msg + '\'' +
                '}';
    }

}
