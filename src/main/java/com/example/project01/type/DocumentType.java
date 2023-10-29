package com.example.project01.type;

public enum DocumentType {

    DOCUMENT_PASS("서류 합격"), DOCUMENT_NONPASS("서류 불합격");

    public final String description;

    DocumentType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}


