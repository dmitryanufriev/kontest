package ru.kontur.kontest.web.configuration;

import ru.kontur.kontest.web.services.StorageService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesContext {

  @Bean
  public StorageService storageService() {
    return new StorageService();
  }
}
