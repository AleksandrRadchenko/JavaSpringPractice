package com.spring.practice;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Event {
    private int id;
    @Setter
    @Getter
    private String msg;
    final private Date date;

    public Event(Date date) {
        id = (int) Math.floor(100 * Math.random());
        this.date = date;
    }

    @Override
    public String toString() {
        return "Id=" + id + ", msg=" + msg + ", date=" + date;
    }
}
