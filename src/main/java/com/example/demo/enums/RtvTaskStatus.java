package com.example.demo.enums;

public enum RtvTaskStatus {
    IN_PROGRESS(1),
    COMPLETED(2),
    FAILED(3);

    private int value;

    RtvTaskStatus(int value) {
        this.value = value;
    }

    public int getIntValue() {
        return this.value;
    }
}
