package com.piyush.spring.basic.springin5steps.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Component
public class SomeExternalService {
	
	@Value("${external.service.url}")
	private String url;
	public String returnServiceURL() {
		return url;
	}
}
