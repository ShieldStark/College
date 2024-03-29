package com.piyush.spring.basic.springin5steps;



import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.piyush.spring.basic.springin5steps.basic.BinarySearchImpl;

@Configuration
@ComponentScan("com.piyush.spring.basic.springin5steps")
public class SpringIn5StepsBasicApplication {

	public static void main(String[] args) {
		//BinarySearchImpl binarySearch=new BinarySearchImpl(new BubbleSort() );
		AnnotationConfigApplicationContext applicationContext =new AnnotationConfigApplicationContext(SpringIn5StepsBasicApplication.class);
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		BinarySearchImpl binarySearch1=applicationContext.getBean(BinarySearchImpl.class);
		System.out.println(binarySearch);
		System.out.println(binarySearch1);
		int result=binarySearch.binarySearch(new int[] {12, 4,6},3);
		System.out.println(result);
		applicationContext.close();
		
	}
}
