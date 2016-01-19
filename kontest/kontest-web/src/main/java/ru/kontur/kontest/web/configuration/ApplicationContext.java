package ru.kontur.kontest.web.configuration;

import org.springframework.context.annotation.*;

@Configuration
@Import({ WebContext.class, ServicesContext.class })
public class ApplicationContext {

}
