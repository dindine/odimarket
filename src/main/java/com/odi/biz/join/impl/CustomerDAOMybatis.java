package com.odi.biz.join.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.odi.biz.join.CustomerService;
import com.odi.biz.join.CustomerVO;

@Repository("customerDAOMybatis")
public class CustomerDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;
	private CustomerService customerService;

	
	//회원 가입(insert)
	public void insertCustomer(CustomerVO vo) {
		System.out.println("===> Mybatis로 insertCustomer() 처리");
		mybatis.insert("CustomerDAO.insertCustomer", vo);
	}
	
	//회원 목록 조회(List)
	public List<CustomerVO> getCustomerList(CustomerVO vo) {
		System.out.println("===> Mybatis로 getCustomerList() 처리");
		return mybatis.selectList("CustomerDAO.getCustomerList", vo);
	}
	
	//회원 삭제(delete)
	public void deleteCustomer(CustomerVO vo) {
		System.out.println("===> Mybatis로 deleteCustomer() 처리");
		mybatis.insert("CustomerDAO.deleteCustomer", vo);
		
	}
	
	
	public void key_alterConfirm(CustomerVO vo) {
		System.out.println("===> Mybatis로 key_alterConfirm() 처리");
		mybatis.update("CustomerDAO.key_alterConfirm", vo);
	}
	
	// 인증 확인 메서드 (Y 값으로 바꿔주는 메서드)
	public int alter_custKey_service(Map<String, String> map) {
		
		int resultCnt = 0;
		
		System.out.println("map: " + map);
		//customerService = sqlSession.getMapper(CustomerService.class);
		resultCnt = mybatis.update("CustomerDAO.alter_custKey", map);
		System.out.println("resultCnt: " + resultCnt);
		return resultCnt;
	}
	
	// key값을 난수로 바꾸는 메서드
	public int getKey(Map<String, String> map) {
		System.out.println("===> Mybatis로 getKey() 처리");
		System.out.println("map : " + map);
		 return mybatis.update("CustomerDAO.getKey", map);
	}
	
	//아이디 중복 확인 메서드
	public CustomerVO idCheck(String cust_id) {
		System.out.println("===> Mybatis로 idCheck() 처리");
		System.out.println("cust_id : " + cust_id);
		return mybatis.selectOne("CustomerDAO.idCheck", cust_id);
	}

	public CustomerVO emailCheck(String cust_email) {
		System.out.println("===> Mybatis로 emailCheck() 처리");
		System.out.println("cust_email : " + cust_email);
		return mybatis.selectOne("CustomerDAO.emailCheck", cust_email);
	}

}
