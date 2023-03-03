package ru.spb.svga.bot.yc.function.handler;

import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;
import com.jsoniter.extra.NamingStrategySupport;
import com.jsoniter.spi.JsoniterSpi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.spb.svga.bot.yc.dtos.MessageQueueTriggerEvent;
import ru.spb.svga.bot.yc.types.QueueMessage;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class MessageQueueReaderTest {
    private static final String json = "{\"messages\":[{\"event_metadata\":{\"event_id\":" +
            "\"d68eb53f-7360bcfe-f31626ae-851e9d92\",\"event_type\":\"yandex.cloud.events.messagequeue.QueueMessage" +
            "\",\"created_at\":\"2023-02-25T19:09:30.395Z\",\"tracing_context\":null,\"cloud_id\":" +
            "\"b1gnsv3va6s5cvnhhkgf\",\"folder_id\":\"b1glqtfm2dvcpnef5clf\"},\"details\":{\"queue_id\":" +
            "\"yrn:yc:ymq:ru-central1:b1glqtfm2dvcpnef5clf:ru-spb-svga-bot-update-test\",\"message\":{" +
            "\"message_id\":\"d68eb53f-7360bcfe-f31626ae-851e9d92\",\"md5_of_body\":" +
            "\"d41d8cd98f00b204e9800998ecf8427e\",\"body\":\"\",\"attributes\":{\"ApproximateFirstReceiveTimestamp" +
            "\":\"1677352170561\",\"ApproximateReceiveCount\":\"1\",\"SentTimestamp\":\"1677352170395\"}," +
            "\"message_attributes\":{\"botId\":{\"data_type\":\"String\",\"string_value\":\"test-operation-id\"}}," +
            "\"md5_of_message_attributes\":\"6925aa278d228f614d7c0752141ed4fe\"}}}]}";

    @Test
    void deserialize_works() {
        NamingStrategySupport.enable(NamingStrategySupport.SNAKE_CASE);
        Any any = JsonIterator.deserialize(json);
        Assertions.assertNotNull(any);
        MessageQueueTriggerEvent triggerEvent = any.as(MessageQueueTriggerEvent.class);
        QueueMessage queueMessage = triggerEvent.getMessages().get(0);
        Assertions.assertNotNull(queueMessage.getEventMetadata());
        Assertions.assertNotNull(queueMessage.getDetails());
    }

    @Test
    void endpoint_works() throws URISyntaxException {
        var endpoint = "ydb.serverless.yandexcloud.net:2135";
        URI uri = new URI(null, endpoint, null, null, null);
        Assertions.assertNotNull(uri.getHost());
        Assertions.assertTrue(uri.getPort() > -1);
    }

}