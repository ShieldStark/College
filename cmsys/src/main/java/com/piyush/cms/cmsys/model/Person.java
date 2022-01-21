package com.piyush.cms.cmsys.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
@Entity
@NamedQuery(name="find_all_persons", query="select p from Person p")
public class Person {
	
	@Id
	private int id;
	private String mobile;
	private String name;
	public Person() {
		super();
	}
	/*public Person( String mobile, String name) {
		super();
		this.mobile = mobile;
		this.name = name;
	}*/
	public Person(int id, String mobile, String name) {
		super();
		this.id = id;
		this.mobile = mobile;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", mobile=" + mobile + ", name=" + name + "]";
	}
	
}
