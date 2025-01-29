package com.in28minutes.learn_spring_aop.aopexample.aspect;

import java.util.logging.Logger;

import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@Aspect
public class LoggingAspect {
	
	private LoggerFactory logger = LoggerFactory.getLoggerFactory();
	public void logMethodcall() {
		
	}

}
