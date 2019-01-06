package com.odi.biz.community.impl;


import com.odi.biz.product.ProductVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository("communityDAO")
public class CommunityDAO {
    @Autowired
    private SqlSessionTemplate mybatis;

    //상품 전체조회
    public List<ProductVO> getCommunityList(ProductVO vo) {
        System.out.println("-- getCommunityList() 처리");
        return mybatis.selectList("CommunityDAO.getCommunityList", vo);
    }

    //상품 상세조회
    public ProductVO getCommunity(ProductVO vo) {
        System.out.println("-- getCommunity() 처리");
        return mybatis.selectOne("CommunityDAO.getCommunity", vo);
    }

    //상품 입력
    public void insertCommunity(ProductVO vo) {
        System.out.println("-- insertCommunity() 처리");
        mybatis.insert("CommunityDAO.insertCommunity", vo);

    }

//    public void updateProduct(ProductVO vo) {
//        System.out.println("-- updateProduct() 처리");
//        mybatis.insert("ProductDAO.updateProduct", vo);
//    }
//
//    public void deleteProduct(ProductVO vo) {
//        System.out.println("-- deleteProduct() 처리");
//        mybatis.insert("ProductDAO.deleteProduct", vo);
//    }

   


   
}

