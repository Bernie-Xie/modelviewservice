package com.inno.modelview;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SetUp {
	
	public static ApplicationContext loadSpringContext(){
		return new FileSystemXmlApplicationContext("classpath:applicationContext-servlet.xml", "classpath:spring-hibernate.xml");
	}
	
	public static void main(String[] args){
		ApplicationContext applicationContext = SetUp.loadSpringContext();
		System.out.println(applicationContext);
	}
	
}
