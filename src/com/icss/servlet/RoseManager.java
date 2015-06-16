package com.icss.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.po.Order;
import com.icss.po.Rose;
import com.icss.service.RoseService;
import com.icss.util.Tool;
import com.icss.vo.PageVO;
import com.icss.vo.UserVO;

@WebServlet("/roseManager")
public class RoseManager extends HttpServlet {
	
	private RoseService roseService = new RoseService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//不带参数,转向到玫瑰管理页面
		if (request.getQueryString() == null) {
			try {
				PageVO<Rose> pageVO = roseService.getAllRose(new PageVO<Rose>());
				request.setAttribute("pageVO", pageVO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("admin/rose-manager.jsp").forward(request, response);
		}else {
			String method = request.getParameter("method");
			//分页查找用户
			if (method.equals("pageFindRose")) {
				pageFindRose(request, response);
				return;
			}
			//添加玫瑰
			if (method.equals("add")) {
				add(request, response);
				return;
			}
			//删除
			if (method.equals("delete")) {
				delete(request,response);
				return;
			}
		}
	}
	/**
	 * 分页查找
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void pageFindRose(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int page = Integer.valueOf(request.getParameter("page"));
		PageVO<Rose> param = new PageVO<Rose>();
		param.setPage(page);
		try {
			PageVO<Rose> pageVO = roseService.getAllRose(param);
			request.setAttribute("pageVO", pageVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("admin/rose-manager.jsp").forward(request, response);
	}
	/**
	 * 添加玫瑰
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void add(HttpServletRequest request, HttpServletResponse response) throws IOException{
//		Integer typeId = Integer.valueOf(request.getParameter("typeId"));
//		String account = request.getParameter("account");
//		String password = request.getParameter("password");
//		String email = request.getParameter("email");
//		String mobile = request.getParameter("mobile");
//		User user = new User();
//		user.setTypeId(typeId);
//		user.setAccount(account);
//		user.setPassword(password);
//		user.setEmail(email);
//		user.setMobile(mobile);
//		user.setCreateTime(Tool.getCurrentTime());
//		try {
//			userService.addUser(user);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		response.sendRedirect("userManager");
	}
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Integer roseId = Integer.valueOf(request.getParameter("roseId"));
		Rose rose = new Rose();
		rose.setRoseId(roseId);
		try {
			roseService.deleteRose(rose);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("roseManager");
	}
	
}
