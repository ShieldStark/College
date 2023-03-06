package com.piyush.spring.basic.cdi;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Named
public class SomeCDIBusiness {
	@Inject
	SomeCDIDao someCDIDAO;

	public SomeCDIDao getSomeCDIDAO() {
		return someCDIDAO;
	}

	public void setSomeCDIDAO(SomeCDIDao someCDIDAO) {
		this.someCDIDAO = someCDIDAO;
	}
	
	public int findGreatest() {
		int greatest=Integer.MIN_VALUE;
		int []data=someCDIDAO.getData();
		for(int value:data) {
			greatest=Math.max(value, greatest);
		}
		return greatest;
	}
}
