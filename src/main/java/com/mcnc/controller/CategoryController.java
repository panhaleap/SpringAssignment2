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
	
	private static final String CATEGORY = "Category";
	private static final String CATEGORYLIST = "ListCategories";
	private static final String CATEGORY_FOULDER = "category/";
	
	@RequestMapping("/listOfCategories")
	public String showListOfCategories(Model model){
		List<Category> categories = categoryMapper.getAllCategories();
		model.addAttribute("categoryList", categories);
		for(Category category : categories) {
			System.out.println(category.toString());
		}
		return CATEGORY_FOULDER + CATEGORYLIST;
	}
	
	@RequestMapping("/showFormForAddCategory")
	public String addCategory(Model model){
		model.addAttribute("category", new Category());
		return CATEGORY_FOULDER +"add"+ CATEGORY;
	}
	
	@RequestMapping("/saveProcess")
	public String saveCategory(@ModelAttribute("category") Category category){
		System.out.println("Saved category");
		categoryMapper.saveCategory(category);
		return "redirect:/category/listOfCategories";
	}
//	
//	@RequestMapping("/displayUpdateForm")
//	public String showUpdateForm(@RequestParam("employeeId") int employeeId, Model model){
//		model.addAttribute("employee", employeeMapper.findById(employeeId));
//		return EMPLOYEE;
//	}
//	
//	@RequestMapping("/displayDeleteForm")
//	public String deleteEmployee(@RequestParam("employeeId") int employeeId){
//		employeeMapper.deleteEmployee(employeeId);
//		return "redirect:/employee/listOfEmployee";
//	}
}
