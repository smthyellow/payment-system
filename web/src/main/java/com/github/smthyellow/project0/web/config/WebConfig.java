package com.github.smthyellow.project0.web.config;

import com.github.smthyellow.project0.service.ServiceConfig;
import com.github.smthyellow.project0.service.authUserService.AuthUserService;
import com.github.smthyellow.project0.web.controller.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
    private ServiceConfig serviceConfig;

    public WebConfig(ServiceConfig serviceConfig) {
        this.serviceConfig = serviceConfig;
    }

    @Bean
    public LoginController loginController(){
        return new LoginController(serviceConfig.authUserService(), serviceConfig.userService());
    }

    @Bean
    public PersonalPageController personalPageController(){
        return new PersonalPageController(serviceConfig.userService());
    }

    @Bean
    public MainPageController mainPageController() {
        return new MainPageController(serviceConfig.authUserService(), serviceConfig.userService());
    }

    @Bean
    public RegistrationController registrationController(){
        return new RegistrationController(serviceConfig.authUserService(), serviceConfig.userService());
    }

    @Bean
    public AdministrationController administrationController(){
        return new AdministrationController(serviceConfig.authUserService(), serviceConfig.userService());
    }

    @Bean
    public UrlBasedViewResolver tilesViewResolver(){
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setViewClass(TilesView.class);
        return resolver;
    }

    @Bean
    public TilesConfigurer tilesConfigurer(){
        final TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("/WEB-INF/tiles.xml");
        return tilesConfigurer;
    }
}
