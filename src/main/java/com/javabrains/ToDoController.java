package com.javabrains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javabrains.model.ToDo;
import com.javabrains.service.ToDoService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ToDoController {

	@Autowired
	public ToDoService toDoService;
	
	@RequestMapping(value = "/createTodo", method = RequestMethod.GET)
	public String createTodo(Model model) {
		model.addAttribute("task123", new ToDo());
		return "createTodo";
	}
	
	@RequestMapping(value = "/saveTodo", method = RequestMethod.POST)
	public String saveTodo(Model model ,@ModelAttribute("task123") ToDo todo) {
		
		toDoService.save(todo);
		log.debug("saving - {}", todo );
		model.addAttribute("saved", true);
		return "createTodo";
	}
	
}
