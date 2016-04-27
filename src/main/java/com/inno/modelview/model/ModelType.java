package com.inno.modelview.model;

/**
 * Tne enum type used for Common models
 * like Popularity and Contributor
 */
public enum ModelType {

    ENTITY(0),
    TOPIC(1);

    private int value;

    ModelType(int i) {
        this.value=i;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
