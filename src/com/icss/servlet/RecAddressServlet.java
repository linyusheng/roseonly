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
import com.icss.po.User;
import com.icss.service.RecinfoService;

@WebServlet("/recaddress")
public class RecAddressServlet extends HttpServlet {

	RecinfoService recinfoService = new RecinfoService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("method");
		if(method.equals("add")){
			add(request,response);
			return;
		}
		if(method.equals("getAddress")){
			getAddress(request,response);
			return;
		}
		if(method.equals("delete")){
			delete(request,response);
			return;
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
 
	/**
	 * 功能：添加收货信息
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer recinfoId = Integer.valueOf(request.getParameter("recinfoId"));
		PrintWriter out = response.getWriter();
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
		recinfo.setRecInfoId(recinfoId);
		recinfo.setUserId(user.getUserId());
		recinfo.setPrivince(privince);
		recinfo.setAddress(address);
		recinfo.setArea(area);
		recinfo.setCity(city);
		recinfo.setConsignee(consignee);
		recinfo.setMobile(mobile);
		recinfo.setPostcode(postcode);
		if(recinfoId==0){
			try {
				recinfoService.addRecinfo(recinfo);
				out.print(1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print(0);
			}
			out.close();
		}else{
			try {
				recinfoService.modifyRecinfo(recinfo);
				out.print(1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print(0);
			}
		}
	}
	
	/**
	 * 功能：获取收货信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		List<Recinfo> recList = null;
		try {
			recList = recinfoService.findByUserId(user.getUserId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("recList", recList);
		request.getRequestDispatcher("address.jsp").forward(request, response);
	}

	/**
	 * 功能：删除收货信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer recinfoId = Integer.valueOf(request.getParameter("recinfoId"));
		Recinfo recinfo = new Recinfo();
		recinfo.setRecInfoId(recinfoId);
		try {
			recinfoService.deleteRecinfo(recinfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("recaddress?method=getAddress");
	}
}
