package com.piyush.spring.basic.cdi;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.piyush.spring.basic.springin5steps.SpringIn5StepsBasicApplication;

@RunWith(MockitoJUnitRunner.class)
//@ContextConfiguration(classes = SpringIn5StepsBasicApplication.class)
public class SomeCdiBusinessTest {
	//@Autowired
	@InjectMocks// Creates mocks
	SomeCDIBusiness business;
	
	@Mock
	SomeCDIDao daoMock;

	@Test
	public void testBasicScenario() {
		
		Mockito.when(daoMock.getData()).thenReturn(new int[] {2,4});
		
		int result=business.findGreatest();
		assertEquals(4, result);
		//fail("Not yet implemented");
	}
	@Test
	public void testBasicScenario1() {
		
		Mockito.when(daoMock.getData()).thenReturn(new int[] { });
		
		int result=business.findGreatest();
		assertEquals(Integer.MIN_VALUE, result);
		//fail("Not yet implemented");
	}

}
