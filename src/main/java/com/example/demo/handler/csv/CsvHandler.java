package com.example.demo.handler.csv;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.example.demo.csv.CsvService;
import com.example.demo.handler.AbstractHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CsvHandler extends AbstractHandler implements RequestHandler<Event, String> {

    @Override
    public String handleRequest(Event event, Context context) {
        CsvService csvService = applicationContext.getBean(CsvService.class);
        try {
            return csvService.process(event.getRuleName(), context.getLogger());
        } catch (IOException e) {
            context.getLogger().log("Failed" + e.getMessage());
            return "Failed";
        }
    }
}
