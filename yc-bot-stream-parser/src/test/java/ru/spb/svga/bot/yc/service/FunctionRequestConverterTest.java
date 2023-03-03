package ru.spb.svga.bot.yc.service;

import com.jsoniter.JsonIterator;
import com.jsoniter.ValueType;
import com.jsoniter.any.Any;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.spb.svga.bot.yc.dtos.FunctionRequest;

class FunctionRequestConverterTest {

    private static final String json = "{\"httpMethod\":\"GET\",\"headers\":{\"Accept\":\"*/*\"," +
            "\"Accept-Encoding\":\"gzip, deflate, br\",\"Host\":\"bot.svga.spb.ru\",\"Postman-Token\":" +
            "\"2a5c891b-a061-4345-84e8-7c5615caddf3\",\"Uber-Trace-Id\":" +
            "\"861263ff93e3cc32:5313c03f478e4aa5:f9639082525cdfcb:1\",\"User-Agent\":\"PostmanRuntime/7.29.2\"," +
            "\"X-Api-Gateway-Function-Id\":\"d4ebu52ehshm825osilo\",\"X-Envoy-External-Address\":\"31.134.188.255\"," +
            "\"X-Envoy-Original-Path\":\"/test\",\"X-Forwarded-For\":\"31.134.188.255\",\"X-Forwarded-Proto\":" +
            "\"https\",\"X-Real-Remote-Address\":\"31.134.188.255:11897\",\"X-Request-Id\":" +
            "\"b2a27138-67b8-41cc-a935-0b6cf449024f\",\"X-Serverless-Certificate-Ids\":" +
            "\"{\\\"bot.svga.spb.ru\\\":\\\"fpq6va0h9j42d0cp8u71\\\"}\",\"X-Serverless-Gateway-Id\":" +
            "\"d5d08p50m6gt9cducbfj\",\"X-Trace-Id\":\"e785e655-925c-4897-ad04-e173c0f7ccd7\"}," +
            "\"multiValueHeaders\":{\"Accept\":[\"*/*\"],\"Accept-Encoding\":[\"gzip, deflate, br\"]," +
            "\"Host\":[\"bot.svga.spb.ru\"],\"Postman-Token\":[\"2a5c891b-a061-4345-84e8-7c5615caddf3\"]," +
            "\"Uber-Trace-Id\":[\"861263ff93e3cc32:5313c03f478e4aa5:f9639082525cdfcb:1\"],\"User-Agent\":[" +
            "\"PostmanRuntime/7.29.2\"],\"X-Api-Gateway-Function-Id\":[\"d4ebu52ehshm825osilo\"]," +
            "\"X-Envoy-External-Address\":[\"31.134.188.255\"],\"X-Envoy-Original-Path\":[\"/test\"]," +
            "\"X-Forwarded-For\":[\"31.134.188.255\"],\"X-Forwarded-Proto\":[\"https\"],\"X-Real-Remote-Address" +
            "\":[\"31.134.188.255:11897\"],\"X-Request-Id\":[\"b2a27138-67b8-41cc-a935-0b6cf449024f\"]," +
            "\"X-Serverless-Certificate-Ids\":[\"{\\\"bot.svga.spb.ru\\\":\\\"fpq6va0h9j42d0cp8u71\\\"}\"]," +
            "\"X-Serverless-Gateway-Id\":[\"d5d08p50m6gt9cducbfj\"],\"X-Trace-Id\":[" +
            "\"e785e655-925c-4897-ad04-e173c0f7ccd7\"]},\"queryStringParameters\":{}," +
            "\"multiValueQueryStringParameters\":{},\"requestContext\":{\"identity\":{\"sourceIp\":\"31.134.188.255" +
            "\",\"userAgent\":\"PostmanRuntime/7.29.2\"},\"httpMethod\":\"GET\",\"requestId\":" +
            "\"b2a27138-67b8-41cc-a935-0b6cf449024f\",\"requestTime\":\"23/Feb/2023:19:33:12 +0000\"," +
            "\"requestTimeEpoch\":1677180792,\"apiGateway\":{\"operationContext\":{\"contextText\":\"text goes here" +
            "\"}}},\"version\":\"1.0\",\"resource\":\"/test\",\"path\":\"/test\",\"pathParameters\":{},\"body\":" +
            "\"\",\"isBase64Encoded\":true,\"parameters\":{},\"multiValueParameters\":{}," +
            "\"operationId\":\"test-operation-id\"}";
    @Test
    void convert() {
        var response = JsonIterator.deserialize(json, FunctionRequest.class);

        Assertions.assertNotNull(response);
        Assertions.assertEquals("1.0", response.getVersion());
        Assertions.assertEquals("test-operation-id", response.getOperationId());
    }

    @Test
    void lazy_convert() {
        Any any = JsonIterator.deserialize(json);

        Assertions.assertNotNull(any);
        Assertions.assertNotEquals(ValueType.INVALID, any.get("operationId").valueType());
        Assertions.assertEquals("test-operation-id", any.get("operationId").toString());
    }
}