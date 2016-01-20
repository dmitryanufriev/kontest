package ru.kontur.kontest.web;

import static org.mockito.Mockito.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.kontur.kontest.web.services.StorageService;

@Configuration
public class HttpContext {

  @Bean
  public StorageService storageService() {
    return mock(StorageService.class);
  }
}
