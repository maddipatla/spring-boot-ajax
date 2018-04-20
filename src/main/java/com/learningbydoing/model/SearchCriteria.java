package com.learningbydoing.model;

import javax.validation.constraints.NotBlank;

public class SearchCriteria {
    @NotBlank(message = "Username can't be empty!!!")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
