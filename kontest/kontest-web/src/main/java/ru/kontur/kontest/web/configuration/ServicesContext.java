package ru.kontur.kontest.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.kontur.kontest.web.services.StorageService;

@Configuration
public class ServicesContext {

  @Bean
  public StorageService storageService() {
    return new StorageService();
  }
}
