package com.twu.biblioteca;

public enum RoleEnum {

    LIBRARIAN(1),

    CUSTOMER(2);

    private int index;

    RoleEnum(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public boolean isLibrary() {
        return 1 == getIndex();
    }
}
