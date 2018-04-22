package com.learningbydoing.com.learningbydoing.service;

import com.learningbydoing.com.learningbydoing.dao.UserRepository;
import com.learningbydoing.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getListOfUsersByUsername(String username) {
        List<User> users = userRepository.findByUsername(username);
        if (!users.isEmpty())
            return users;
        return new ArrayList<>(1);
    }
}
