package com.mcnc.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mcnc.entity.BoardComment;
import com.mcnc.util.MyBatisUtil;


@Repository
public class BoardCommentMapper {
	
	public void saveCategory(BoardComment boardComment){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("insertBoardComment", boardComment);
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
//	public Category findByCode(String categoryCode){
//		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
//		Category category = (Category) session.selectOne("findByCode", categoryCode);
//		session.commit();
//		session.close();
//		return category;
//	}
}
