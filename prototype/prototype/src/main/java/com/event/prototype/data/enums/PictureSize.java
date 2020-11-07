package com.event.prototype.data.enums;

public enum PictureSize {
    SOURCE,
    SMALL(480);

    private int value;
    private String name;

    PictureSize(int value) {
        this.value = value;
    }
    PictureSize() {}

    public int getValue() {
        return value;
    }
}
