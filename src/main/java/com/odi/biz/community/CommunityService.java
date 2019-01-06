package com.odi.biz.community;

import java.util.List;

import com.odi.biz.product.ProductVO;

public interface CommunityService {

    //상품 전체 조회
    List<ProductVO> getCommunityList(ProductVO vo);

    //상품 상세 조회
    ProductVO getCommunity(ProductVO vo);

    //상품 입력
    void insertCommunity(ProductVO vo);
    
}