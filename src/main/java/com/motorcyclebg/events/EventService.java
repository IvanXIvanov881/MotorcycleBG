package com.motorcyclebg.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @EventListener
    public void onTestEvent(TestEvent testEvent) {
        System.out.println("Message received " + testEvent.getMessage());
    }
}
