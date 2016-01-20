package ru.kontur.kontest.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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

  @Before
  public void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void controllerShouldReturnIndexPage() throws Exception {
    mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("home/index"));
  }

  @Autowired
  private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;
}
