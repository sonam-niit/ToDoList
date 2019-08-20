package com.niit.todo.dao;

import java.util.Date;
import java.util.List;

import com.niit.todo.model.MyToDo;

public interface TodoDAO {

	public boolean addTodo(MyToDo todo);
	public boolean updateTodo(MyToDo todo);
	public boolean deleteTodo(String todoId);
	public List<MyToDo> getAllTodo();
	public List<MyToDo> getTodoByTargetDate(Date targetDate);
	public List<MyToDo> getByPendingSatus();
	
}
