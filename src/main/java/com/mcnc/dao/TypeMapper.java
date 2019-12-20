package com.mcnc.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mcnc.entity.Type;
import com.mcnc.util.MyBatisUtil;


@Repository
public class TypeMapper {
	
	public void saveType(Type type){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("insertType", type);
		session.commit();
		session.close();
	}
	
	public void updateByCode(Type type, String oldTypeCode){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("type", type);
		map.put("oldTypeCode", oldTypeCode);		
		session.update("updateByTypeCode", map);
		session.commit();
		session.close();
	}
	
	public void deleteType(String typeCode){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.delete("deleteType", typeCode);
		session.commit();
		session.close();
	}
	
	public List<Type> getAllTypes(){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Type> typeList = session.selectList("getAllTypes");
		session.commit();
		session.close();
		return typeList;
	}
	
	public Type findByCode(String typeCode){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		Type type = (Type) session.selectOne("findByTypeCode", typeCode);
		session.commit();
		session.close();
		return type;
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
