package com.aws.avidfullstack.model;

import java.util.Map;

public class UserResponse {

    private String body;

    public UserResponse(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
