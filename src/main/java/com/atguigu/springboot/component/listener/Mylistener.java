package com.atguigu.springboot.component.listener;

import org.springframework.web.context.support.ServletContextLiveBeansView;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Mylistener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("web应用已启用。。。");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("当前web项目已销毁。。。");
    }
}
