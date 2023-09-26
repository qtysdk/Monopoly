package model;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Event {

    private String message;
    private Date date = new Date();

    public Event(String message) {
        this.message = message;
    }

    public static List<Event> fromString(String message) {
        return List.of(new Event(message));
    }

    @Override
    public String toString() {
        return String.format("%s %s", new SimpleDateFormat("HH:mm:ss").format(date), message);
    }
}
