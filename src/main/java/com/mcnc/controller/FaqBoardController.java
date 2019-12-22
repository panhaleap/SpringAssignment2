package com.mcnc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcnc.dao.BoardCommentMapper;
import com.mcnc.dao.BoardMapper;
import com.mcnc.dao.CategoryMapper;
import com.mcnc.entity.Board;
import com.mcnc.entity.BoardComment;
import com.mcnc.entity.Category;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller @RequestMapping("/faq")
public class FaqBoardController {
	@Autowired
	BoardMapper boardMapper;
	
	@Autowired
	BoardCommentMapper boardCommentMapper;
	
	private static final String FAQBOARD_FOULDER = "faq-board/";
	private static final String FAQBOARD_LIST = FAQBOARD_FOULDER + "faq-board";
	private static final String DETAIL = FAQBOARD_FOULDER + "faq-board-detail";
	private static final String UPDATE = FAQBOARD_FOULDER + "Update";
	
	@RequestMapping("/listOfFaq")
	public String showListOfFaq(Model model){
		List<Board> boards = boardMapper.getAllBoards();
//		for(Board b : boards) {
//			System.out.println(b.getHtml() + ", " + b.getTitle());
//		}
		model.addAttribute("boardList", boards);
		return FAQBOARD_LIST;
	}
	
	@RequestMapping("/faqBoardDetail")
	public String showFaqDetail(@RequestParam("boardId") int boardId, Model model){
		Board board = boardMapper.findByBoardId(boardId);
		List<BoardComment> boardComments = boardCommentMapper.findByBoardId(boardId);
		model.addAttribute("board", board);
		System.out.println(boardComments.get(0).getComments());
		model.addAttribute("commentList", boardComments);
		return DETAIL;
	}
	
	@RequestMapping("/saveComment")
	public String saveCategory(@RequestParam ("comments") String comments,@RequestParam("boardId") int boardId){
		BoardComment boardComment = new BoardComment();
		boardComment.setComments(comments);
		boardCommentMapper.saveComment(boardComment, boardId);
		System.out.println("Saved comment");

		return "redirect:/faq/faqBoardDetail?boardId=" + boardId;
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
