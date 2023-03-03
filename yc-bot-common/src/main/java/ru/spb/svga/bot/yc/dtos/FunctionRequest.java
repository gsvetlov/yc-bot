package ru.spb.svga.bot.yc.dtos;

import ru.spb.svga.bot.yc.types.RequestContext;

import java.util.List;
import java.util.Map;

public class FunctionRequest {
    private String version;
    private String resource;
    private String path;
    private String httpMethod;
    private Map<String, String> headers;
    private Map<String, List<String>> multiValueHeaders;
    private Map<String, String> queryStringParameters;
    private Map<String, List<String>> multiQueryStringParameters;
    private RequestContext requestContext;
    private Map<String, String> pathParameters;
    private String body;
    private boolean isBase64Encoded;
    private Map<String, String> parameters;
    private Map<String, List<String>> multiValueParameters;
    private String operationId;


    public String getVersion() {
        return version;
    }

    public FunctionRequest setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getResource() {
        return resource;
    }

    public FunctionRequest setResource(String resource) {
        this.resource = resource;
        return this;
    }

    public String getPath() {
        return path;
    }

    public FunctionRequest setPath(String path) {
        this.path = path;
        return this;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public FunctionRequest setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
        return this;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public FunctionRequest setHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public Map<String, List<String>> getMultiValueHeaders() {
        return multiValueHeaders;
    }

    public FunctionRequest setMultiValueHeaders(Map<String, List<String>> multiValueHeaders) {
        this.multiValueHeaders = multiValueHeaders;
        return this;
    }

    public Map<String, String> getQueryStringParameters() {
        return queryStringParameters;
    }

    public FunctionRequest setQueryStringParameters(Map<String, String> queryStringParameters) {
        this.queryStringParameters = queryStringParameters;
        return this;
    }

    public Map<String, List<String>> getMultiQueryStringParameters() {
        return multiQueryStringParameters;
    }

    public FunctionRequest setMultiQueryStringParameters(Map<String, List<String>> multiQueryStringParameters) {
        this.multiQueryStringParameters = multiQueryStringParameters;
        return this;
    }

    public RequestContext getRequestContext() {
        return requestContext;
    }

    public FunctionRequest setRequestContext(RequestContext requestContext) {
        this.requestContext = requestContext;
        return this;
    }

    public Map<String, String> getPathParameters() {
        return pathParameters;
    }

    public FunctionRequest setPathParameters(Map<String, String> pathParameters) {
        this.pathParameters = pathParameters;
        return this;
    }

    public String getBody() {
        return body;
    }

    public FunctionRequest setBody(String body) {
        this.body = body;
        return this;
    }

    public boolean isBase64Encoded() {
        return isBase64Encoded;
    }

    public FunctionRequest setBase64Encoded(boolean base64Encoded) {
        isBase64Encoded = base64Encoded;
        return this;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public FunctionRequest setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
        return this;
    }

    public Map<String, List<String>> getMultiValueParameters() {
        return multiValueParameters;
    }

    public FunctionRequest setMultiValueParameters(Map<String, List<String>> multiValueParameters) {
        this.multiValueParameters = multiValueParameters;
        return this;
    }

    public String getOperationId() {
        return operationId;
    }

    public FunctionRequest setOperationId(String operationId) {
        this.operationId = operationId;
        return this;
    }
}
