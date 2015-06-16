package com.icss.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.icss.dao.BrandDAO;
import com.icss.dao.RoseDAO;
import com.icss.dao.UserDAO;
import com.icss.po.Rose;
import com.icss.po.User;

/**
 * 
 * @author lys
 * 
 */
public class DataCollection {
	/**
	 * 获取网页源码
	 * 
	 * @param url
	 *            网页地址
	 * @param encoding
	 *            网页编码
	 * @return String 字符串
	 */
	public static String getResourceByURL(String url, String encoding) {
		StringBuffer buffer = new StringBuffer();
		URL urlPage = null;
		URLConnection con = null;
		InputStreamReader in = null;
		BufferedReader reader = null;
		try {
			// 建立网络连接
			urlPage = new URL(url);
			// 打开网络连接
			con = urlPage.openConnection();
			// 建立写入流，流的转化
			in = new InputStreamReader(con.getInputStream(), encoding);
			// 缓冲写入文件的流
			reader = new BufferedReader(in);
			// 将数据一行一行的写入buffer
			String line = null;
			while ((line = reader.readLine()) != null) {
				buffer.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return buffer.toString();
	}

	/**
	 * 根据图片的外网地址下载图片到本地的filePath
	 * 
	 * @param filePath
	 *            存放地址
	 * @param imgUrl
	 *            图片的外网地址
	 */
	public static void downImages(String filePath, String imgUrl) {
		String fileName = imgUrl.substring(imgUrl.lastIndexOf("/"));
		try {
			// 创建文件目录
			File files = new File(filePath);
			if (!files.exists()) {
				files.mkdirs();
			}
			// 获取下载地址
			URL url = new URL(imgUrl);
			// 链接网络地址
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			// 获取链接的输出流
			InputStream is = connection.getInputStream();
			// 创建文件
			File file = new File(filePath + fileName);
			// 根据输入流写入文件
			FileOutputStream out = new FileOutputStream(file);
			int i = 0;
			while ((i = is.read()) != -1) {
				out.write(i);
			}
			out.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据源码生成html文件
	 * 
	 * @param html
	 * @param filename
	 */
	public static void generateHtmlFile(String html, String filename) {
		// 在项目根目录下生成html文件
		try {
			FileWriter file = new FileWriter("./WebRoot/img/" + filename + ".html");
			BufferedWriter bw = new BufferedWriter(file);
			PrintWriter out = new PrintWriter(bw);
			out.println(html);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 爬取玫瑰信息
	 */
	public static void getRoseInfo() throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		map.put("金牛座", "http://www.roseonly.com.cn/tag/75.html");
		map.put("玫瑰礼盒", "http://www.roseonly.com.cn/lihemeigui.html");
		map.put("玫瑰珠宝", "http://www.roseonly.com.cn/zhubaomeigui.html");
		map.put("鲜花玫瑰", "http://www.roseonly.com.cn/xianhua.html");
		map.put("永生玫瑰", "http://www.roseonly.com.cn/yongsheng.html");
		map.put("玫瑰礼品", "http://www.roseonly.com.cn/rosemmlp.html");
		map.put("婚礼戒指", "http://www.roseonly.com.cn/hunlijiezhi.html");
		BrandDAO brandDAO = new BrandDAO();
		RoseDAO roseDAO = new RoseDAO();
		int i=0;
		// 遍历map
		for (String key : map.keySet()) {
			System.out.println(key);
			String url = map.get(key);
			String html = getResourceByURL(url, "UTF-8");
			Document doc = Jsoup.parse(html);
			//第一步：爬取名称，图片
//			Elements elements = doc.select(".layer a:eq(0) img");
//			for (Element element : elements) {
//				i++;
//				String title = element.attr("title");
//				String src = element.attr("src");
//				Rose rose = new Rose();
//				rose.setBrandId(brandDAO.findByBrandName(key).getBrandId());
//				rose.setRoseName(title);
//				rose.setPicture("/img/"+key+src.substring(src.lastIndexOf("/")));
//				rose.setDiscount(0.9f);
//				rose.setRoseNum(100);
//				rose.setCreateTime(Tool.getCurrentTime());
//				rose.setStatus(true);
//				roseDAO.add(rose);
//				System.out.println("brandId:"+rose.getBrandId());
//				System.out.println("roseName:"+rose.getRoseName());
//				System.out.println("rosePicture:"+rose.getPicture());
//				System.out.println("dicount:"+rose.getDiscount());
//				System.out.println("roseNum:"+rose.getRoseNum());
//				System.out.println("createTime:"+rose.getCreateTime());
//				System.out.println("status:"+rose.getStatus());
//			}
			//第二步：爬取价格
//			Elements elements = doc.select(".block .block_pay");
//			for (Element element : elements) {
//				i++;
//				Rose rose = new Rose();
//				rose.setRoseId(i);
//				rose = roseDAO.findById(rose);
//				String price = element.text();
//				price = price.replace("￥", "");
//				Float p = Float.valueOf(price);
//				rose.setRosePrice(p);
//				roseDAO.modify(rose);
//				System.out.println("price:"+p);
//			}
			//第三步：爬取玫瑰描述信息 
//			Elements elements = doc.select(".layer a:eq(0)");
//			for (Element element : elements) {
//				i++;
//				Rose rose = new Rose();
//				rose.setRoseId(i);
//				rose = roseDAO.findById(rose);
//				//获得玫瑰详细页的地址
//				String href = element.attr("href");
//				System.out.println("href:"+href);
//				String detailpage = getResourceByURL(href, "UTF-8");
//				Document d = Jsoup.parse(detailpage);
//				Elements div = d.select(".zs_xq_name");
//				rose.setRoseInfo(div.html());
//				roseDAO.modify(rose);
//				System.out.println("详细信息："+div.html());
//				
//			}
			//第四步：爬取玫瑰物语信息 
//			Elements elements = doc.select(".layer a:eq(0)");
//			for (Element element : elements) {
//				i++;
//				Rose rose = new Rose();
//				rose.setRoseId(i);
//				rose = roseDAO.findById(rose);
//				//获得玫瑰详细页的地址
//				String href = element.attr("href");
//				System.out.println("玫瑰详细页面:"+href);
//				String detailpage = getResourceByURL(href, "UTF-8");
//				Document d = Jsoup.parse(detailpage);
//				Elements table = d.select(".zs_xq_table");
//				String detail = table.toString();
//				detail = detail.replace("www.roseonly.com.cn/upload/products", "localhost/roseonly/img/details");
//				System.out.println(detail);
//				rose.setDetails(detail);
//				roseDAO.modify(rose);
//				//下载物语图片
//				Elements imgs = div.select("img");
//				for (Element element2 : imgs) {
//					String src = element2.attr("src");
//					downImages("./WebRoot/img/details", src);
//					System.out.println(element2);
//				}
//			}
		}
		System.out.println("一共插入："+i+"数据");
	}
	/**
	 * 插入用户测试数据
	 * @throws Exception
	 */
	public static void insertUserInfo() throws Exception{
		UserDAO userDAO = new UserDAO();
		for (int i = 1; i <= 50; i++) {
			User user = new User();
			Random random = new Random();
			int typeId = random.nextInt(3)+1;
			user.setTypeId(typeId);
			user.setAccount("user"+i);
			user.setPassword("user"+i);
			user.setMobile("18316022547");
			user.setEmail("2275755329@qq.com");
			user.setCreateTime(Tool.getCurrentTime());
			userDAO.add(user);
			System.out.println(typeId);
		}
	}
	/**
	 * 修改玫瑰图片地址
	 */
	public static void modifyRose() throws Exception{
		RoseDAO roseDAO = new RoseDAO();
		for (int i = 1; i < 291; i++) {
			Rose rose = new Rose();
			rose.setRoseId(i);
			rose = roseDAO.findById(rose);
			String p = rose.getRoseName();
			p = p.replace("roseonly-", "");
			rose.setRoseName(p);
			System.out.println(p);
			roseDAO.modify(rose);
			
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		//getRoseInfo();
		
		//insertUserInfo();
		
		modifyRose();
		
	}
}
