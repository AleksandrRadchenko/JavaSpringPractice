package com.spring.practice;

import lombok.Getter;
import lombok.Setter;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.util.Date;

public class Event {
    final private int id;
    @Setter
    @Getter
    private String msg;
    final private Date date;
    final private DateFormat df;

    public Event(Date date, DateFormat df) {
        id = (int) Math.floor(100 * Math.random());
        this.date = date;
        this.df = df;
    }

    @Override
    public String toString() {
        return String.format("%s: Id=%d, msg=%s%n", df.format(date), id, msg);
    }
}
