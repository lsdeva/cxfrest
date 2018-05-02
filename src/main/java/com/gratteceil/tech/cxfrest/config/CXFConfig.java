package com.gratteceil.tech.cxfrest.config;

import java.util.Arrays;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.apache.cxf.interceptor.security.JAASLoginInterceptor;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gratteceil.tech.auth.AuthenticationHandler;
import com.gratteceil.tech.auth.TestRequestFilter;
import com.gratteceil.tech.cxfrest.controler.UserController;

@Configuration
class CXFConfig {
  @Autowired
  private Bus bus;

  @Bean
  public Server rsServer() {
      final JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
      endpoint.setProvider(new JacksonJsonProvider());
      bus.getInInterceptors().add(new LoggingInInterceptor());
      bus.getOutInterceptors().add(new LoggingOutInterceptor());
      bus.getInInterceptors().add(new JAASLoginInterceptor());
      
//      endpoint.getProviders().add(testFilter());
      endpoint.setBus(bus);
      endpoint.setAddress("/");
      endpoint.setServiceBeans(Arrays.<Object>asList(userController()));
      endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
      return endpoint.create();
  }

  @Bean
  public UserController userController() {
      return new UserController();
  }
  
  @Bean
  public TestRequestFilter testFilter() {
	  return new TestRequestFilter();
  }
}
