package com.mcnc.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mcnc.entity.BoardComment;
import com.mcnc.util.MyBatisUtil;


@Repository
public class BoardCommentMapper {
	
	public void saveComment(BoardComment boardComment, int boardId){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		boardComment.setCreatedBy("panha leap");
		boardComment.setUpdatedBy("panha leap");
		System.out.println("****** "+boardComment.getComments());
		map.put("boardComment", boardComment);
		map.put("boardId", boardId);
		session.insert("insertBoardComment", map);
		session.commit();
		session.close();
	}
	
//	public void updateByCode(Category category, String oldCategoryCode){
//		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
//		HashMap<String, Object> map=new HashMap<String, Object>();
//		map.put("category", category);
//		map.put("oldCategoryCode", oldCategoryCode);		
//		session.update("updateByCode", map);
//		session.commit();
//		session.close();
//	}
//	
//	public void deleteCategory(String categoryCode){
//		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
//		session.delete("deleteCategory", categoryCode);
//		session.commit();
//		session.close();
//	}
//	
//	public List<Category> getAllCategories(){
//		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
//		List<Category> categoryList = session.selectList("getAllCategories");
//		session.commit();
//		session.close();
//		return categoryList;
//	}
//	
	public List<BoardComment> findByBoardId(int boardId){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<BoardComment> boardComments = session.selectList("findCommentsByBoardId", boardId);
		session.commit();
		session.close();
		return boardComments;
	}
}
