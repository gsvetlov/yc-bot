package ru.spb.svga.bot.yc.function.handler;

import com.jsoniter.JsonIterator;
import com.jsoniter.extra.NamingStrategySupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.spb.svga.bot.yc.dtos.FunctionResponse;
import ru.spb.svga.bot.yc.dtos.MessageQueueTriggerEvent;
import ru.spb.svga.bot.yc.types.YcToken;
import tech.ydb.core.auth.TokenAuthProvider;
import tech.ydb.core.grpc.GrpcTransport;
import tech.ydb.table.SessionRetryContext;
import tech.ydb.table.TableClient;
import tech.ydb.table.description.TableColumn;
import tech.ydb.table.description.TableDescription;
import yandex.cloud.sdk.functions.Context;
import yandex.cloud.sdk.functions.YcFunction;

import java.util.Arrays;
import java.util.List;


public class MessageQueueReader implements YcFunction<String, FunctionResponse> {
    private static final Logger log = LoggerFactory.getLogger(MessageQueueReader.class);
    private static final String DB_CONNECTION = System.getenv("DB_CONNECTION");
    //grpcs://ydb.serverless.yandexcloud.net:2135?database=/ru-central1/b1gnsv3va6s5cvnhhkgf/etnvf5868cppjvd2bgnq

    @Override
    public FunctionResponse handle(String json, Context context) {
        log.info("Starting handling read MessageQueue event: {}", json);
        NamingStrategySupport.enable(NamingStrategySupport.SNAKE_CASE);
        var event = JsonIterator.deserialize(json, MessageQueueTriggerEvent.class);
        log.info("Received {} messages", event.getMessages().size());
        event.getMessages().forEach(System.out::println);
        var token = JsonIterator.deserialize(context.getTokenJson(), YcToken.class);
        try (var transport = getTransport(token.getAccessToken());
             var client = TableClient.newClient(transport).build()) {
            var ctx = SessionRetryContext.create(client).build();
            describeTables(transport.getDatabase(), ctx);
        } catch (RuntimeException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        return FunctionResponse.ok();
    }

    private void describeTables(String database, SessionRetryContext retryCtx) {
        log.info("--[ DescribeTables ]--");

        Arrays.asList("updates/bot_updates").forEach(tableName -> {
            String tablePath = database + '/' + tableName;
            TableDescription tableDesc = retryCtx.supplyResult(session -> session.describeTable(tablePath))
                    .join().getValue();

            List<String> primaryKeys = tableDesc.getPrimaryKeys();
            log.info("  table {}", tableName);
            for (TableColumn column : tableDesc.getColumns()) {
                boolean isPrimary = primaryKeys.contains(column.getName());
                log.info("     {}: {} {}", column.getName(), column.getType(), isPrimary ? " (PK)" : "");
            }
        });
    }

    private GrpcTransport getTransport(String token) {
        log.info("DB_CONNECTION: {}", DB_CONNECTION);
        log.info("TOKEN: {}", token);
        return GrpcTransport.forConnectionString(DB_CONNECTION)
                .withAuthProvider(new TokenAuthProvider(token))
                .build();
    }
}
