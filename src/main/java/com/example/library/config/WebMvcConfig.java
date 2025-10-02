package com.example.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.example.library.web"})
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver r = new SpringResourceTemplateResolver();
        r.setPrefix("/WEB-INF/templates/");
        r.setSuffix(".html");
        r.setTemplateMode("HTML");
        r.setCharacterEncoding("UTF-8");
        r.setCacheable(false);
        return r;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine e = new SpringTemplateEngine();
        e.setTemplateResolver(templateResolver());
        return e;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver v = new ThymeleafViewResolver();
        v.setTemplateEngine(templateEngine());
        v.setCharacterEncoding("UTF-8");
        registry.viewResolver(v);
    }
}
