package ru.spb.svga.bot.yc.types;

public class YcToken {
    private String accessToken;
    private long expiresIn;
    private String tokenType;

    public String getAccessToken() {
        return accessToken;
    }

    public YcToken setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public YcToken setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    public String getTokenType() {
        return tokenType;
    }

    public YcToken setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }
}
