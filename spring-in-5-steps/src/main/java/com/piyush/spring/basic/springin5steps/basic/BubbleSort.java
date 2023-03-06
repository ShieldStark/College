package com.piyush.spring.basic.springin5steps.basic;

import java.util.Arrays;



import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//Component of class
@Component

//If two component then we can one component primary
@Primary
public class BubbleSort implements SortAlgorithms{
	
	public int[] sort(int []numbers) {
		Arrays.sort(numbers);
		return numbers;
		
	}
}
