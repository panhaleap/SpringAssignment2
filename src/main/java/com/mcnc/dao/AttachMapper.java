package com.mcnc.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mcnc.entity.Attach;
import com.mcnc.entity.Category;
import com.mcnc.util.MyBatisUtil;


@Repository
public class AttachMapper {
	
//	public void saveCategory(Category category){
//		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
//		session.insert("insertCategory", category);
//		session.commit();
//		session.close();
//	}
//	
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
	public List<Attach> findByBoardId(int boardId){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Attach> attachs = session.selectList("findAttachsByBoardId", boardId);
		session.commit();
		session.close();
		return attachs;
	}
//	
//	//Test CKEditor Comment
//	public void saveCategoryTestCKEditor(Category category){
//		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
//		session.insert("insertCategoryTestCKEditor", category);
//		session.commit(); 
//		session.close();
//	}
//	
//	public Category findByCodeCKEditor(String categoryCode){
//		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
//		Category category = (Category) session.selectOne("findByCodeCKEditor", categoryCode);
//		session.commit();
//		session.close();
//		return category;
//	}
//	
//	public void updateByCodeCKEditor(Category category, String oldCategoryCode){
//		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
//		HashMap<String, Object> map=new HashMap<String, Object>();
//		map.put("category", category);
//		map.put("oldCategoryCode", oldCategoryCode);		
//		session.update("updateByCodeCKEditor", map);
//		session.commit();
//		session.close();
//	}
}
