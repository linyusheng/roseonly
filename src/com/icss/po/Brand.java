package com.icss.po;

import java.sql.ResultSet;

import com.icss.util.RowMapper;

/**
 * TBrand entity. @author MyEclipse Persistence Tools
 */

public class Brand implements RowMapper<Brand> {

	// Fields

	private Integer brandId;
	private Integer parentId;
	private String brandName;

	@Override
	public Brand mapRow(ResultSet rs, int index) throws Exception {
		Brand brand = new Brand();
		brand.setBrandId(rs.getInt("brandId"));
		brand.setParentId(rs.getInt("parentId"));
		brand.setBrandName(rs.getString("brandName"));
		return brand;
	}
	
	// Property accessors

	public Integer getBrandId() {
		return this.brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

}