package ru.kontur.kontest.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import ru.kontur.kontest.web.configuration.WebContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebContext.class })
@WebAppConfiguration
public class HomeControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void controllerShouldReturnIndexPage() throws Exception {
		mockMvc.perform(get("/"))
		       .andExpect(status().isOk())
		       .andExpect(view().name("home/index"));
	}
	
}
