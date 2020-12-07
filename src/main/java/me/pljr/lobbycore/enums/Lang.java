package me.pljr.lobbycore.enums;

public enum Lang {
    BOSS_BAR("lang.boss-bar");

    private final String path;

    Lang(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
