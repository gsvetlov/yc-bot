package ru.spb.svga.bot.yc.dtos;

import ru.spb.svga.bot.yc.enums.HttpStatusCode;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNullElse;

public class FunctionResponse {
    private final String statusCode;
    private final Map<String, String> headers;
    private final Map<String, List<String>> multiValueHeaders;
    private final String body;
    private final boolean isBase64Encoded;

    protected FunctionResponse(HttpStatusCode statusCode,
                               Map<String, String> headers,
                               Map<String, List<String>> multiValueHeaders,
                               String body,
                               boolean isBase64Encoded) {

        this.statusCode = requireNonNullElse(statusCode, HttpStatusCode.OK).asString();
        this.headers = isNull(headers) ? null : Map.copyOf(headers);
        this.body = body;
        this.isBase64Encoded = isBase64Encoded;
        this.multiValueHeaders = isNull(multiValueHeaders)
                                 ? null
                                 : multiValueHeaders.entrySet().stream()
                                         .collect(Collectors.toUnmodifiableMap(Map.Entry::getKey,
                                                                               e -> List.copyOf(e.getValue())));
    }

    private FunctionResponse(InboundResponseBuilder builder) {
        this(builder.statusCode, builder.headers, builder.multiValueHeaders, builder.body, builder.isBase64Encoded);
    }

    public static FunctionResponse ok() {
        return builder().build();
    }

    public static InboundResponseBuilder builder() {
        return new InboundResponseBuilder();
    }

    public static InboundResponseBuilder builder(FunctionResponse response) {
        return new InboundResponseBuilder(response);
    }

    public HttpStatusCode getStatusCode() {
        return HttpStatusCode.of(statusCode);
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Map<String, List<String>> getMultiValueHeaders() {
        return multiValueHeaders;
    }

    public String getBody() {
        return body;
    }

    public boolean isBase64Encoded() {
        return isBase64Encoded;
    }

    public static class InboundResponseBuilder {
        private HttpStatusCode statusCode;
        private Map<String, String> headers;
        private Map<String, List<String>> multiValueHeaders;
        private String body;
        private boolean isBase64Encoded;

        public InboundResponseBuilder() {
        }

        protected InboundResponseBuilder(FunctionResponse response) {
            this.statusCode = HttpStatusCode.of(response.statusCode);
        }

        public FunctionResponse build() {
            return new FunctionResponse(this);
        }

        public HttpStatusCode statusCode() {
            return statusCode;
        }

        public InboundResponseBuilder statusCode(HttpStatusCode statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Map<String, String> headers() {
            return headers;
        }

        public InboundResponseBuilder headers(Map<String, String> headers) {
            this.headers = headers;
            return this;
        }

        public InboundResponseBuilder header(String key, String value) {
            if (isNull(headers)) {
                headers = new LinkedHashMap<>();
            }
            headers.merge(key, value, (oldValue, newValue) -> newValue);
            return this;
        }

        public Map<String, List<String>> multiValueHeaders() {
            return multiValueHeaders;
        }

        public InboundResponseBuilder multiValueHeaders(Map<String, List<String>> multiValueHeaders) {
            this.multiValueHeaders = multiValueHeaders;
            return this;
        }

        public InboundResponseBuilder multiValueHeader(String key, String value) {
            if (isNull(multiValueHeaders)) {
                multiValueHeaders = new LinkedHashMap<>();
            }
            if (isNull(value)) {
                multiValueHeaders.remove(key);
            } else {
                multiValueHeaders.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
            }
            return this;
        }

        public String body() {
            return body;
        }

        public InboundResponseBuilder body(String body) {
            this.body = body;
            return this;
        }

        public boolean base64Encoded() {
            return isBase64Encoded;
        }

        public InboundResponseBuilder base64Encoded(boolean base64Encoded) {
            isBase64Encoded = base64Encoded;
            return this;
        }
    }
}
