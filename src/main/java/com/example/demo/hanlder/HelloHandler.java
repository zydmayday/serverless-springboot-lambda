package com.example.demo.hanlder;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class HelloHandler implements RequestHandler<Event, String> {

    @Override
    public String handleRequest(Event event, Context context) {
        context.getLogger().log("Event is " + event.getName());
        return "Hello " + event.getName();
    }
}
