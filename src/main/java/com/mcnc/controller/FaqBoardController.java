package com.mcnc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mcnc.dao.BoardCommentMapper;
import com.mcnc.dao.BoardMapper;
import com.mcnc.dao.CategoryMapper;
import com.mcnc.entity.Board;
import com.mcnc.entity.BoardComment;
import com.mcnc.entity.Category;
import com.mcnc.service.UploadFileConfiguration;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller @RequestMapping("/faq")
public class FaqBoardController {
	@Autowired
	BoardMapper boardMapper;
	
	@Autowired
	BoardCommentMapper boardCommentMapper;
	@Autowired
	UploadFileConfiguration uploadFileConfiguration;
	
	private static final String FAQBOARD_FOULDER = "faq-board/";
	private static final String FAQBOARD_LIST = FAQBOARD_FOULDER + "faq-board";
	private static final String DETAIL = FAQBOARD_FOULDER + "faq-board-detail";
	private static final String UPDATE = FAQBOARD_FOULDER + "UpdateBoardContent";
	
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
	
	@RequestMapping("/updateFaqContent")
	public String updateCategory(@RequestParam("boardId") int boardId, Model model){
		Board board = boardMapper.findByBoardId(boardId);
		model.addAttribute("board", board);
		return UPDATE;
	}
	
	@RequestMapping(value="/saveUpdate", method = RequestMethod.POST)
	public String saveUpdateCategory(/* @RequestParam ("html") String html, */ 
									@RequestParam("file") MultipartFile file, @ModelAttribute("board") Board board){
		uploadFileConfiguration.uploadFileHandler(file);
//		board = boardMapper.findByBoardId(board.getId());
//		board.setUpdatedBy("panha leap");
		/*
		 * board.setHtml(html); boardMapper.updateByBoardId(board);
		 */
		System.out.println("=======> " + board.toString());
		return "redirect:/faq/faqBoardDetail?boardId=" + 1;//board.getId();
	}	
//
//	@RequestMapping("/deleteCategory")
//	public String deleteCategory(@RequestParam("categoryCode") String categoryCode){
//		categoryMapper.deleteCategory(categoryCode);
//		return "redirect:/category/listOfCategories";
//	}
}
