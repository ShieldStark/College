package com.piyush.cms.cmsys.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.piyush.cms.cmsys.model.Person;
import com.piyush.cms.cmsys.repository.ContactRepository;

@Service
public class ContactService {
	
	
	private static List<Person> person;
	private static int personCount=-1;
	private ContactRepository contactRepository;
	@Autowired
	public void setContactRepository(ContactRepository contactRepository) {
		this.contactRepository=contactRepository;
	}
	public void setDao() {
		person=new ArrayList<Person>();
		for(Person p:contactRepository.findAll()) {
			person.add(p);
		}
	}	
	
	public List<Person> retrieveTodos() {
		personCount=person.size();
        List<Person> filteredTodos = new ArrayList<Person>();
        for (Person per : person) {
                filteredTodos.add(per);
        }
        return filteredTodos;
    }
	public List<Person> retrieveTodos(int id) {
		personCount=person.size();
        List<Person> filteredTodos = new ArrayList<Person>();
        for (Person per : person) {
            if (per.getId()==id) {
                filteredTodos.add(per);
                return filteredTodos;
            }
        }
        return new ArrayList<Person>();
    }
	public Person retrieve(int id) {
		personCount=person.size();
        for (Person per : person) {
            if (per.getId()==id) {
                
                return per;
            }
        }
        return null;
    }
	public void addTodo(String name, String mobile) {
		personCount=person.size();
		Person p=new Person(++personCount, mobile, name);
        person.add(p);
        contactRepository.insert(p);
    }
    public void updateTodo(Person per) {
    	personCount=person.size();
		person.remove(per);
		person.add(per);
	}
    public void deleteTodo(int id) {
    	personCount=person.size();
    	personCount--;
        Iterator<Person> iterator = person.iterator();
        while (iterator.hasNext()) {
            Person per = iterator.next();
            if (per.getId() == id) {
                iterator.remove();
            }
        }
        contactRepository.deleteById(id);
        
    }
	
	

}
