package com.spring.practice;

import lombok.Getter;
import lombok.Setter;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.util.Date;

public class Event {
    private int id;
    @Setter
    @Getter
    private String msg;
    final private Date date;
    DateFormat df;

    public Event(Date date, DateFormat df) {
        id = (int) Math.floor(100 * Math.random());
        this.date = date;
        this.df = df;
    }

    @Override
    public String toString() {
        return "Id=" + id + ", date=" + df.format(date) + ", msg=" + msg;
    }
}
