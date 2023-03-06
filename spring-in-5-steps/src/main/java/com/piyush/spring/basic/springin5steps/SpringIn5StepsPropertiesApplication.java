package com.piyush.spring.basic.springin5steps;



import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.piyush.spring.basic.springin5steps.basic.BinarySearchImpl;
import com.piyush.spring.basic.springin5steps.properties.SomeExternalService;

@Configuration
@ComponentScan("com.piyush.spring.basic.springin5steps")
@PropertySource("classpath:app.properties")// define properties resources
public class SpringIn5StepsPropertiesApplication {

	public static void main(String[] args) {
		//BinarySearchImpl binarySearch=new BinarySearchImpl(new BubbleSort() );
		AnnotationConfigApplicationContext applicationContext =new AnnotationConfigApplicationContext(SpringIn5StepsPropertiesApplication.class);
		SomeExternalService service = applicationContext.getBean(SomeExternalService.class);
		
		System.out.println(service.returnServiceURL());
		
		
	}
}
