package com.uga.bookStore.model;

public enum AccountStatusEnum {
	INACTIVE(1),
	ACTIVE(2),
	SUSPENDED(3);
	
	public final int type;

	AccountStatusEnum(final int type) {
		this.type = type;
		}
    public int getType() {
        return type;
    }
}
