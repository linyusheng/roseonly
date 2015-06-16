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
import javax.ws.rs.DELETE;

import com.icss.po.Collect;
import com.icss.po.User;
import com.icss.service.CollectService;
import com.icss.vo.CollectVO;

@WebServlet("/collect")
public class CollectServlet extends HttpServlet {
	
	private CollectService collectService = new CollectService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getQueryString() == null) {
			
		}else {
			String method = request.getParameter("method");
			if (method.equals("add")) {
				add(request, response);
				return;
			}
			if (method.equals("myCollect")) {
				myCollect(request,response);
				return;
			}
			if (method.equals("delete")) {
				delete(request,response);
				return;
			}
		}
		
	}
	
	/**
	 * 添加收藏
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if (user == null) {
			out.print(-1);
			return;
		}
		Integer roseId = Integer.valueOf(request.getParameter("roseId"));
		
		Collect collect = new Collect();
		collect.setRoseId(roseId);
		collect.setUserId(user.getUserId());
		try {
			Collect c = collectService.findByUserIdAndRoseId(collect);
			if (c == null) {
				collectService.addCollect(collect);
				out.print(1);
			}else {
				out.print(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
	}
	/**
	 * 我的收藏
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void myCollect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		List<CollectVO> collectList = null;
		try {
			collectList = collectService.findByUserId(user.getUserId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("collectList", collectList);
		request.getRequestDispatcher("user_collect.jsp").forward(request, response);
	}
	/**
	 * 删除用户收藏
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer collectId = Integer.valueOf(request.getParameter("collectId"));
		Collect collect = new Collect();
		collect.setCollectId(collectId);
		try {
			collectService.deleteCollect(collect);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("collect?method=myCollect");
	}

}
