package com.samal.conference;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Locale;


/**
 * @author Aliaksandr Samal
 */
@Configuration
public class ConferenceConfig implements WebMvcConfigurer
{
  //  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry)
  {
    registry.addResourceHandler("/files/**")
        .addResourceLocations("/WEB-INF/pdf/");
  }


  @Bean
  public SessionLocaleResolver localeResolver()
  {
    SessionLocaleResolver localResolver = new SessionLocaleResolver();
    localResolver.setDefaultLocale(Locale.US);
    return localResolver;
  }


  @Bean
  public LocaleChangeInterceptor localeChangeInterceptor()
  {
    LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
    interceptor.setParamName("lang");
    return interceptor;
  }


  @Override
  public void addInterceptors(InterceptorRegistry registry)
  {
    registry.addInterceptor(localeChangeInterceptor());
  }


  //  @Bean
  public ViewResolver viewResolver()
  {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/jsp/");
    resolver.setPrefix(".jsp");
    resolver.setOrder(0);
    return resolver;
  }
}
