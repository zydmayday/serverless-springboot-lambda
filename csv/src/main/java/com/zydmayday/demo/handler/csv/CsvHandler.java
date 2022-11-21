package com.zydmayday.demo.handler.csv;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.zydmayday.demo.csv.CsvService;
import com.zydmayday.demo.handler.AbstractHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.zydmayday.demo.common.CommonUtils.getName;

@Component
public class CsvHandler extends AbstractHandler implements RequestHandler<Event, String> {

    @Override
    public String handleRequest(Event event, Context context) {
        CsvService csvService = applicationContext.getBean(CsvService.class);
        try {
            return csvService.process(event.getRuleName(), context.getLogger());
        } catch (IOException e) {
            context.getLogger().log(getName() + "Failed" + e.getMessage());
            return "Failed";
        }
    }
}
