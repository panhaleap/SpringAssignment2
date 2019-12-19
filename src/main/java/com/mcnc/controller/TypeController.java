package com.mcnc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mcnc.dao.TypeMapper;
import com.mcnc.entity.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller @RequestMapping("/type")
public class TypeController {
	@Autowired
	TypeMapper typeMapper;
	
	private static final String TYPE_FOULDER = "type/";
	private static final String TYPELIST = TYPE_FOULDER + "ListTypes";
	private static final String ADD = TYPE_FOULDER + "Add";
	private static final String UPDATE = TYPE_FOULDER + "Update";
	
	@RequestMapping("/listOfTypes")
	public String showListOfTypes(Model model){
		List<Type> types = typeMapper.getAllTypes();
		for(Type type: types) {
			System.out.println(type.getCategory().getName());
		}
		model.addAttribute("typeList", types);
		return TYPELIST;
	}
	
//	@RequestMapping("/showFormForAddCategory")
//	public String addCategory(Model model){
//		model.addAttribute("category", new Category());
//		return ADD;
//	}
//	
//	@RequestMapping("/saveProcess")
//	public String saveCategory(@ModelAttribute("category") Category category){
//		categoryMapper.saveCategory(category);
//		System.out.println("Saved category");
//
//		return "redirect:/category/listOfCategories";
//	}
//	
//	@RequestMapping("/updateCategory")
//	public String updateCategory(@RequestParam("categoryCode") String categoryCode, Model model){
//		Category category = categoryMapper.findByCode(categoryCode);
//		model.addAttribute("category", category);
//		return UPDATE;
//	}
//	
//	@RequestMapping("/saveUpdate")
//	public String saveUpdateCategory(@RequestParam("oldCategoryCode") String oldCategoryCode, @ModelAttribute("category") Category category){
//		categoryMapper.updateByCode(category, oldCategoryCode);
//		System.out.println("Updated category");
//		return "redirect:/category/listOfCategories";
//	}	
//
//	@RequestMapping("/deleteCategory")
//	public String deleteCategory(@RequestParam("categoryCode") String categoryCode){
//		categoryMapper.deleteCategory(categoryCode);
//		return "redirect:/category/listOfCategories";
//	}
}
