package com.jxc.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringBeanFactoryUtils implements ApplicationContextAware{
	private static ApplicationContext ctx;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ctx=applicationContext;
		
	}
	
	public static ApplicationContext getApplicationContext() {
	        return ctx;
	   }
	
	public static Object getBean(String beanName) {
        return ctx.getBean(beanName);
    }

}
