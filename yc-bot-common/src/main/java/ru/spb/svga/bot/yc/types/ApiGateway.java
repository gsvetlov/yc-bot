package ru.spb.svga.bot.yc.types;

import java.util.Map;

public class ApiGateway {
    Map<String, String> operationContext;

    public Map<String, String> getOperationContext() {
        return operationContext;
    }

    public ApiGateway setOperationContext(Map<String, String> operationContext) {
        this.operationContext = operationContext;
        return this;
    }
}
