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

@Controller
public class TodoControllerJpa {
	
	private TodoService todoService;
	
	
	public TodoControllerJpa(TodoService todoService,TodoRepository todoRepository) {
		super();
		this.todoService = todoService;
		this.todoRepository = todoRepository;
	}
	
	private TodoRepository todoRepository;


	//list-todos
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username = getLoggedInUsername(model); 
		
		List<Todo>todos = todoRepository.findByUsername(username);
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
		String username = (String)model.get("name");
		todo.setUsername(username);
		todoRepository.save(todo);
		//todoService.addTodo(username,todo.getDescription(),todo.getTargetDate(),todo.isDone());
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		
		//todoService.deleteById(id);
		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value = "update-todo",method = RequestMethod.GET)
	public String updateTodo(@RequestParam int id,ModelMap model) {
		Todo todo = todoRepository.findById(id).get();
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
		todoRepository.save(todo);
		//todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
	
	private String getLoggedInUsername(ModelMap model) {
		return (String)model.get("name");
	}

}
