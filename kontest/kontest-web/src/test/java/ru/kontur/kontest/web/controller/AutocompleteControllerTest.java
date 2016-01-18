package ru.kontur.kontest.web.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import ru.kontur.kontest.storages.Storage;
import ru.kontur.kontest.web.HttpContext;
import ru.kontur.kontest.web.configuration.WebContext;
import ru.kontur.kontest.words.Prefix;
import ru.kontur.kontest.words.WordWithFrequency;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HttpContext.class, WebContext.class })
@WebAppConfiguration
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class })
public class AutocompleteControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private Storage storage;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		Mockito.reset(storage);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void controllerShouldReturnFoundWordsFromStorage() throws Exception {
		WordWithFrequency wordWithFrequency = new WordWithFrequency("word", 10);
		
		when(storage.searchWordsBy(new Prefix("w"))).thenReturn(Arrays.asList(wordWithFrequency));
		
		mockMvc.perform(get("/api/autocomplete/w"))
			   .andDo(print())
		       .andExpect(status().isOk());
		
		verify(storage, times(1)).searchWordsBy(new Prefix("w"));
		verifyNoMoreInteractions(storage);
	}
	
}
