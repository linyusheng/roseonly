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
import com.icss.po.Utype;
import com.icss.service.UserService;
import com.icss.service.UtypeService;

/**
 * 功能：实现用户登录
 * 
 * @author 林玉生
 * 
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	
	private UserService userService = new UserService();
	private UtypeService utypeService = new UtypeService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String account = (String)request.getParameter("username");
		String password = (String)request.getParameter("password");
		
		//验证页面传来的参数是否为空
		if (account == "" && password == "") {
			out.print("fail");
			return;
		}
		User user = null;
		try {
			user = userService.findByAccoutPassword(account, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//无此用户
		if (user == null) {
			out.print("fail");
			return;
		}
		//存在用户，设置相应的session信息
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		//根据用户类型跳转不同的主页
		Integer typeId = user.getTypeId();
		Utype utype = new Utype();
		utype.setTypeId(typeId);
		try {
			utype = utypeService.findByUtypeId(utype);
			session.setAttribute("userType", utype.getTypeName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (typeId < 4) {
			out.print("index");
		}else {
			out.print("admin");
		}
		out.close();
		
	}

}
