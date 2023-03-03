package ru.spb.svga.bot.yc.types;

public class QueueMessage {
    private EventMetadata eventMetadata;
    private MessageDetails details;

    public EventMetadata getEventMetadata() {
        return eventMetadata;
    }

    public QueueMessage setEventMetadata(EventMetadata eventMetadata) {
        this.eventMetadata = eventMetadata;
        return this;
    }

    public MessageDetails getDetails() {
        return details;
    }

    public QueueMessage setDetails(MessageDetails details) {
        this.details = details;
        return this;
    }

    @Override
    public String toString() {
        return "QueueMessage{" +
                "eventMetadata=" + eventMetadata +
                ", details=" + details +
                '}';
    }
}
