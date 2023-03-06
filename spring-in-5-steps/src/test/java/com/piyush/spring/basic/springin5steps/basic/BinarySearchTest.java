package com.piyush.spring.basic.springin5steps.basic;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.piyush.spring.basic.springin5steps.SpringIn5StepsBasicApplication;

@RunWith(SpringRunner.class)// Load the context
@ContextConfiguration(classes = SpringIn5StepsBasicApplication.class)// To run a configuration
public class BinarySearchTest {
	@Autowired
	BinarySearchImpl binarySearch;

	@Test
	public void testBasicScenario() {
		int result=binarySearch.binarySearch(new int[] {}, 5);
		assertEquals(3, result);
		//fail("Not yet implemented");
	}

}
