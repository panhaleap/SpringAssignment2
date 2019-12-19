package com.mcnc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mcnc.dao.CategoryMapper;
import com.mcnc.dao.TypeMapper;
import com.mcnc.entity.Category;
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
	
	@Autowired
	CategoryMapper categoryMapper;
	
	private static final String TYPE_FOULDER = "type/";
	private static final String TYPELIST = TYPE_FOULDER + "ListTypes";
	private static final String ADD = TYPE_FOULDER + "Add";
	private static final String UPDATE = TYPE_FOULDER + "Update";
	
	@RequestMapping("/listOfTypes")
	public String showListOfTypes(Model model){
		List<Type> types = typeMapper.getAllTypes();
		
		  for(Type type: types) { System.out.println(type.getCategoryCode()); }
		 
		model.addAttribute("typeList", types);
		return TYPELIST;
	}
	
//	@RequestMapping("/showFormForAddType")
//	public String addCategory(Model model){
//		Map<String, Object> mapType=new HashMap<>();
//		List<Category> categories = categoryMapper.getAllCategories();
//		mapType.put("type", new Type());
//		mapType.put("categories", categories);
//		model.addAttribute("mapType", mapType);
//		return ADD;
//	}
	
	@RequestMapping("/showFormForAddType")
	public String addCategory(Model model){
		List<Category> categories = categoryMapper.getAllCategories();
		model.addAttribute("type", new Type());
		model.addAttribute("categories", categories);
		return ADD;
	}
	
	@RequestMapping("/saveProcess")
	public String saveCategory(@ModelAttribute("type") Type type){
		typeMapper.saveType(type);
		System.out.println("Saved type");
		return "redirect:/type/listOfTypes";
	}
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
