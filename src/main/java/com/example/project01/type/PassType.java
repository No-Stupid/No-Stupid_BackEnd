package com.example.project01.type;

public enum PassType {

    PASS("합격"), NONPASS("불합격");

    private final String description;

    PassType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
