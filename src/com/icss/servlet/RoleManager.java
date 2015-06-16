package com.icss.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.po.User;
import com.icss.po.Utype;
import com.icss.service.UserService;
import com.icss.service.UtypeService;
import com.icss.util.Tool;
import com.icss.vo.RoleVO;


@WebServlet("/roleManager")
public class RoleManager extends HttpServlet {
	
	private UtypeService utypeService = new UtypeService();
	private UserService userService = new UserService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//不带参数,转向到角色管理页面
		if (request.getQueryString() == null) {
			try {
				List<RoleVO> roleList = utypeService.getAllRole();
				for (RoleVO roleVO : roleList) {
					Integer typeId = roleVO.getTypeId();
					roleVO.setuList(userService.findByType(typeId));
				}
				request.setAttribute("roleList", roleList);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("admin/role-manager.jsp").forward(request, response);
		}else {
			String method = request.getParameter("method");
			//添加角色
			if (method.equals("add")) {
				add(request, response);
				return;
			}
			//修改角色
			if (method.equals("edit")) {
				edit(request, response);
				return;
			}

		}
	}
	/**
	 * 添加角色
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void add(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String typeName = request.getParameter("typeName");
		Utype utype = new Utype();
		utype.setTypeName(typeName);
		try {
			utypeService.addUtype(utype);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("roleManager");
	}
	/**
	 * 修改角色
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void edit(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Integer typeId = Integer.valueOf(request.getParameter("typeId"));
		String typeName = request.getParameter("typeName");
		Utype utype = new Utype();
		utype.setTypeId(typeId);
		utype.setTypeName(typeName);
		try {
			utypeService.modify(utype);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("roleManager");
	}

}
