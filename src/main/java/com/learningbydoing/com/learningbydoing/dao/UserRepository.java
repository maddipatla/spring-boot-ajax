package com.learningbydoing.com.learningbydoing.dao;

import com.learningbydoing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Maddiaptla Chandra Babu
 * @date 22-Apr-2018
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findByUsername(String username);
}
