package com.learningbydoing.com.learningbydoing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Maddiaptla Chandra Babu
 * @date 20-Apr-2018
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
