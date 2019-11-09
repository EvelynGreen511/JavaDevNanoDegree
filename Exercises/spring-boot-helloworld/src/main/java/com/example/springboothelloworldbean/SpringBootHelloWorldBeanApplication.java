package com.example.springboothelloworldbean;

import com.example.springboothelloworldbean.servlet.HelloBeanFilter;
import com.example.springboothelloworldbean.servlet.HelloBeanListener;
import com.example.springboothelloworldbean.servlet.HelloBeanServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootHelloWorldBeanApplication {
    /*public static void main(String[] args) {
        SpringApplication.run(SpringBootHelloWorldBeanApplication.class, args);
    }*/

    /// Register Servlet.
    @Bean
    public ServletRegistrationBean getServletRegistrationBean() {
        ServletRegistrationBean servletBean = new ServletRegistrationBean(new HelloBeanServlet());
        servletBean.addUrlMappings("/helloBeanServlet");
        return servletBean;
    }

    /// Register Filter.
    @Bean
    public FilterRegistrationBean getFilterRegistrationBean() {
        FilterRegistrationBean filterBean = new FilterRegistrationBean(new HelloBeanFilter());
        // Add filter path
        filterBean.addUrlPatterns("/helloBeanServlet");
        return filterBean;
    }

    @Bean
    public ServletListenerRegistrationBean<HelloBeanListener> getServletListenerRegistrationBean() {
        ServletListenerRegistrationBean listenerBean =
                new ServletListenerRegistrationBean(new HelloBeanListener());
        return listenerBean;
    }
}
