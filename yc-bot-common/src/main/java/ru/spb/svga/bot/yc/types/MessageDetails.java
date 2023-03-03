package ru.spb.svga.bot.yc.types;

public class MessageDetails {
    private String queueId;
    private MessagePayload message;

    public String getQueueId() {
        return queueId;
    }

    public MessageDetails setQueueId(String queueId) {
        this.queueId = queueId;
        return this;
    }

    public MessagePayload getDetails() {
        return message;
    }

    public MessageDetails setDetails(MessagePayload message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "MessageDetails{" +
                "queueId='" + queueId + '\'' +
                ", message=" + message +
                '}';
    }
}
