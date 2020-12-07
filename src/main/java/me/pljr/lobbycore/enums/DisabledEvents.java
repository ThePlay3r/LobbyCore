package me.pljr.lobbycore.enums;

public enum DisabledEvents {
    DROP("disabled-events.drop"),
    INV_CLICK("disabled-events.inv-click"),
    BREAK("disabled-events.break"),
    PLACE("disabled-events.place"),
    HUNGER("disabled-events.hunger"),
    DAMAGE("disabled-events.damage"),
    WEATHER("disabled-events.weather");

    private final String path;

    DisabledEvents(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
