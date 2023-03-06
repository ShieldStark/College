package com.piyush.spring.basic.springin5steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.piyush.spring.basic.springin5steps.basic.BinarySearchImpl;
import com.piyush.spring.basic.springin5steps.scope.PersonDao;


@Configuration
@ComponentScan("com.piyush.spring.basic.springin5steps")
public class SpringIn5StepsSocpeApplication {
	private static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsSocpeApplication.class);
	public static void main(String[] args) {
		//BinarySearchImpl binarySearch=new BinarySearchImpl(new BubbleSort() );
		AnnotationConfigApplicationContext applicationContext =new AnnotationConfigApplicationContext(SpringIn5StepsBasicApplication.class);
		PersonDao personDao = applicationContext.getBean(PersonDao.class);
		PersonDao personDao2 = applicationContext.getBean(PersonDao.class);
		LOGGER.info("{}",personDao);
		LOGGER.info("{}",personDao.getJdbcConnection());
		LOGGER.info("{}",personDao2);
		LOGGER.info("{}",personDao2.getJdbcConnection());
	}
}
