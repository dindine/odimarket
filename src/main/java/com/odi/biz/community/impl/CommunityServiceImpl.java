package com.odi.biz.community.impl;

import com.odi.biz.community.CommunityService;
import com.odi.biz.product.ProductService;
import com.odi.biz.product.ProductVO;
import com.odi.biz.product.impl.ProductDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("communityService")
public class CommunityServiceImpl implements CommunityService {
    @Autowired
    private CommunityDAO communityDAO;

    public CommunityServiceImpl() {
        System.out.println("-- ProductServiceImpl 객체 생성");
    }

	@Override
	public List<ProductVO> getCommunityList(ProductVO vo) {
		return communityDAO.getCommunityList(vo);
	}

	@Override
	public ProductVO getCommunity(ProductVO vo) {
		
		return communityDAO.getCommunity(vo);
	}

	@Override
	public void insertCommunity(ProductVO vo) {
		communityDAO.insertCommunity(vo);
		
	}

 

}
