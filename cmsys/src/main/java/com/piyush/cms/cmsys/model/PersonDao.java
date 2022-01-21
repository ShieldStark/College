/*package com.piyush.cms.cmsys.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class PersonDao {
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	public int savePerson(Person p) {
		String query="insert into employee values('"+p.getId()+"','"+p.getName()+"','"+p.getMobile()+"')"; 
		return jdbcTemplate.update(query);
	}
	public int updatePerson(Person p) {
		String query="update employee set name='"+p.getName()+"',mobile='"+p.getMobile()+"' where ='"+p.getId()+"' ";  
		return jdbcTemplate.update(query);
	}
	public int deleteEmployee(Person p){  
	    String query="delete from employee where id='"+p.getId()+"' ";  
	    return jdbcTemplate.update(query);  
	}  

}*/
