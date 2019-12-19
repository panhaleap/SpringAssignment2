package com.mcnc.entity;

import org.springframework.beans.factory.annotation.Autowired;

import com.mcnc.dao.CategoryMapper;

public class Type {
	private String code;
	private String name;
	private String desc;
	private String categoryCode;
	private Category category;
	@Autowired
	CategoryMapper categoryMapper;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public void setCategory() {
		this.category = categoryMapper.findByCode(categoryCode);
	}

}
