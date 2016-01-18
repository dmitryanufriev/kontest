package ru.kontur.kontest.web;

import static org.mockito.Mockito.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.kontur.kontest.storages.Storage;

@Configuration
public class HttpContext {

	@Bean
	public Storage storage() {
		return mock(Storage.class);
	}
	
}
