package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static List<Todo> todos=new ArrayList<Todo>();
	
	private static int todosCount=0;
	static {
		todos.add(new Todo(++todosCount, "sid", "Learn Java 1", LocalDate.now().plusDays(3), false));
		todos.add(new Todo(++todosCount, "sid", "Learn Spring 1", LocalDate.now().plusDays(6), false));
		todos.add(new Todo(++todosCount, "sid", "Learn Sql 1", LocalDate.now().plusDays(11), false));
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate=todo ->todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo=new Todo(++todosCount, username, description, targetDate, done);
		todos.add(todo);
	}
	
	public void deleteTodo(int id) {
		Predicate<? super Todo> predicate=todo ->todo.getId()==id;
		todos.removeIf(predicate);
	}
	public Todo findById(int id) {
		Predicate<? super Todo> predicate=todo ->todo.getId()==id;
		return todos.stream().filter(predicate).findFirst().get();
	}
	public void updateTodo(@Valid Todo todo) {
		deleteTodo(todo.getId());
		todos.add(todo);
	}
}
