package com.niit.todo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.todo.dao.ToDoDAOImpl;
import com.niit.todo.dao.TodoDAO;
import com.niit.todo.model.MyToDo;

@WebServlet("/")
public class ToDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    TodoDAO dao=new ToDoDAOImpl();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		HttpSession session;
		String userOperations = request.getServletPath();
		MyToDo todo;
		switch(userOperations)
		{
			case "/": dispatcher=request.getRequestDispatcher("/WEB-INF/views/index.jsp");
						dispatcher.forward(request, response);
					  break;
			case "/add": 
				Date date1=null,date2=null;
						String subject=request.getParameter("subject");
						String detail=request.getParameter("detail");
						try {
							date1 = formatter.parse(request.getParameter("assigndate"));
							date2 = formatter.parse(request.getParameter("targetdate"));
							System.out.println(date1+" "+date2);
						} catch (Exception e) {
							e.printStackTrace();
						}
						String time=request.getParameter("time");
						todo=new MyToDo();
						todo.setToDoId(subject+"01");
						todo.setSubject(subject);
						todo.setDetail(detail);
						todo.setStatus("newly assigned");
						todo.setAssignmentDate(date1);
						todo.setAssignmentDate(date2);
						
						if(dao.addTodo(todo))
						{
							response.sendRedirect("/WEB-INF/views/index.jsp");
						}
						break;
			case "/delete": 
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
