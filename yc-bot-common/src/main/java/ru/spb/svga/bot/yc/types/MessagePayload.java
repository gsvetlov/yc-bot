package ru.spb.svga.bot.yc.types;

import java.util.Map;

public class MessagePayload {
    private String messageId;
    private String md5OfBody;
    private String body;
    private Map<String, String> attributes;
    private Map<String, Map<String, String>> messageAttributes;
    private String md5OfMessageAttributes;

    public String getMessageId() {
        return messageId;
    }

    public MessagePayload setMessageId(String messageId) {
        this.messageId = messageId;
        return this;
    }

    public String getMd5OfBody() {
        return md5OfBody;
    }

    public MessagePayload setMd5OfBody(String md5OfBody) {
        this.md5OfBody = md5OfBody;
        return this;
    }

    public String getBody() {
        return body;
    }

    public MessagePayload setBody(String body) {
        this.body = body;
        return this;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public MessagePayload setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
        return this;
    }

    public Map<String, Map<String, String>> getMessageAttributes() {
        return messageAttributes;
    }

    public MessagePayload setMessageAttributes(Map<String, Map<String, String>> messageAttributes) {
        this.messageAttributes = messageAttributes;
        return this;
    }

    public String getMd5OfMessageAttributes() {
        return md5OfMessageAttributes;
    }

    public MessagePayload setMd5OfMessageAttributes(String md5OfMessageAttributes) {
        this.md5OfMessageAttributes = md5OfMessageAttributes;
        return this;
    }

    @Override
    public String toString() {
        return "MessagePayload{" +
                "messageId='" + messageId + '\'' +
                ", md5OfBody='" + md5OfBody + '\'' +
                ", body='" + body + '\'' +
                ", attributes=" + attributes +
                ", messageAttributes=" + messageAttributes +
                ", md5OfMessageAttributes='" + md5OfMessageAttributes + '\'' +
                '}';
    }
}
