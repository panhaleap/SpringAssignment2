package com.mcnc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcnc.dao.CategoryMapper;
import com.mcnc.entity.Category;

@Controller
public class MyController {
	@Autowired
	CategoryMapper categoryMapper;
	
    @GetMapping("/")
    public String index(Model model) {

       model.addAttribute("message", "Hello Spring MVC 5!");
       return "hello";
   }
    
    @GetMapping("/upload")
    public String getPageUpload(Model model) {
       return "upload";
   }
    
   @GetMapping("/ckEditor")
   public String getPageCKeditor(Model model) {
	model.addAttribute("category", new Category());
	return "ckEditor";
   }
   
   @RequestMapping("/ckEditorSaveProcess")
	public String saveCategory(@ModelAttribute("category") Category category){
	   categoryMapper.saveCategoryTestCKEditor(category);
		System.out.println("Saved Test CKEditor Comment");

		return "redirect:/category/listOfCategories";
	}
}

