package com.commons.response;

public enum ResponseStatus {
    SUCCESS(200, "success"),
    FAIL(500, "fail");

    private Integer responseCode;
    private String description;

    ResponseStatus(Integer responseCode, String description) {
        this.responseCode = responseCode;
        this.description = description;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public String getDescription() {
        return description;
    }
}
