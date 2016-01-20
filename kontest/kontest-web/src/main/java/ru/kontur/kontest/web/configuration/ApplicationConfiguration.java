package ru.kontur.kontest.web.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ApplicationConfiguration implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
    rootContext.register(ApplicationContext.class);

    ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DISPATCHER_SERVLET_NAME,
        new DispatcherServlet(rootContext));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping(DISPATCHER_SERVLET_MAPPING);

    servletContext.addListener(new ContextLoaderListener(rootContext));
  }

  private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
  private static final String DISPATCHER_SERVLET_MAPPING = "/";
}
