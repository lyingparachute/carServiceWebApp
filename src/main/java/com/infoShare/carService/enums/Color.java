package com.infoShare.carService.enums;

public enum Color {
    BLACK("Black"),
    WHITE("White"),
    GREY("Grey"),
    SILVER("Silver"),
    RED("Red"),
    PINK("Pink"),
    PURPLE("Purple"),
    GREEN("Green");

    private final String value;

    Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
