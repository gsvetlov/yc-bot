package ru.spb.svga.bot.yc.enums;

public enum YcRegions {
    RU_CENTRAL_1("ru-central1");

    private final String id;

    YcRegions(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
