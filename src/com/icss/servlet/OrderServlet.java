package com.icss.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Address;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.po.Order;
import com.icss.po.Recinfo;
import com.icss.po.Shopping;
import com.icss.po.User;
import com.icss.service.OrderService;
import com.icss.service.RecinfoService;
import com.icss.service.ShoppingService;
import com.icss.util.FileEveryDaySerialNumber;
import com.icss.util.SerialNumber;
import com.icss.util.Tool;
import com.icss.vo.OrderVO;
import com.icss.vo.ShoppingVO;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	
	OrderService orderService = new OrderService();
	ShoppingService shoppingService = new ShoppingService();
	RecinfoService recinfoService = new RecinfoService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getQueryString() == null) {
			request.getRequestDispatcher("order.jsp").forward(request, response);
		}else {
			String method = request.getParameter("method");
			if(method.equals("getOrders")){
				getOrders(request,response);
				return;
			}
			if (method.equals("add")) {
				add(request, response);
				return;
			}
			if(method.equals("addAddress")){
				addAddress(request,response);
				return;
			}
			if(method.equals("deleteAddress")){
				deleteAddress(request,response);
				return;
			}
		}
	}
	/**
	 * 功能：查看该用户的所有订单
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Integer userId = user.getUserId();
		List<OrderVO> orderList = null;
		try {
			orderList = orderService.findByUserId(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("orderList", orderList);
		request.getRequestDispatcher("user_order.jsp").forward(request, response);
	}
	/**
	 * 提交订单
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer recInfoId = Integer.valueOf(request.getParameter("recInfoId"));
		String[] signs = request.getParameterValues("signs");
		String[] bless = request.getParameterValues("bless");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Integer userId = user.getUserId();
		List<Order> oList = new ArrayList<Order>();
		List<ShoppingVO> sList = null;
		try {
			sList = shoppingService.findByUserId(userId);
			int i=0;
			for (ShoppingVO vo : sList) {
				Order order = new Order();
				order.setUserId(userId);
				order.setRoseId(vo.getRoseId());
				order.setRecInfoId(recInfoId);
				//生成订单号
				SerialNumber serialNumber = new FileEveryDaySerialNumber(6,"orderNo.txt");
				String orderNo = serialNumber.getSerialNumber();
				order.setOrderNo(orderNo);
				Float money = vo.getRosePrice() * vo.getNum();
				order.setMoney(money);
				order.setNum(vo.getNum());
				order.setStatus("已支付");
				order.setSigns(signs[i]);
				order.setBless(bless[i]);
				order.setStartTime(Tool.getCurrentTime());
				oList.add(order);
				i++;
			}
			orderService.submitOrder(oList, userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("order?method=getOrders");
	}
	/**
	 * 功能：添加收货信息
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void addAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String consignee = request.getParameter("consignee");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String postcode = request.getParameter("postcode");
		String privince = request.getParameter("cho_Province");
		String city = request.getParameter("cho_City");
		String area = request.getParameter("cho_Area");
		Recinfo recinfo = new Recinfo();
		recinfo.setUserId(user.getUserId());
		recinfo.setPrivince(privince);
		recinfo.setAddress(address);
		recinfo.setArea(area);
		recinfo.setCity(city);
		recinfo.setConsignee(consignee);
		recinfo.setMobile(mobile);
		recinfo.setPostcode(postcode);
		try {
			recinfoService.addRecinfo(recinfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("shopping?method=cartPay");
	}
	/**
	 * 功能：删除收货信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer recinfoId = Integer.valueOf(request.getParameter("recinfoId"));
		Recinfo recinfo = new Recinfo();
		recinfo.setRecInfoId(recinfoId);
		try {
			recinfoService.deleteRecinfo(recinfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("shopping?method=cartPay");
	}

}
