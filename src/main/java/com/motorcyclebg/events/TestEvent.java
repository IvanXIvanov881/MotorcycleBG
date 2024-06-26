package com.motorcyclebg.events;

import org.springframework.context.ApplicationEvent;

public class TestEvent extends ApplicationEvent {

    private final String message;

    public TestEvent(Object source,String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
