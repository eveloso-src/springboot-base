package com.foo.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {



//	@Override
//	public void configureViewResolvers(ViewResolverRegistry registry) {
//		registry.jsp().prefix("/resources/templates/").suffix(".jsp");
//	}

	
	/**
	 * FUNDAMENTAL PARA REEMPLAZA EL LOGIN DEFAULT
	 */
//	 @Override
//     public void addViewControllers(ViewControllerRegistry registry) {
//         ViewControllerRegistration r = registry.addViewController("/loginEvent");
//         r.setViewName("login");
//     }
	
//	  @Bean
//	  public ViewResolver viewResolver() {
//	      InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//	      viewResolver.setPrefix("/WEB-INF/");
//	      viewResolver.setSuffix(".jsp");
//	      return viewResolver;
//	  }
}
