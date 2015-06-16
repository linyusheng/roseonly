package com.icss.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.po.Brand;
import com.icss.po.Rose;
import com.icss.service.BrandService;
import com.icss.service.RoseService;

@WebServlet("/roselist")
public class RoseList extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer brandId = Integer.valueOf(request.getParameter("brandId"));
		if (brandId == 0) {
			response.sendRedirect("");
			return;
		}
		RoseService roseService = new RoseService();
		BrandService brandService = new BrandService();
		Brand brand = new Brand();
		List<Rose> list = null;
		try {
			list = roseService.roseList(brandId);
			brand.setBrandId(brandId);
			brand = brandService.findByBrandId(brand);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.setAttribute("brand", brand);
		request.getRequestDispatcher("rose_list.jsp").forward(request, response);
	}

}
