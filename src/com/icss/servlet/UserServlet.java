package com.icss.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.po.User;
import com.icss.service.UserService;
/**
 * 
 * 用户管理
 * @author 金凤
 *
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	
	private UserService userService = new UserService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getQueryString() == null) {
			request.getRequestDispatcher("user_info.jsp").forward(request, response);
		}else {
			String method = request.getParameter("method");
			if (method.equals("editPwdPage")) {
				request.getRequestDispatcher("user_pwd.jsp").forward(request, response);
				return;
			}
			if (method.equals("edit")) {
				edit(request, response);
				return;
			}
			if (method.equals("editPwd")) {
				editPwd(request,response);
				return;
			}
		}
		
	}
	/**
	 * 编辑用户信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取前台传来的
		String mobile = (String)request.getParameter("mobile");
		String email = (String)request.getParameter("email");
		HttpSession session = request.getSession();
		User user =(User)session.getAttribute("user");
		user.setMobile(mobile);
		user.setEmail(email);
		try {
			userService.modifyUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("user", user);
		response.sendRedirect("user");
	}
	/**
	 * 修改密码
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void editPwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newpwd= request.getParameter("newpwd");
		HttpSession session = request.getSession();
		User user =(User)session.getAttribute("user");
		user.setPassword(newpwd);
		try {
			userService.modifyUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.invalidate();
		response.sendRedirect("./");
	}

}
