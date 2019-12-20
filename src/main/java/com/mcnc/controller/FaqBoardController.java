package com.mcnc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcnc.dao.BoardMapper;
import com.mcnc.dao.CategoryMapper;
import com.mcnc.entity.Board;
import com.mcnc.entity.Category;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller @RequestMapping("/faq")
public class FaqBoardController {
	@Autowired
	BoardMapper boardMapper;
	
	private static final String FAQBOARD_FOULDER = "faq-board/";
	private static final String FAQBOARD_LIST = FAQBOARD_FOULDER + "ListCategories";
	private static final String ADD = FAQBOARD_FOULDER + "Add";
	private static final String UPDATE = FAQBOARD_FOULDER + "Update";
	
	@RequestMapping("/listOfFaq")
	public String showListOfFaq(Model model){
		List<Board> boards = boardMapper.getAllBoards();
		for(Board b : boards) {
			System.out.println(b.getType().getCategory().getName());
		}
		//model.addAttribute("boardList", boards);
		return FAQBOARD_LIST;
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
