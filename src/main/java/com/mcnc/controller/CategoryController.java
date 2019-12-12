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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller @RequestMapping("/category")
public class CategoryController {
	@Autowired
	CategoryMapper categoryMapper;
	
	private static final String CATEGORY = "Category";
	private static final String CATEGORYLIST = "ListCategories";
	
	@RequestMapping("/listOfCategories")
	public String showListOfCategories(Model model){
		List<Category> categories = categoryMapper.getAllCategories();
		model.addAttribute("categoryList", categories);
		for(Category category : categories) {
			System.out.println(category.toString());
		}
		return CATEGORYLIST;
	}
	
//	@RequestMapping("/showFormForAdd")
//	public String addEmployee(Model model){
//		model.addAttribute("employee", new Employee());
//		return EMPLOYEE;
//	}
//	
//	@RequestMapping("/saveProcess")
//	public String saveEmployee(@ModelAttribute("employee") Employee employee){
//		if(employee.getId() == null){
//			employeeMapper.saveEmployee(employee);
//		}else{
//			employeeMapper.updateEmployee(employee);
//		}
//		
//		return "redirect:/employee/listOfEmployee";
//	}
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
