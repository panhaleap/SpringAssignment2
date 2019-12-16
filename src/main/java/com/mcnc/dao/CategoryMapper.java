package com.mcnc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mcnc.entity.Category;
import com.mcnc.util.MyBatisUtil;


@Repository
public class CategoryMapper {
	
	public void saveCategory(Category category){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("insertCategory", category);
		session.commit();
		session.close();
	}
	
	public void updateCategory(Category category){
//		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
//		session.update("updateEmployee", employee);
//		session.commit();
//		session.close();
	}
	
	public void deleteCategory(String categoryCode){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.delete("deleteCategory", categoryCode);
		session.commit();
		session.close();
	}
	
	public List<Category> getAllCategories(){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Category> categoryList = session.selectList("getAllCategories");
		session.commit();
		session.close();
		return categoryList;
	}
	
	public Category findByCode(String categoryCode){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		Category category = (Category) session.selectOne("findByCode", categoryCode);
		session.commit();
		session.close();
		return category;
	}
}
