package com.uga.bookStore.model;

public enum UserTypeEnum {
    CUSTOMER("Customer"),
    ADMIN("Admin");

    public final String type;

    UserTypeEnum(final String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
