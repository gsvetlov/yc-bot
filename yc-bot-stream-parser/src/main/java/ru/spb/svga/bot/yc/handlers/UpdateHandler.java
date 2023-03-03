package ru.spb.svga.bot.yc.handlers;

import ru.spb.svga.bot.yc.dtos.FunctionRequest;
import ru.spb.svga.bot.yc.dtos.FunctionResponse;
import ru.spb.svga.bot.yc.service.InboundRequestConverter;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.CreateQueueRequest;
import software.amazon.awssdk.services.sqs.model.CreateQueueResponse;
import software.amazon.awssdk.services.sqs.model.MessageAttributeValue;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import yandex.cloud.sdk.functions.Context;
import yandex.cloud.sdk.functions.YcFunction;

import java.net.URI;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public class UpdateHandler implements YcFunction<String, FunctionResponse> {
//    private static final String EMPTY = "";
    private static final String AWS_ACCESS_KEY_ID = System.getenv("AWS_ACCESS_KEY_ID");
    private static final String AWS_SECRET_ACCESS_KEY = System.getenv("AWS_SECRET_ACCESS_KEY");
    private static final InboundRequestConverter converter = InboundRequestConverter.getInstance();

    @Override
    public FunctionResponse handle(String event, Context context) {
        System.out.println("Context rq id: " + context.getRequestId());
        System.out.println("Context function id: " + context.getFunctionId());
        System.out.println("Context token: " + context.getTokenJson());
        FunctionRequest request = converter.convert(event);
        log(request);
        System.out.println("Starting queue update");
        System.out.println("AWS_ACCESS_KEY_ID: " + AWS_ACCESS_KEY_ID);
        System.out.println("AWS_SECRET_ACCESS_KEY: " + AWS_SECRET_ACCESS_KEY);
        try (SqsClient client = SqsClient.builder()
                .region(Region.of("ru-central1"))
                .endpointOverride(URI.create("https://message-queue.api.cloud.yandex.net"))
                .credentialsProvider(EnvironmentVariableCredentialsProvider.create())
                .build()) {
            List<String> queuesList = client.listQueues().queueUrls();
            System.out.println("List queues: " + queuesList);
            String queueUrl = request.getRequestContext().getApiGateway().getOperationContext().get("outUrl");
            String queueName = request.getRequestContext().getApiGateway().getOperationContext().get("outQueue");
            boolean queueExist = queuesList.stream().anyMatch(queueUrl::equalsIgnoreCase);
            if (! queueExist) {
                CreateQueueResponse queue = client.createQueue(CreateQueueRequest.builder()
                                                                       .queueName(queueName)
                                                                       .build());
                System.out.println(queue);
            }
            System.out.println("sending message...");
            var sendMessageResponse = client.sendMessage(
                    SendMessageRequest.builder()
                            .queueUrl(queueUrl)
                            .messageAttributes(Map.of("botId",
                                                      MessageAttributeValue.builder()
                                                              .stringValue(request.getOperationId())
                                                              .dataType("String")
                                                              .build()))
                            .messageBody(request.getBody())
                            .build());
            System.out.println("Msg sent: " + sendMessageResponse);
        }
        return FunctionResponse.ok();
    }

    private void log(FunctionRequest request) {
        System.out.println("Rq id: " + request.getRequestContext().getRequestId());
        System.out.println("Rq version: " + request.getVersion());
        System.out.println("Rq time: " + Instant.ofEpochSecond(request.getRequestContext().getRequestTimeEpoch()));
        System.out.println("Rq body: " + request.getBody());
        System.out.println("Rq operationId: " + request.getOperationId());
        System.out.println("Rq operationContext: " + request.getRequestContext().getApiGateway().getOperationContext());
    }
}
