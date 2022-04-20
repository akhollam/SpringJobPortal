package com.javabrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.javabrains.model.ToDo;

@Repository
public class ToDoServiceDao implements ToDoService {

	@Autowired
	public JdbcTemplate jdbcTemplate;

	public void save(ToDo todo) {
		jdbcTemplate.update("INSERT INTO todo(task) VALUES (?)", todo.getTask());
	}

}
