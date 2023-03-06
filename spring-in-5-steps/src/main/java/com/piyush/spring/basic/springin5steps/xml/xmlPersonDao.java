package com.piyush.spring.basic.springin5steps.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
//@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class xmlPersonDao {
	//@Autowired
	xmlJdbcConnection xmljdbcConnection;

	public xmlJdbcConnection getxmlJdbcConnection() {
		return xmljdbcConnection;
	}

	public void setxmlJdbcConnection(xmlJdbcConnection jdbcConnection) {
		this.xmljdbcConnection = jdbcConnection;
	}
	
}
