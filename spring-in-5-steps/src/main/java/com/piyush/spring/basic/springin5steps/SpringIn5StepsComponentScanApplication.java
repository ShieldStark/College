package com.piyush.spring.basic.springin5steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.piyush.spring.basic.componentscan.ComponentDao;
import com.piyush.spring.basic.springin5steps.basic.BinarySearchImpl;
import com.piyush.spring.basic.springin5steps.scope.PersonDao;


@Configuration
@ComponentScan("com.piyush.spring.basic.springin5steps")//Scan different packages for component
@ComponentScan("com.piyush.spring.basic.componentscan")
public class SpringIn5StepsComponentScanApplication {
	private static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsComponentScanApplication.class);
	public static void main(String[] args) {
		//BinarySearchImpl binarySearch=new BinarySearchImpl(new BubbleSort() );
		AnnotationConfigApplicationContext applicationContext =new AnnotationConfigApplicationContext(SpringIn5StepsBasicApplication.class);
		ComponentDao componentDao = applicationContext.getBean(ComponentDao.class);
		ComponentDao componentDao2 = applicationContext.getBean(ComponentDao.class);
		LOGGER.info("{}",componentDao);
		/*LOGGER.info("{}",componentDao.getJdbcConnection());
		LOGGER.info("{}",componentDao2);
		LOGGER.info("{}",componentDao2.getJdbcConnection());*/
	}
}
