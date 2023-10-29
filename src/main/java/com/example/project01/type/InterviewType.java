package com.example.project01.type;

public enum InterviewType {

    INTERVIEW_PASS("면접 합격"), INTERVIEW_NONPASS("면접 불합격");

    private final String description;

    InterviewType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
