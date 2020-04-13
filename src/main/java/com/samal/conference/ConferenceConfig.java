package com.samal.conference;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import java.util.Locale;


/**
 * @author Aliaksandr Samal
 */
@Configuration
public class ConferenceConfig implements WebMvcConfigurer
{
  private final ApplicationContext applicationContext;


  public ConferenceConfig(ApplicationContext applicationContext)
  {
    this.applicationContext = applicationContext;
  }


  @Override
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


  @Bean
  public ViewResolver viewResolver()
  {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/jsp/");
    resolver.setPrefix(".jsp");
    resolver.setOrder(1);
    return resolver;
  }


  @Bean
  public ViewResolver thymeleafResolver()
  {
    ThymeleafViewResolver resolver = new ThymeleafViewResolver();
    resolver.setTemplateEngine(templateEngine());
    resolver.setOrder(0);
    return resolver;
  }


  @Bean
  public SpringResourceTemplateResolver templateResolver()
  {
    SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
    resolver.setApplicationContext(applicationContext);
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".html");
    return resolver;
  }


  @Bean
  public SpringTemplateEngine templateEngine()
  {
    SpringTemplateEngine engine = new SpringTemplateEngine();
    engine.setTemplateResolver(templateResolver());
    engine.setEnableSpringELCompiler(true);
    return engine;
  }

}
