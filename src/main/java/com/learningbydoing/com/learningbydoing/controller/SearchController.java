package com.learningbydoing.com.learningbydoing.controller;

import com.learningbydoing.com.learningbydoing.service.UserService;
import com.learningbydoing.model.AJAXResponseBody;
import com.learningbydoing.model.SearchCriteria;
import com.learningbydoing.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Maddiaptla Chandra Babu
 * @date 20-Apr-2018
 */
@RestController
public class SearchController {

    private UserService userService;

    @Autowired
    public SearchController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/search")
    public ResponseEntity<?> getSearchResultsViaAJAX(@Valid @RequestBody SearchCriteria searchCriteria, Errors errors) {
        AJAXResponseBody result = new AJAXResponseBody();

        if (errors.hasErrors()) {
            result.setMessage(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }

        List<User> users = userService.getListOfUsersByUsername(searchCriteria.getUsername());
        if (users.isEmpty())
            result.setMessage("No users found!!!");
        else
            result.setMessage("Success!!!");

        result.setUsers(users);

        return ResponseEntity.ok(result);
    }
}
