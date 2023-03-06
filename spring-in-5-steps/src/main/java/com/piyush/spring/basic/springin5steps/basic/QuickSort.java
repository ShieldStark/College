package com.piyush.spring.basic.springin5steps.basic;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//Component of class
@Component
@Qualifier("quick")
public class QuickSort implements SortAlgorithms {
	public int[] sort(int []numbers) {
		Arrays.sort(numbers);
		return numbers;
		
	}
}
