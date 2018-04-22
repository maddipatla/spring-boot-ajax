package com.learningbydoing.com.learningbydoing.service;

import com.learningbydoing.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Maddiaptla Chandra Babu
 * @date 20-Apr-2018
 */
@Service
public class UserService {
    private List<User> users;

    public List<User> getListOfUsersByUsername(String username) {
        return users.stream().filter(x -> x.getUsername().equalsIgnoreCase(username)).collect(Collectors.toList());
    }

    @PostConstruct
    private void init() {
        users = new ArrayList<>();
        users.add(new User("Chandu", "ChanduPASS", "chandu@mail.com"));
        users.add(new User("Ram", "RamPASS", "ram@mail.com"));
        users.add(new User("Ashok", "AshokPASS", "ashok@mail.com"));
    }
}
