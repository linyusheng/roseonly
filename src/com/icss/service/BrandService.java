package com.icss.service;

import java.util.List;

import com.icss.dao.BrandDAO;
import com.icss.po.Brand;

public class BrandService {
	
	private BrandDAO brandDAO = new BrandDAO();
	
	/**
	 * 功能：添加品牌信息
	 * @param brand
	 * @throws Exception
	 */
	public void addBrand(Brand brand) throws Exception{
		brandDAO.add(brand);
	}
	
	/**
	 * 功能：修改品牌信息
	 * @param brand
	 * @throws Exception
	 */
	public void modifyBrand(Brand brand) throws Exception{
		brandDAO.modify(brand);
	}
	
	/**
	 * 功能：删除品牌信息
	 * @param brand
	 * @throws Exception
	 */
	
	public void deleteBrand(Brand brand) throws Exception{
		brandDAO.delete(brand);
	}
	
	/**
	 * 功能：获取所有品牌信息
	 * @param brand
	 * @return
	 * @throws Exception
	 */
	public List<Brand> findAllBrand(Brand brand) throws Exception{
		return brandDAO.findAll();
	}
	
	/**
	 * 功能：通过品牌ID获取品牌信息
	 * @param brand
	 * @return
	 * @throws Exception
	 */
	public Brand findByBrandId(Brand brand) throws Exception {
		return brandDAO.findById(brand);
	}

}
