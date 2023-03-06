package com.piyush.spring.basic.springin5steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.piyush.spring.basic.cdi.SomeCDIBusiness;
import com.piyush.spring.basic.springin5steps.basic.BinarySearchImpl;
import com.piyush.spring.basic.springin5steps.scope.PersonDao;


@Configuration //defines it is a Spring configuration
@ComponentScan("com.piyush.spring.basic.springin5steps")
@ComponentScan("com.piyush.spring.basic.cdi")
//@SpringBootApplication automatically calls the above annotation
public class SpringIn5StepsCDIApplication {
	private static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsCDIApplication.class);
	public static void main(String[] args) {
		//BinarySearchImpl binarySearch=new BinarySearchImpl(new BubbleSort() );
		AnnotationConfigApplicationContext applicationContext =new AnnotationConfigApplicationContext(SpringIn5StepsBasicApplication.class);
		SomeCDIBusiness business = applicationContext.getBean(SomeCDIBusiness.class);
		
		LOGGER.info("{}",business);
		
	}
}
