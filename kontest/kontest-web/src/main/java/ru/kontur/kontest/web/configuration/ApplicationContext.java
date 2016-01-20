package ru.kontur.kontest.web.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ WebContext.class, ServicesContext.class })
public class ApplicationContext {

}
