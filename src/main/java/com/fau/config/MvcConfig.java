package com.fau.config;

import com.fau.competition.resolver.CompetitionResolver;
import com.fau.driver.resolver.DriverResolver;
import com.fau.lap.domain.Lap;
import com.fau.lap.resolver.LapResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.util.List;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ServletContextTemplateResolver templateResolver() {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
        resolver.setSuffix(".html");
        resolver.setPrefix("/resources/templates/");
        resolver.setTemplateMode("HTML5");
        return resolver;
    }

    @Bean
    public CompetitionResolver competitionResolver() {
        return new CompetitionResolver();
    }

    @Bean
    public DriverResolver driverResolver() {
        return new DriverResolver();
    }

    @Bean
    public LapResolver lapResolver() {
        return new LapResolver();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/competition/all").setViewName("competitionList");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(competitionResolver());
        argumentResolvers.add(driverResolver());
        argumentResolvers.add(lapResolver());
        super.addArgumentResolvers(argumentResolvers);
    }
}