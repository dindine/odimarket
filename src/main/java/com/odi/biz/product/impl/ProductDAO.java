package com.odi.biz.product.impl;


import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.odi.biz.product.ProductVO;

@Repository("productDAO")
public class ProductDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//상품 전체조회
	public List<ProductVO> getProductList(ProductVO vo) {
		System.out.println("-- getProductList() 처리");
		return mybatis.selectList("ProductDAO.getProductList", vo);
	}
	
	//상품 상세조회
	public ProductVO getProduct(ProductVO vo) {
		System.out.println("-- getProduct() 처리");
		return mybatis.selectOne("ProductDAO.getProduct", vo);
	}
	
	//상품 입력
	public void insertProduct(ProductVO vo) {
		System.out.println("-- insertProduct() 처리");
		mybatis.insert("ProductDAO.insertProduct", vo);
		
	}

	public void updateProduct(ProductVO vo) {
		System.out.println("-- updateProduct() 처리");
		mybatis.insert("ProductDAO.updateProduct", vo);
	}
	
	public void deleteProduct(ProductVO vo) {
		System.out.println("-- deleteProduct() 처리");
		mybatis.insert("ProductDAO.deleteProduct", vo);
	}

	public void selZzim(HashMap<String, Object> hashMap) {
		System.out.println("-- selZzim() 처리");
		mybatis.insert("ProductDAO.zzimcount_plus", hashMap);
	}
	
	public int zzimCnt(ProductVO vo) {
		System.out.println("-- zzimCnt() 처리");
		return mybatis.insert("ProductDAO.zzimcount", vo);
	}

	public ProductVO zzimInfo(HashMap<String, Object> hashMap) {
		System.out.println("-- zzimInfo() 처리");
		System.out.println("zzimInfo 의 hashMap : " + hashMap);
		return mybatis.selectOne("ProductDAO.zzimInfo", hashMap);
		
	}
	
	
	//상품고유번호 지정을 위해 해당 카테고리의 데이터 갯수 조회
	public void getP_no(String p_category) {
		mybatis.selectOne("ProductDAO.getP_no",p_category);
	}
	
	//존재하는 해당 카테고리의 상품 고유 번호 리스트
	public List<String> exitsP_no(String category) {
		return mybatis.selectList("ProductDAO.exitsP_no", category);
	}
	
	//카테고리 목록 조회
	public List<String> getCategory() {
		return mybatis.selectList("ProductDAO.getCategory");
	}
	
	//카테고리 목록 조회
	public void getCategory_IDX(String category_kname) {
		mybatis.selectOne("ProductDAO.getCategory_IDX",category_kname);
	}

	public List<ProductVO> getProductList_cate(String p_category) {
		return mybatis.selectList("ProductDAO.getProductList_cate", p_category);
	}

	public int insertZzim(HashMap<String, Object> hashMap) {
		return mybatis.insert("ProductDAO.zzimInsert", hashMap);
	}

	public List<ProductVO> myZzimList(String cust_id) {
		// TODO Auto-generated method stub
		return mybatis.selectList("ProductDAO.myZzim", cust_id);
	}
}

