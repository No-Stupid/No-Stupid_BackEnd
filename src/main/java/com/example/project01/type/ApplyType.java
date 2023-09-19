package com.example.project01.type;

public enum ApplyType {
    APPLY_EXP("지원예정"), APPLY_COM("지원완료");

    public final String description;

    ApplyType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
