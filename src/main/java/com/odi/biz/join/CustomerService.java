package com.odi.biz.join;

import java.util.List;
import java.util.Map;

public interface CustomerService {


    void insertCustomer(CustomerVO vo);

    List<CustomerVO> getCustomerList(CustomerVO vo);

    void deleteCustomer(CustomerVO vo); //회원 삭제

    int getKey(Map<String, String> map); // 유저 인증키 생성 메서드

    int alter_custKey(Map<String, String> map);// 유저 인증키 Y로 바꿔주는 메서드

    //아이디 중복확인
    CustomerVO idCheck(String cust_id);

    //이메일 중복확인
    CustomerVO emailCheck(String cust_email);


}
	
	
