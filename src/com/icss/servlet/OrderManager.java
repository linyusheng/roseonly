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
import com.icss.po.User;
import com.icss.service.OrderService;
import com.icss.vo.OrderVO;
import com.icss.vo.PageVO;
import com.icss.vo.UserVO;

@WebServlet("/orderManager")
public class OrderManager extends HttpServlet {
	
	private OrderService orderService = new OrderService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getQueryString() == null) {
			try {
				PageVO<OrderVO> pageVO = orderService.getAllOrder(new PageVO<OrderVO>());
				request.setAttribute("pageVO", pageVO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("admin/order-manager.jsp").forward(request, response);
		}else {
			String method = request.getParameter("method");
			if (method.equals("pageFindOrder")) {
				pageFindOrder(request,response);
				return;
			}
			if (method.equals("add")) {
				add(request, response);
				return;
			}
			if (method.equals("edit")) {
				edit(request,response);
				return;
			}
			if (method.equals("delete")) {
				delete(request,response);
				return;
			}
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
	public void pageFindOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int page = Integer.valueOf(request.getParameter("page"));
		PageVO<OrderVO> param = new PageVO<OrderVO>();
		param.setPage(page);
		try {
			PageVO<OrderVO> pageVO = orderService.getAllOrder(param);
			request.setAttribute("pageVO", pageVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("admin/order-manager.jsp").forward(request, response);
	}
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void add(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
	}
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void edit(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
	}
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Integer orderId = Integer.valueOf(request.getParameter("orderId"));
		Order order = new Order();
		order.setOrderId(orderId);
		try {
			orderService.deleteOrder(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("orderManager");
	}
	/**
	 * 批量删除
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void deletes(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
	}

}
