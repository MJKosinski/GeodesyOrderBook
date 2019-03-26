package com.geohor.app;

import com.geohor.converter.LocalDateConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FormatterConfig implements WebMvcConfigurer {


    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(localDateConverter());


    }

    @Bean
    public LocalDateConverter localDateConverter() {
        return new LocalDateConverter();
    }



}
