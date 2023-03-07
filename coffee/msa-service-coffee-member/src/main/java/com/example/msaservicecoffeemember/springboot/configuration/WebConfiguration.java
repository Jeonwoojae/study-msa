package com.example.msaservicecoffeemember.springboot.configuration;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.h2.server.web.WebServlet;

@Configuration
public class WebConfiguration {
    static final String h2DbWebConsoleContext = "/console/*";

    @Bean
    ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean servletRegistrationBean
                = new ServletRegistrationBean(new WebServlet());
        servletRegistrationBean.addUrlMappings(h2DbWebConsoleContext);
        return servletRegistrationBean;
    }
}
