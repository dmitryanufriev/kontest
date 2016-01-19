package ru.kontur.kontest.web.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import ru.kontur.kontest.web.services.StorageService;
import ru.kontur.kontest.words.Prefix;
import ru.kontur.kontest.words.WordWithFrequency;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebContext.class, HttpContext.class })
@WebAppConfiguration
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class })
public class AutocompleteControllerTest {
	
	private static final String URL = "/api/autocomplete";
	private static final String URL_WITH_PREFIX = URL + "/w";
	
	private MockMvc mockMvc;
	private Storage storage;
	
	@Autowired
	private StorageService storageService;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		reset(storageService);
		
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
		storage = mock(Storage.class);
		
		when(storageService.getStorage()).thenReturn(storage);
	}
	
	@Test
	public void controllerShouldReturnFoundWordsFromStorage() throws Exception {
		WordWithFrequency wordWithFrequency = new WordWithFrequency("word", 10);
		
		when(storage.searchWordsBy(new Prefix("w"))).thenReturn(Arrays.asList(wordWithFrequency));
		
		mockMvc.perform(get(URL_WITH_PREFIX))
		       .andExpect(status().isOk())
		       .andExpect(jsonPath("$[0]", is("word")));
		
		verify(storage, times(1)).searchWordsBy(new Prefix("w"));
		verifyNoMoreInteractions(storage);
	}
	
	@Test
	public void controllerShouldReturnEmptyArrayWhenNoWordsFound() throws Exception {
		when(storage.searchWordsBy(new Prefix("w"))).thenReturn(Collections.<WordWithFrequency>emptyList());
		
		mockMvc.perform(get(URL_WITH_PREFIX))
		       .andExpect(status().isOk())
		       .andExpect(jsonPath("$", hasSize(0)));
	}
	
	@Test
	public void controllerShouldReturnEmptyArrayWhenPrefixNotSet() throws Exception {
		mockMvc.perform(get(URL))
	       .andExpect(status().isOk())
	       .andExpect(jsonPath("$", hasSize(0)));
	}
	
}
