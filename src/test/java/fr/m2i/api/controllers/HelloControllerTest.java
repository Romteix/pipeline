package fr.m2i.api.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetHello() throws Exception {
        MvcResult result = mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andReturn();

        String resultStr = result.getResponse().getContentAsString();
        assertEquals("Hello World", resultStr);
    }
    
    
    //test de la méthode getHome
    @Test
    void testGetHome() throws Exception {
        MvcResult result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        String resultStr = result.getResponse().getContentAsString();
        assertEquals("Homepage", resultStr);
    }
}
