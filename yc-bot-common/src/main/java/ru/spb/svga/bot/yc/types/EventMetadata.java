package ru.spb.svga.bot.yc.types;

public class EventMetadata {
    private String eventId;
    private String eventType;
    private String createdAt;

    public String getEventId() {
        return eventId;
    }

    public EventMetadata setEventId(String eventId) {
        this.eventId = eventId;
        return this;
    }

    public String getEventType() {
        return eventType;
    }

    public EventMetadata setEventType(String eventType) {
        this.eventType = eventType;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public EventMetadata setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @Override
    public String toString() {
        return "EventMetadata{" +
                "eventId='" + eventId + '\'' +
                ", eventType='" + eventType + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
