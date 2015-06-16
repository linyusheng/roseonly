package com.icss.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.po.Brand;
import com.icss.po.Rose;
import com.icss.service.BrandService;
import com.icss.service.RoseService;

@WebServlet("/roseinfo")
public class RoseInfo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer roseId = Integer.valueOf(request.getParameter("roseId"));
		RoseService roseService = new RoseService();
		BrandService brandService = new BrandService();
		Brand brand = new Brand();
		Rose rose = new Rose();
		rose.setRoseId(roseId);
		try {
			rose = roseService.findByRoseId(rose);
			brand.setBrandId(rose.getBrandId());
			brand = brandService.findByBrandId(brand);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(brand.getBrandName());
		request.setAttribute("rose", rose);
		request.setAttribute("brand", brand);
		request.getRequestDispatcher("rose_info.jsp").forward(request, response);
	}
}
