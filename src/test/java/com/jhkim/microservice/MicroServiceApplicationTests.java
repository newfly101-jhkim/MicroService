package com.jhkim.microservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
class MicroServiceApplicationTests {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void hello_request_get() throws Exception {
        String firstName = "JaeHong";
        String lastName = "Kim";

        mvc.perform(get("/hello/"+firstName)
                .param("lastName", lastName))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"message\":\"Hello JaeHong Kim\"}"));
    }

    @Test
    public void hello_request_post() throws Exception {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("firstName", "JaeHong");
        requestBody.put("lastName", "Kim");

        mvc.perform(post("/hello")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestBody)))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"message\":\"Hello JaeHong Kim\"}"));
    }

}
