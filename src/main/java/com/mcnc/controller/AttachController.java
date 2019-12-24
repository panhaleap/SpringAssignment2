package com.mcnc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcnc.dao.AttachMapper;
import com.mcnc.dao.CategoryMapper;
import com.mcnc.entity.Attach;
import com.mcnc.entity.Category;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller @RequestMapping("/attach")
public class AttachController {
	@Autowired
	AttachMapper attachMapper;
	
	private static final String CATEGORY_FOULDER = "category/";
	private static final String CATEGORYLIST = CATEGORY_FOULDER + "ListCategories";
	private static final String ADD = CATEGORY_FOULDER + "Add";
	private static final String UPDATE = CATEGORY_FOULDER + "Update";
	
	@RequestMapping("/listOfAttachFiles")
	public @ResponseBody String showListOfAttachFiles(/* @RequestParam("boardId")int boardId, */ Model model){
		List<Attach> attaches = attachMapper.findByBoardId(1);
		model.addAttribute("attachList", attaches);
		
		  for(Attach attach : attaches) 
		  { 
			  System.out.println(">>>>>>>> "+ attach.getData()); 
		  }
		 
		return "Helllllllo";
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
