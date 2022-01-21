package com.piyush.cms.cmsys.repository;
//import java.util.List;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;*/
import org.springframework.stereotype.Repository;

import com.mysql.cj.Query;
import com.piyush.cms.cmsys.model.Person;
@Repository
@Transactional
public class ContactRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Person findById(int id){
		return entityManager.find(Person.class, id);
	}
	public Person update(Person person) {
		return entityManager.merge(person);
	}
	public Person insert(Person person) {
		return entityManager.merge(person);
	}
	public List<Person> findAll(){
		//Query query=(Query) entityManager.createQuery("Select * from Person");
		TypedQuery<Person> namedQuery= entityManager.createNamedQuery("find_all_persons",Person.class);
		return namedQuery.getResultList();
	}
	public void deleteById(int id) {
		Person person=findById(id);
		entityManager.remove(person);
	}
	/*@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Person> findAll(){
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
	}
	@SuppressWarnings("deprecation")
	public Person findById(int id){
		return jdbcTemplate.queryForObject("select * from person where id=?", new Object[]{id} ,new BeanPropertyRowMapper<Person>(Person.class));
	}
	public int deleteById(int id){
		return jdbcTemplate.update("delete from person where id=?", new Object[]{id});
	}
	public int insert(Person person){
		return jdbcTemplate.update("insert into person(id,mobile,name) values(?,?,?)", new Object[]{person.getId(),person.getMobile(),person.getName()});
	}
	public int update(Person person){
		return jdbcTemplate.update("update person set mobile=?,name=? where id=?", new Object[]{person.getMobile(),person.getName(),person.getId()});
	}*/

}
