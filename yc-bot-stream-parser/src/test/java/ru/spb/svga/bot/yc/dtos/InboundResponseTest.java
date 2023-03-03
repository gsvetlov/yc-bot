package ru.spb.svga.bot.yc.dtos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.spb.svga.bot.yc.enums.HttpStatusCode;

class InboundResponseTest {

    @Test
    void success() {
        var response = FunctionResponse.ok();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatusCode.OK, response.getStatusCode());
    }
}