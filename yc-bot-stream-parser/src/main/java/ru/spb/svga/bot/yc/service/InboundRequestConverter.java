package ru.spb.svga.bot.yc.service;

import com.jsoniter.JsonIterator;
import ru.spb.svga.bot.yc.dtos.FunctionRequest;

public class InboundRequestConverter {

    public static InboundRequestConverter getInstance() {
        return new InboundRequestConverter();
    }

    public FunctionRequest convert(String event) {
        return JsonIterator.deserialize(event, FunctionRequest.class);
    }
}
