package com.icss.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.po.User;
import com.icss.service.UserService;
import com.icss.util.Tool;
import com.icss.vo.PageVO;
import com.icss.vo.UserVO;

@WebServlet("/userManager")
public class UserManager extends HttpServlet {
	
	private UserService userService = new UserService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//不带参数,转向到用户管理页面
		if (request.getQueryString() == null) {
			try {
				PageVO<UserVO> pageVO = userService.getAllUser(new PageVO<UserVO>());
				request.setAttribute("pageVO", pageVO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("admin/user-manager.jsp").forward(request, response);
		}else {
			String method = request.getParameter("method");
			//分页查找用户
			if (method.equals("pageFindUser")) {
				pageFindUser(request, response);
				return;
			}
			//根据关键字查找用户
			if (method.equals("searchUser")) {
				searchUser(request, response);
				return;
			}
			//添加用户
			if (method.equals("add")) {
				add(request,response);
				return;
			}
			//修改用户
			if (method.equals("edit")) {
				edit(request, response);
				return;
			}
			//删除用户
			if (method.equals("delete")) {
				delete(request,response);
				return;
			}
			//批量删除用户
			if (method.equals("deletes")) {
				deletes(request,response);
				return;
			}
		}
		
	}
	/**
	 * 分页查找用户
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void pageFindUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int page = Integer.valueOf(request.getParameter("page"));
		PageVO<UserVO> param = new PageVO<UserVO>();
		param.setPage(page);
		try {
			PageVO<UserVO> pageVO = userService.getAllUser(param);
			//System.out.println("当前页："+pageVO.getPage());
			//System.out.println("总页数："+pageVO.getTotalPage());
			request.setAttribute("pageVO", pageVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("admin/user-manager.jsp").forward(request, response);
	}
	/**
	 * 根据关键字查找用户
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void searchUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String q = request.getParameter("q");
		String p = request.getParameter("page");
		PageVO<UserVO> param = new PageVO<UserVO>();
		if (p != null) {
			int page = Integer.valueOf(p);
			param.setPage(page);
		}
		try {
			PageVO<UserVO> pageVO = userService.searchUser(q, param);
			//System.out.println("当前页："+pageVO.getPage());
			//System.out.println("总页数："+pageVO.getTotalPage());
			request.setAttribute("pageVO", pageVO);
			request.setAttribute("q", q);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("admin/user-manager.jsp").forward(request, response);
	}
	/**
	 * 添加用户
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void add(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Integer typeId = Integer.valueOf(request.getParameter("typeId"));
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		User user = new User();
		user.setTypeId(typeId);
		user.setAccount(account);
		user.setPassword(password);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setCreateTime(Tool.getCurrentTime());
		try {
			userService.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("userManager");
	}
	/**
	 * 修改用户
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void edit(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		Integer typeId = Integer.valueOf(request.getParameter("typeId"));
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		User user = new User();
		user.setUserId(userId);
		try {
			user = userService.findByUserId(user);
			user.setTypeId(typeId);
			user.setPassword(password);
			user.setEmail(email);
			user.setMobile(mobile);
			userService.modifyUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("userManager");
	}
	/**
	 * 删除用户
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		User user = new User();
		user.setUserId(userId);
		try {
			userService.deleteUser(user);
			out.print(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print(0);
		}
		out.close();
	}
	/**
	 * 批量删除用户
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void deletes(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		String ids = request.getParameter("ids");
		//System.out.println(ids);
		String[] array = ids.split(",");
		User user = new User();
		for (int i = 0; i < array.length; i++) {
			Integer userId = Integer.valueOf(array[i]);
			user.setUserId(userId);
			try {
				userService.deleteUser(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print(0);
			}
		}
		out.print(1);
		out.close();
	}
	
	
}
