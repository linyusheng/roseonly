package com.icss.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.po.User;
import com.icss.service.UserService;
import com.icss.util.Tool;

/**
 * 功能：实现用户注册
 * 
 * @author 林玉生
 *
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	
	private UserService userService = new UserService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//不带参数,转向到注册页面
		if (request.getQueryString() == null) {
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}else {
			String method = request.getParameter("method");
			if (method.equals("getCheckCode")) {
				getCheckCode(request,response);
				return;
			}
			if (method.equals("checkUser")) {
		    	checkUser(request,response);
		    	return;
		    }
			if (method.equals("checkCode")) {
				checkCode(request,response);
				return;
			}
			if (method.equals("add")) {
				add(request,response);
				return;
			}
		}
	}

	/**
	 * 注册用户信息
	 * @param request
	 * @param response
	 */
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String account = request.getParameter("account");
		String password = request.getParameter("pwd");
		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		user.setTypeId(1);
		user.setCreateTime(Tool.getCurrentTime());
		try {
			userService.addUser(user);
			user = userService.findByAccoutPassword(account, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().setAttribute("user", user);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		return;
	}
	
	/**
	 * 检查验证码
	 */
	public void	checkCode(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		String code = request.getParameter("checkcode").toLowerCase();
		System.out.println("输入："+code);
		String checkcode = (String)request.getSession().getAttribute("checkcode");
		checkcode = checkcode.toLowerCase();
		System.out.println("生成："+checkcode);
		if (code.equals(checkcode)) {
			out.print(1);
		}
		else {
			out.print(0);
		}
		out.close();
	}
	
	/**
	 * 检查账号
	 * @throws Exception 
	 */
	public void checkUser(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		String account = (String)request.getParameter("account");
	    try {
			User user = userService.findByAccount(account);
			if(user == null){
				out.print(1);
			}else{
				out.print(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
	}
	/**
	 * 生成验证码
	 * @param request
	 * @param response
	 */
	public void getCheckCode(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("image/JPEG");  
        OutputStream out = response.getOutputStream();  
        // 定义图片的高度和宽度  
        int width = 85;  
        int height = 27;  
        // 定义随机数对象  
        Random ran = new Random();  
        // 定义图片缓冲区，使用RGB模式输出图片  
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
        // 定义画笔工具对象  
        Graphics graphics = image.getGraphics();  
        // 设置验证码框的背景颜色  
        graphics.setColor(new Color(200, 200, 200));  
        // 填充整个矩形  
        graphics.fillRect(0, 0, width, height);  
        // 定义要显示的验证码  
        StringBuffer sb = new StringBuffer("");  
        // 定义验证码数组  
        String[] code = { "A", "a", "B", "b", "C", "c", "D", "d", "E", "e",  
                "F", "f", "G", "g", "H", "h", "I", "i", "J", "j", "K", "k",  
                "L", "l", "M", "m", "N", "n", "O", "o", "P", "p", "Q", "q",  
                "R", "r", "S", "s", "T", "t", "U", "u", "V", "v", "W", "w",  
                "X", "x", "Y", "y", "Z", "z", "0", "1", "2", "3", "4", "5",  
                "6", "7", "8", "9", "0", "1", "2", "3", "4", "5", "6", "7",  
                "8", "9", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",  
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "1",  
                "2", "3", "4", "5", "6", "7", "8", "9", "0", "1" };  
        for (int i = 0; i < 4; i++) {  
            String str = code[ran.nextInt(code.length)];  
            // 设置颜色  
            graphics.setColor(new Color(ran.nextInt(150), ran.nextInt(150), ran.nextInt(150)));  
            // 设置字体  
            graphics.setFont(new Font("宋体", Font.BOLD, 24));  
            // 绘制验证码  
            graphics.drawString(str, 20 * i+4, 25 - ran.nextInt(5));  
            sb.append(str);  
        }  
        // 随机产生100个干扰点  
        for (int i = 0; i < 100; i++) {  
            // 随机生成干扰点的坐标  
            int x = ran.nextInt(width);  
            int y = ran.nextInt(height);  
            // 随机生成干扰点的颜色  
            graphics.setColor(new Color(ran.nextInt(185) + 40,ran.nextInt(185) + 40, ran.nextInt(185) + 40));  
            // 设置干扰点的位置长宽  
            graphics.drawOval(x, y, 1, 1);  
        }  
        String codeInfo = sb.toString();  
        // 将验证码的值放到session中，以供前台进行验证 
        request.getSession().setAttribute("checkcode", codeInfo);
        // 将Image通过out输出为jpeg格式的图片  
        ImageIO.write(image, "JPEG", out);  
        out.flush();
        out.close();
	}


}
