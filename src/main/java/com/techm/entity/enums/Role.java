package com.techm.entity.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {
    ADMIN("ADMIN"),
    APPLICANT("APPLICANT"),
    EMPLOYER("EMPLOYER");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
