package com.zydmayday.demo.handler.hello;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import static com.zydmayday.demo.common.CommonUtils.getName;

public class HelloHandler implements RequestHandler<Event, String> {

    @Override
    public String handleRequest(Event event, Context context) {
        context.getLogger().log("Event is " + event.getName());
        return "Hello " + getName() + event.getName();
    }
}
