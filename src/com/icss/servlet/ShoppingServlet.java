package com.icss.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.icss.po.Recinfo;
import com.icss.po.Shopping;
import com.icss.po.User;
import com.icss.service.RecinfoService;
import com.icss.service.ShoppingService;
import com.icss.vo.ShoppingVO;

/**
 * 购物车处理类
 * 
 * @author 余卓璇
 *
 */
@WebServlet("/shopping")
public class ShoppingServlet extends HttpServlet {

	private ShoppingService shoppingService = new ShoppingService();
	private RecinfoService recinfoService = new RecinfoService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getQueryString() == null) {
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			//判断用户是否登录
			if(user!=null){
				out.print(1);
			}else{
				out.print(0);
			}
			out.close();
		}else{
			String method = request.getParameter("method");
			if(method.equals("getList")){
				getList(request,response);
				return;
			}
			if(method.equals("delete")){
				delete(request,response);
				return;
			}
			if(method.equals("deleteAll")){
				deleteAll(request,response);
				return;
			}
			if (method.equals("changeNum")) {
				changeNum(request,response);
				return;
			}
			if (method.equals("seeMyCart")) {
				seeMyCart(request,response);
				return;
			}
			if (method.equals("cartPay")) {
				cartPay(request,response);
				return;
			}
		}
	}
	
	/**
	 * 功能：查看同一用户购物车所有信息
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Integer roseId = Integer.valueOf(request.getParameter("roseId"));
		Integer brandId = Integer.valueOf(request.getParameter("brandId"));
		Integer num = Integer.valueOf(request.getParameter("num"));
		Shopping shopping = new Shopping();
		shopping.setUserId(user.getUserId());
		shopping.setRoseId(roseId);
		shopping.setNum(num);
		List<ShoppingVO> shoppingList = null;
		try {
			//查询数据库中是否存在同一个rose
			Shopping s = shoppingService.findByUserIdandRoseId(user.getUserId(), roseId);
			if(s==null){
				shoppingService.addShopping(shopping);
			}
			//判断是否为立即购买
			String nowBuy = request.getParameter("nowBuy");
			if (nowBuy != null) {
				response.sendRedirect("shopping?method=cartPay");
				return;
			}
			//查询出该用户的购物车列表
			shoppingList = shoppingService.findByUserId(user.getUserId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("brandId", brandId);
		request.setAttribute("shoppingList", shoppingList);
		request.getRequestDispatcher("shopping.jsp").forward(request, response);
	}
	
	/**
	 * 功能：删除购物车某条购物信息
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Integer shoppingId = Integer.valueOf(request.getParameter("shoppingId"));
		Integer brandId = Integer.valueOf(request.getParameter("brandId"));
		Shopping shopping = new Shopping();
		shopping.setShoppingId(shoppingId);
		List<ShoppingVO> shoppingList = null;
		try {
			shoppingService.deleteShopping(shopping);
			//重新查询出该用户的购物车列表
			shoppingList = shoppingService.findByUserId(user.getUserId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("brandId", brandId);
		request.setAttribute("shoppingList", shoppingList);
		request.getRequestDispatcher("shopping.jsp").forward(request, response);
	}
	/**
	 * 功能：清除某用户的购物车
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public void deleteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer brandId = Integer.valueOf(request.getParameter("brandId"));
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		try {
			shoppingService.deleteAll(user.getUserId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("brandId", brandId);
		request.getRequestDispatcher("shopping.jsp").forward(request, response);
	}
	/**
	 * 功能：改变购物车的数量
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public void changeNum(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		Integer shoppingId = Integer.valueOf(request.getParameter("shoppingId"));
		Integer num = Integer.valueOf(request.getParameter("num"));
		try {
			Shopping shopping = new Shopping();
			shopping.setShoppingId(shoppingId);
			shopping = shoppingService.findByShoppingId(shopping);
			shopping.setNum(num);
			shoppingService.modify(shopping);
			out.print(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print(0);
		}
		out.close();
	}
	/**
	 * 查看我的购物车
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void seeMyCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Integer userId = user.getUserId();
		List<ShoppingVO> shoppingList = null;
		try {
			shoppingList = shoppingService.findByUserId(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("brandId", 0);
		request.setAttribute("shoppingList", shoppingList);
		request.getRequestDispatcher("shopping.jsp").forward(request, response);
	}
	/**
	 * 结算购物车
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void cartPay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Integer userId = user.getUserId();
		List<ShoppingVO> shoppingList = null;
		List<Recinfo> addressList = null;
		try {
			shoppingList = shoppingService.findByUserId(userId);
			addressList = recinfoService.findByUserId(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("addressList", addressList);
		request.setAttribute("shoppingList", shoppingList);
		request.getRequestDispatcher("order.jsp").forward(request, response);
	}
}
