package com.learningbydoing.domain;

import com.learningbydoing.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maddiaptla Chandra Babu
 * @date 22-Apr-2018
 */
public class DomainBuilder {
    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setUsername("Chandu");
        user.setEmail("chandu@mail.com");
        user.setPassword("ChanduPASS");
        users.add(user);
        return users;
    }
}
