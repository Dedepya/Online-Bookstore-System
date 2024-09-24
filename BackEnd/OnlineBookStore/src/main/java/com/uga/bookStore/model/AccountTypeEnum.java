package com.uga.bookStore.model;

public enum AccountTypeEnum {
	CUSTOMER(1),
	ADMIN(2);
	
	public final int type;

	AccountTypeEnum(final int type) {
		this.type = type;
		}

    public int getType() {
        return type;
    }
}
