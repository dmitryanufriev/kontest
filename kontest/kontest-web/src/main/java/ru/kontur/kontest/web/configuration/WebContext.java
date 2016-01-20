package ru.kontur.kontest.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "ru.kontur.kontest.web" })
public class WebContext extends WebMvcConfigurerAdapter {

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
  }

  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

    viewResolver.setViewClass(JstlView.class);
    viewResolver.setPrefix(VIEW_RESOLVER_PREFIX);
    viewResolver.setSuffix(VIEW_RESOLVER_SUFFIX);

    return viewResolver;
  }

  private static final String VIEW_RESOLVER_PREFIX = "/WEB-INF/pages/";
  private static final String VIEW_RESOLVER_SUFFIX = ".jsp";
}
