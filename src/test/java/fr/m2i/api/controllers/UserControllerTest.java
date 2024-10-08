package fr.m2i.api.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testGetUserPage() throws Exception {

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/user/romy"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		String resultStr = result.getResponse().getContentAsString();
		assertEquals("OK", resultStr);
	}

	@Test
	void testPostUserPage() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user").content("romy"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		String resultStr = result.getResponse().getContentAsString();
		assertEquals("OK", resultStr);
	}

}
