package com.odi.biz.product.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odi.biz.product.ProductService;
import com.odi.biz.product.ProductVO;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	@Autowired

	private ProductDAO productDAO;

	public ProductServiceImpl() {
		System.out.println("-- ProductServiceImpl 객체 생성");
	}

	@Override
	public List<ProductVO> getProductList(ProductVO vo) {
		return productDAO.getProductList(vo);
	}

	@Override
	public ProductVO getProduct(ProductVO vo) {
		return productDAO.getProduct(vo);
	}

	@Override
	public void insertProduct(ProductVO vo) {
		productDAO.insertProduct(vo);

	}

	@Override
	public void updateProduct(ProductVO vo) {
		productDAO.updateProduct(vo);

	}

	@Override
	public void deleteProduct(ProductVO vo) {
		productDAO.deleteProduct(vo);

	}

	@Override
	public int zzimCount(ProductVO vo) {
		return productDAO.zzimCnt(vo);

	}

	@Override
	public void zzimSel(HashMap<String, Object> hashMap) {
		productDAO.selZzim(hashMap);

	}

	@Override
	public ProductVO zzimInfo(HashMap<String, Object> hashMap) {

		return productDAO.zzimInfo(hashMap);

	}

	@Override
	public void getP_no(String p_category) {
		productDAO.getP_no(p_category);

	}

	@Override
	public List<String> exitsP_no(String category) {
		return productDAO.exitsP_no(category);
	}

	@Override
	public List<String> getCategory() {
		return productDAO.getCategory();
	}

	@Override
	public void getCategory_IDX(String category_kname) {
		productDAO.getCategory_IDX(category_kname);

	}

	@Override
	public List<ProductVO> getProductList_cate(String p_category) {
		return productDAO.getProductList_cate(p_category);
	}

	@Override
	public int insertZzim(HashMap<String, Object> hashMap) {
		return productDAO.insertZzim(hashMap);
		
	}

	@Override
	public List<ProductVO> myZzimList(String cust_id) {
		
		return productDAO.myZzimList(cust_id);
	}

}
