package com.example.wsp_spring.model;

public class UserValue {

    private final String userId;
    private final String shimei;

    public UserValue(String userId, String shimei) {
        this.userId = userId;
        this.shimei = shimei;
    }

    public String getUserId() {
        return userId;
    }

    public String getShimei() {
        return shimei;
    }

}
