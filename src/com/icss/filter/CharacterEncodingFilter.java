package com.icss.filter;

import java.io.IOException;

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

/**
 * 功能：字符编码过滤器
 * 
 * @author 林玉生
 *
 */
@WebFilter(urlPatterns="*",initParams={@WebInitParam(name="encoding",value="UTF-8")})
public class CharacterEncodingFilter implements Filter{

	private String encoding = "";
	
	public void init(FilterConfig fc) throws ServletException {
		encoding = fc.getInitParameter("encoding");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		httpRequest.setCharacterEncoding(encoding);
		httpServletResponse.setCharacterEncoding(encoding);
		httpServletResponse.setContentType("text/html");
		chain.doFilter(request, response);
	}

	public void destroy() {
		
	}

}
