package com.atguigu.springboot.config;

import com.atguigu.springboot.component.listener.Mylistener;
import com.atguigu.springboot.filter.Myfilter;
import com.atguigu.springboot.servlet.Myservlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@Configuration
public class MyServerConfig {

    //嵌入式的Servlet容器的定制器；来修改Servlet容器的配置
    @Bean
    public WebServerFactoryCustomizer webServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8088);
            }
        };
    }

    //Servlet组件
    @Bean
    public ServletRegistrationBean myservlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new Myservlet(),"/myservlet");
        return servletRegistrationBean;

    }

    //Filter组件(过滤器)
    @Bean
    public FilterRegistrationBean myfilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new Myfilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/123"));
        return filterRegistrationBean;
    }

    //Listener组件（监听）
    @Bean
    public ServletListenerRegistrationBean mylistener(){
        ServletListenerRegistrationBean<Mylistener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<>(new Mylistener());
        return servletListenerRegistrationBean;
    }
}
