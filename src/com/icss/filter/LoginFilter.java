package com.icss.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 功能：登录过滤器
 * 参数：	
 * 		sessionKey	需要检查的session中键名
 * 		redirectURL 如果用户未登录，则重定向到指定的页面
 * 		notCheckURL 不做检查的URL列表，以逗号分隔
 * @author 林玉生
 *
 */
//@WebFilter(urlPatterns={"/*"},initParams={
//		@WebInitParam(name="sessionKey",value="user"),
//		@WebInitParam(name="redirectURL",value="/index.jsp"),
//		@WebInitParam(name="notCheckURL",value="/index.jsp")
//})
public class LoginFilter implements Filter{
	
	private String sessionKey = null;
	private String redirectURL = null;
	private List<String> notCheckURL = new ArrayList<String>();
	
	/**
	 * 初始化信息,获取init参数
	 */
	public void init(FilterConfig fc) throws ServletException {
		
		sessionKey = fc.getInitParameter("sessionKey");
		redirectURL = fc.getInitParameter("redirectURL");
		String url = fc.getInitParameter("notCheckURL");
		if (url != null && url != "") {
			StringTokenizer st = new StringTokenizer(url, ",");
			while (st.hasMoreTokens()) {
				notCheckURL.add(st.nextToken());
			}
		}
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		HttpSession session = request.getSession();
		
		//如果未设置参数sessionKey，则直接放行
		if (sessionKey == null) {
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		//如果是不做检查的路径，则放行
		String url = request.getServletPath();
		System.out.println(notCheckURL.contains(url));
		if (notCheckURL.contains(url)) {
			chain.doFilter(servletRequest, servletResponse);
			return;
		} 
		//如果Session为空，则跳转到指定页面
		if (session.getAttribute(sessionKey) == null) {
			response.sendRedirect(redirectURL);
			return;
		}
		chain.doFilter(servletRequest, servletResponse);
		
	}

	public void destroy() {
	}
	
}
