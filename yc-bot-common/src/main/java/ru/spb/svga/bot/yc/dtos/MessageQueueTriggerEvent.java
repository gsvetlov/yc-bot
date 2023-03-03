package ru.spb.svga.bot.yc.dtos;

import ru.spb.svga.bot.yc.types.QueueMessage;

import java.util.List;

public class MessageQueueTriggerEvent {
    private List<QueueMessage> messages;

    public List<QueueMessage> getMessages() {
        return messages;
    }

    public MessageQueueTriggerEvent setMessages(List<QueueMessage> messages) {
        this.messages = messages;
        return this;
    }

    @Override
    public String toString() {
        return "MessageQueueTriggerEvent{" +
                "messages=" + messages +
                '}';
    }
}
