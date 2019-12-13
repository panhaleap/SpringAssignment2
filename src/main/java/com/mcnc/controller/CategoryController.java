package com.mcnc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcnc.dao.CategoryMapper;
import com.mcnc.entity.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller @RequestMapping("/category")
public class CategoryController {
	@Autowired
	CategoryMapper categoryMapper;
	
	private static final String CATEGORY_FOULDER = "category/";
	private static final String CATEGORY = CATEGORY_FOULDER + "Category";
	private static final String CATEGORYLIST = CATEGORY_FOULDER + "ListCategories";
	
	@RequestMapping("/listOfCategories")
	public String showListOfCategories(Model model){
		List<Category> categories = categoryMapper.getAllCategories();
		model.addAttribute("categoryList", categories);
		for(Category category : categories) {
			System.out.println(category.toString());
		}
		return CATEGORYLIST;
	}
	
	@RequestMapping("/showFormForAddCategory")
	public String addCategory(Model model){
		model.addAttribute("category", new Category());
		return CATEGORY;
	}
	
	@RequestMapping("/saveProcess")
	public String saveCategory(@ModelAttribute("category") Category category){
		System.out.println("Saved category");
		categoryMapper.saveCategory(category);
		return "redirect:/category/listOfCategories";
	}
	
//	@RequestMapping("/displayUpdateForm")
//	public String showUpdateForm(@RequestParam("categoryCode") String categoryCode, Model model){
//		System.out.println(categoryMapper.findByCode(categoryCode).getCode());
//		//model.addAttribute("category", categoryMapper.findByCode(categoryCode));
//		return CATEGORY;
//	}
//	
//	@RequestMapping("/displayDeleteForm")
//	public String deleteEmployee(@RequestParam("employeeId") int employeeId){
//		employeeMapper.deleteEmployee(employeeId);
//		return "redirect:/employee/listOfEmployee";
//	}
}
