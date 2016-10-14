package com.bit2016.guestbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2016.guestbook.dao.GuestbookDao;
import com.bit2016.guestbook.vo.GuestbookVo;

@WebServlet("/gs")
public class GuestbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//action name
		String actionName = request.getParameter("a");
		
		if ("add".equals(actionName)) {
			//insert
			String name = request.getParameter("name");
			String password = request.getParameter("pass");
			String content = request.getParameter("content");
			
			GuestbookVo vo = new GuestbookVo();
			vo.setName(name);
			vo.setPassword(password);
			vo.setContent(content);
			
			GuestbookDao dao = new GuestbookDao();
			dao.insert(vo);
			
			response.sendRedirect("/guestbook2/gs");
			
		} else if("delete".equals(actionName)) {
			
			String no = request.getParameter("no");
			String password = request.getParameter("password");

			GuestbookVo vo = new GuestbookVo();
			vo.setNo(Long.parseLong(no));
			vo.setPassword(password);
			
			GuestbookDao dao = new GuestbookDao();
			dao.delete(vo);
			
			response.sendRedirect("/guestbook2/gs");

		} else if("deleteform".equals(actionName)) {

			//delete form
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
			rd.forward(request, response);
			
		}  else {
			//default
			GuestbookDao dao = new GuestbookDao();
			List<GuestbookVo>list = dao.getList();
			
			//request
			request.setAttribute("list", list);
			
			//forwarding
			RequestDispatcher rd = 
					request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
		}
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
