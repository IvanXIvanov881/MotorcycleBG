package com.motorcyclebg.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TestEventListener implements ApplicationListener<TestEvent> {

    private int counter = 0;

    @Override
    public void onApplicationEvent(TestEvent event) {
       counter++;
       System.out.println(counter + " events were received. Last message: " + event.getMessage());
    }
}
