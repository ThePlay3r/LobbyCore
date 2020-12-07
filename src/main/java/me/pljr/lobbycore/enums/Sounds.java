package me.pljr.lobbycore.enums;

public enum Sounds {
    DOUBLE_JUMP("sounds.double-jump");

    private final String path;

    Sounds(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
