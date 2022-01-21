package com.piyush.cms.cmsys.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.piyush.cms.cmsys.model.Person;
import com.piyush.cms.cmsys.service.ContactService;


@Controller
public class ContactController{
	
	
	ContactService contactService;
	@Autowired
	public void setContactService(ContactService contactService) {
		this.contactService=contactService;
		contactService.setDao();
	}

	
	@RequestMapping(value="/contact/retrieve", method=RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		
		model.put("contacts", contactService.retrieveTodos());
		return "list-todos";
	}
	@RequestMapping(value="/contact/retrieve/{id}", method=RequestMethod.GET)
	public String showPersonPage(ModelMap model,@PathVariable("id") int id) {
		
		model.put("contacts", contactService.retrieveTodos(id));
		return "list-todos";
	}
	@RequestMapping(value="/contact/save", method=RequestMethod.GET)
	public String showAddTodos(ModelMap model) {
		
		model.addAttribute("todo", new Person(0,"","Person"));
		return "todo";
	}
	@RequestMapping(value="/contact/save", method=RequestMethod.POST)
	public String addTodos(ModelMap model,@RequestParam String mobile,@RequestParam String name) {
		contactService.addTodo(name, mobile);
		return "redirect:/contact/retrieve";
	}
	@RequestMapping(value="/delete-todo", method=RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		contactService.deleteTodo(id);
		return "redirect:/contact/retrieve";
	}
	@RequestMapping(value="/update-todo", method=RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id,ModelMap model) {
		Person p=contactService.retrieve(id);
		model.put("todo", p);
		return "redirect:/contact/save";
	}
	@RequestMapping(value="/update-todo", method=RequestMethod.POST)
	public String updateTodo(Person person) {
		contactService.updateTodo(person);
		return "redirect:/contact/retrieve";
	}
}
