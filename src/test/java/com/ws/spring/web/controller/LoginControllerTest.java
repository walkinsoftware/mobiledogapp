package com.ws.spring.web.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@WebMvcTest(LoginController.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class LoginControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;
	
		
	//We have to reset our mock between tests because the mock objects
	//are managed by the Spring container. If we would not reset them,
	//stubbing and verified behavior would "leak" from one test to another.
	@Before
	  public void setup() {
	    mockMvc = MockMvcBuilders
	            .webAppContextSetup(webApplicationContext)
	            .alwaysDo(print())
	            .build();
	  }

	@Test
    public void testIndex() throws Exception{
           this.mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andDo(print());
    }
	
	@Test
    public void testUserLogin() throws Exception{
           this.mockMvc.perform(MockMvcRequestBuilders.post("/userLogin").param("username", "admin").param("pwd", "123456"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin"))
                .andDo(print());
    }
	
}
