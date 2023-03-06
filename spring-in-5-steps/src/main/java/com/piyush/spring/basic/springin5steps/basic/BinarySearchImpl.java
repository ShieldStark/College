package com.piyush.spring.basic.springin5steps.basic;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)//Create different instances 
public class BinarySearchImpl {
	
	private Logger logger=org.slf4j.LoggerFactory.getLogger(this.getClass());
	@Autowired
	@Qualifier("quick")//When you have to use component of class multiple time use Name or qualifier
	private SortAlgorithms BubbleSort;//Dependency
	
	/*What are the beans? @Component
	 * What are the dependencies of a bean? @Autowired
	 * Where to search for beans? @ComponentScan
	 *
	 * */
	
	
	
	//Autowiring by type from bean name 'binarySearchImpl' via constructor
	/*public BinarySearchImpl(SortAlgorithms sortAlgorithms) {
		super();
		this.sortAlgorithms=sortAlgorithms;
	}*/
	public int binarySearch(int numbers[],int numberToSearch) {
		int [] arr=BubbleSort.sort(numbers);
		System.out.println(BubbleSort);
		return 3;
		
	}
	@PostConstruct/*As soon as all the dependency are constructed pre construct are called*/
	public void postConstruct() {
		logger.info("postConstruct");
	}
	@PreDestroy/*The Predestroy annotation is used on method as a callback notification to signal that the instance is in the process of being removed by the container*/
	public void preDestroy() {
		logger.info("preDestroy");
	}

}
