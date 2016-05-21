package com.inno.modelview.model.Login;

/**
 * Created by Will Hu on 2016-5-21.
 */
public enum UserRole {

    USER(0),
    ADMIN(1);

    private int value;

    UserRole(int i) {
        this.value=i;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
