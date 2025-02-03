package com.in10min.myfirstweb.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;

//@Controller
public class TodoController {
	
	private TodoService todoService;
	
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}


	//list-todos
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		List<Todo>todos = todoService.findByUsername("in2min");
		model.addAttribute("todos",todos);
		return "listTodos";
	}
	
	@RequestMapping(value = "add-todo",method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = (String)model.get("name"); 
		Todo todo = new Todo(0,username,"",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value = "add-todo",method = RequestMethod.POST)
	public String addNewTodo(ModelMap model,@Valid Todo todo ,BindingResult result ) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		todoService.addTodo((String)model.get("name"),todo.getDescription(),todo.getTargetDate(),false);
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		
		todoService.deleteById(id);
		
		return "redirect:list-todos";
	}
	
	@RequestMapping(value = "update-todo",method = RequestMethod.GET)
	public String updateTodo(@RequestParam int id,ModelMap model) {
		Todo todo = todoService.findById(id);
		model.addAttribute("todo",todo);
		
		return "todo";
	}
	
	
	@RequestMapping(value = "update-todo",method = RequestMethod.POST)
	public String addUpdateTodo(ModelMap model,@Valid Todo todo ,BindingResult result ) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		String username = (String)model.get("name");
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
	
	private String getLoggedInUsername(ModelMap model) {
		return (String)model.get("name");
	}

}
