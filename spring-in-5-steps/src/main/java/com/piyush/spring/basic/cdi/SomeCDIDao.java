package com.piyush.spring.basic.cdi;

import javax.inject.Named;

import org.springframework.stereotype.Component;

@Named
public class SomeCDIDao {
	public int[] getData() {
		return new int[] {5,89,100};
	}
}
