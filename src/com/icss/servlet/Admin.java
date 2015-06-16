package com.icss.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.po.User;
import com.icss.service.UserService;

@WebServlet("/admin")
public class Admin extends HttpServlet {
	
	private UserService userService = new UserService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//不带参数,转向到管理员页面
		if (request.getQueryString() == null) {
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			if (user == null) {
				response.sendRedirect("");
				return;
			}
			request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
		}else { 	
			String method = request.getParameter("method");
			//修改个人信息
			if (method.equals("editMyInfo")) {
				editMyInfo(request, response);
				return;
			}
			//修改密码
			if (method.equals("editPsw")) {
				editPsw(request,response);
				return;
			}
			//验证原密码
			if (method.equals("checkOldPsw")) {
				checkOldPsw(request,response);
				return;
			}
		}
	}
	/**
	 * 修改个人信息
	 */
	public void editMyInfo(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		if (email ==null || mobile == null || email == "" || mobile == "") {
			return;
		}
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if (user == null) {
			return;
		}
		try {
			user.setEmail(email);
			user.setMobile(mobile);
			userService.modifyUser(user);
			session.setAttribute("user", user);
			out.print("true");
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print("false");
		out.close();
	}
	/**
	 * 修改密码
	 */
	public void editPsw(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		String oldPsd = request.getParameter("oldPsd");
		String newPsd = request.getParameter("newPsd");
		if (oldPsd == null || newPsd == null || oldPsd == "" || newPsd == "") {
			return;
		}
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if (user == null) {
			return;
		}
		if (oldPsd.equals(user.getPassword())) {
			try {
				user.setPassword(newPsd);
				userService.modifyUser(user);
				session.setAttribute("user", user);
				out.print("true");
				return;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		out.print("false");
		out.close();
	}
	/**
	 * 验证原密码
	 */
	public void checkOldPsw(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		String oldPsd = request.getParameter("oldPsd");
		if (oldPsd == null || oldPsd == "") {
			return;
		}
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if (user == null) {
			return;
		}
		if (oldPsd.equals(user.getPassword())) {
			out.print("true");
			return;
		}
		out.print("false");
		out.close();
	}
	
}
