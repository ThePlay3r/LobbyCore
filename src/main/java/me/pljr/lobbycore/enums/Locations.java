package me.pljr.lobbycore.enums;

public enum Locations {
    SPAWN("locations.spawn");

    private final String path;

    Locations(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
