package com.icss.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.icss.po.Menu;
import com.icss.po.User;
import com.icss.service.MenuService;

/**
 * 前台菜单管理
 * 
 * @author 林玉生
 * 
 */
@WebServlet("/menuManager")
public class MenuManager extends HttpServlet {

	MenuService menuService = new MenuService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//不带参数,转向到菜单管理页面
		if (request.getQueryString() == null) {
			try {
				List<Menu> menuList = menuService.findAllMenu();
				request.setAttribute("menuList", menuList);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("admin/menu-manager.jsp").forward(request, response);
		}else {
			String method = request.getParameter("method");
			//添加菜单
			if (method.equals("add")) {
				add(request, response);
				return;
			}
			//修改菜单
			if (method.equals("edit")) {
				edit(request, response);
				return;
			}
			//删除菜单
			if (method.equals("delete")) {
				delete(request,response);
				return;
			}
			//批量删除菜单
			if (method.equals("deletes")) {
				deletes(request,response);
				return;
			}
		}
	}
	/**
	 * 添加菜单
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void add(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String menuName = request.getParameter("menuName");
		String menuUrl = request.getParameter("menuUrl");
		String target = request.getParameter("target");
		String status = request.getParameter("status");
		Menu menu = new Menu();
		menu.setParentId(0);
		menu.setMenuName(menuName);
		menu.setMenuUrl(menuUrl);
		menu.setTarget(target);
		menu.setStatus(status);
		try {
			menuService.addMenu(menu);
			staticMenu(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("menuManager");
	}
	/**
	 * 修改菜单
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void edit(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Integer menuId = Integer.valueOf(request.getParameter("menuId"));
		String menuName = request.getParameter("menuName");
		String menuUrl = request.getParameter("menuUrl");
		String target = request.getParameter("target");
		String status = request.getParameter("status");
		Menu menu = new Menu();
		menu.setMenuId(menuId);
		menu.setParentId(0);
		menu.setMenuName(menuName);
		menu.setMenuUrl(menuUrl);
		menu.setTarget(target);
		menu.setStatus(status);
		try {
			menuService.modifyMenu(menu);
			staticMenu(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("menuManager");
	}
	/**
	 * 删除菜单
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		Integer menuId = Integer.valueOf(request.getParameter("menuId"));
		Menu menu = new Menu();
		menu.setMenuId(menuId);
		try {
			menuService.deleteMenu(menu);
			out.print(1);
			staticMenu(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print(0);
		}
		out.close();
	}
	/**
	 * 批量删除菜单
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void deletes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		String ids = request.getParameter("ids");
		//System.out.println(ids);
		String[] array = ids.split(",");
		Menu menu = new Menu();
		for (int i = 0; i < array.length; i++) {
			Integer menuId = Integer.valueOf(array[i]);
			menu.setMenuId(menuId);
			try {
				menuService.deleteMenu(menu);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print(0);
			}
		}
		out.print(1);
		staticMenu(request,response);
		out.close();
	}
	/**
	 * 功能：静态化导航栏菜单,减轻数据库的访问（/js/menu.json）
	 */
	public void staticMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			List<Menu> list = menuService.findByStatus("可用");
			JSONArray json = new JSONArray();
			json.add(list);
			String menujson = json.toJSONString();
			System.out.println(menujson);
			//存放路径
			String filename = request.getSession().getServletContext().getRealPath("/")+"js\\menu.json";
			FileOutputStream fos = new FileOutputStream(filename);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			PrintWriter o = new PrintWriter(osw);
			o.println(menujson);
			o.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
