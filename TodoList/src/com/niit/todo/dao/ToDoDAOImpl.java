package com.niit.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.niit.todo.config.DBConfig;
import com.niit.todo.model.MyToDo;

public class ToDoDAOImpl implements TodoDAO {

	Connection connection=null;
	PreparedStatement pst;
	
	public ToDoDAOImpl()
	{
		connection = DBConfig.connect();
	}
	@Override
	public boolean addTodo(MyToDo todo) {
		int count=0;
		try {
			pst = connection.prepareStatement("insert into todo values(?,?,?,?,?,?,?)");
			
			pst.setString(1, todo.getToDoId());
			pst.setString(2, todo.getSubject());
			pst.setString(3, todo.getDetail());
			pst.setDate(4, convertUtilToSql(todo.getAssignmentDate()));
			pst.setDate(5, convertUtilToSql(todo.getTargetDate()));
			pst.setString(6, todo.getTargetTime());
			pst.setString(7, todo.getStatus());
	
			count=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (count>0) ? true : false;
	}

	@Override
	public boolean updateTodo(MyToDo todo) {
		int count=0;
		try {
			pst = connection.prepareStatement("update todo set subject=?,detail=?,assigndate=?,targetdate=?,targettime=?,status=? where todoid=?");
			
			pst.setString(7, todo.getToDoId());
			pst.setString(1, todo.getSubject());
			pst.setString(2, todo.getDetail());
			pst.setDate(3, convertUtilToSql(todo.getAssignmentDate()));
			pst.setDate(4, convertUtilToSql(todo.getTargetDate()));
			pst.setString(5, todo.getTargetTime());
			pst.setString(6, todo.getStatus());
	
			count=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (count>0) ? true : false;
	}

	@Override
	public boolean deleteTodo(String todoId) {
		int count=0;
		try {
			pst = connection.prepareStatement("delete from todo where todoid=?");
			
			pst.setString(1, todoId);
	
			count=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return (count>0) ? true : false;
	}

	@Override
	public List<MyToDo> getAllTodo() {
		List<MyToDo> list=new ArrayList<MyToDo>();
		try {
			pst = connection.prepareStatement("select * from todo ");
			
			ResultSet rs=pst.executeQuery();
			MyToDo todo=new MyToDo();
			while(rs.next())
			{
				todo.setToDoId(rs.getString(1));
				todo.setSubject(rs.getString(2));
				todo.setDetail(rs.getString(3));
				todo.setAssignmentDate(rs.getDate(4));
				todo.setTargetDate(rs.getDate(5));
				todo.setTargetTime(rs.getString(6));
				todo.setStatus(rs.getString(7));
				
				list.add(todo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<MyToDo> getTodoByTargetDate(Date targetDate) {
		List<MyToDo> list=new ArrayList<MyToDo>();
		try {
			pst = connection.prepareStatement("select * from todo where targetdate =?");
			pst.setDate(1, convertUtilToSql(targetDate));
			ResultSet rs=pst.executeQuery();
			MyToDo todo=new MyToDo();
			while(rs.next())
			{
				todo.setToDoId(rs.getString(1));
				todo.setSubject(rs.getString(2));
				todo.setDetail(rs.getString(3));
				todo.setAssignmentDate(rs.getDate(4));
				todo.setTargetDate(rs.getDate(5));
				todo.setTargetTime(rs.getString(6));
				todo.setStatus(rs.getString(7));
				
				list.add(todo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<MyToDo> getByPendingSatus() {
		List<MyToDo> list=new ArrayList<MyToDo>();
		try {
			pst = connection.prepareStatement("select * from todo where status like '%pending%'");
			
			ResultSet rs=pst.executeQuery();
			MyToDo todo=new MyToDo();
			while(rs.next())
			{
				todo.setToDoId(rs.getString(1));
				todo.setSubject(rs.getString(2));
				todo.setDetail(rs.getString(3));
				todo.setAssignmentDate(rs.getDate(4));
				todo.setTargetDate(rs.getDate(5));
				todo.setTargetTime(rs.getString(6));
				todo.setStatus(rs.getString(7));
				
				list.add(todo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	private java.sql.Date convertUtilToSql(java.util.Date uDate) {
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		return sDate;
	}
}
