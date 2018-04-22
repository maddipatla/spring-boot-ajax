package com.learningbydoing.test;

import com.learningbydoing.com.learningbydoing.service.UserService;
import com.learningbydoing.domain.DomainBuilder;
import com.learningbydoing.model.SearchCriteria;
import com.learningbydoing.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Maddiaptla Chandra Babu
 * @date 20-Apr-2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchControllerTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private UserService userService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void getSearchResults_ShouldReturnListOfUsers() throws Exception {
        when(userService.getListOfUsersByUsername(ArgumentMatchers.any(String.class))).thenReturn(DomainBuilder.getUsers());
        ResultActions users = this.mockMvc.perform(post("/api/search").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"username\":\"Chandu\"}").accept(MediaType.APPLICATION_JSON_UTF8));
        users.andExpect(status().isOk())
                .andExpect(jsonPath("$.users[0].id", is(1)))
                .andExpect(jsonPath("$.users[0].username", is("Chandu")))
                .andExpect(jsonPath("$.users[0].password", is("ChanduPASS")))
                .andExpect(jsonPath("$.users[0].email", is("chandu@mail.com")));
        verify(userService, times(1)).getListOfUsersByUsername("Chandu");
    }

}
