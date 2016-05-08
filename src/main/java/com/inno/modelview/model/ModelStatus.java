package com.inno.modelview.model;

/**
 * Tne enum type is used to describe the model status
 */
public enum ModelStatus {
    ACTIVE(0),
    DRAFT(1),
    RETRIED(2);

    private int value;

    ModelStatus(int i) {
        this.value=i;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}