package ru.spb.svga.bot.yc.types;

import java.util.Map;

public class RequestContext {
    private Identity identity;
    private String httpMethod;
    private String requestId;
    private String requestTime;
    private Long requestTimeEpoch;
    private Map<String, String> authorizer;
    private ApiGateway apiGateway;
    private String connectionId;
    private String connectedAt;
    private String eventType;
    private String messageId;
    private String disconnectStatusCode;
    private String disconnectReason;

    public Identity getIdentity() {
        return identity;
    }

    public RequestContext setIdentity(Identity identity) {
        this.identity = identity;
        return this;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public RequestContext setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
        return this;
    }

    public String getRequestId() {
        return requestId;
    }

    public RequestContext setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public RequestContext setRequestTime(String requestTime) {
        this.requestTime = requestTime;
        return this;
    }

    public long getRequestTimeEpoch() {
        return requestTimeEpoch;
    }

    public RequestContext setRequestTimeEpoch(Long requestTimeEpoch) {
        this.requestTimeEpoch = requestTimeEpoch;
        return this;
    }

    public Map<String, String> getAuthorizer() {
        return authorizer;
    }

    public RequestContext setAuthorizer(Map<String, String> authorizer) {
        this.authorizer = authorizer;
        return this;
    }

    public ApiGateway getApiGateway() {
        return apiGateway;
    }

    public RequestContext setApiGateway(ApiGateway apiGateway) {
        this.apiGateway = apiGateway;
        return this;
    }

    public String getConnectionId() {
        return connectionId;
    }

    public RequestContext setConnectionId(String connectionId) {
        this.connectionId = connectionId;
        return this;
    }

    public String getConnectedAt() {
        return connectedAt;
    }

    public RequestContext setConnectedAt(String connectedAt) {
        this.connectedAt = connectedAt;
        return this;
    }

    public String getEventType() {
        return eventType;
    }

    public RequestContext setEventType(String eventType) {
        this.eventType = eventType;
        return this;
    }

    public String getMessageId() {
        return messageId;
    }

    public RequestContext setMessageId(String messageId) {
        this.messageId = messageId;
        return this;
    }

    public String getDisconnectStatusCode() {
        return disconnectStatusCode;
    }

    public RequestContext setDisconnectStatusCode(String disconnectStatusCode) {
        this.disconnectStatusCode = disconnectStatusCode;
        return this;
    }

    public String getDisconnectReason() {
        return disconnectReason;
    }

    public RequestContext setDisconnectReason(String disconnectReason) {
        this.disconnectReason = disconnectReason;
        return this;
    }
}
