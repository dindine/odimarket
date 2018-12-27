package com.odi.biz.join.impl;

import com.odi.biz.join.CustomerService;
import com.odi.biz.join.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//@Service : @Component를 상속받아 만든 비즈니스 로직처리 서비스 영역에 사용
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public CustomerServiceImpl() {
        System.out.println(">> CustomerServiceImpl 객체생성");
    }

    //회원가입
    @Override
    public void insertCustomer(CustomerVO vo) {
        customerDAO.insertCustomer(vo);
    }

    //회원목록
    @Override
    public List<CustomerVO> getCustomerList(CustomerVO vo) {
        return customerDAO.getCustomerList(vo);
    }

    //회원삭제
    @Override
    public void deleteCustomer(CustomerVO vo) {
        customerDAO.deleteCustomer(vo);
    }

    //난수
    @Override
    public int getKey(Map<String, String> map) {
        return customerDAO.getKey(map);
    }

    @Override
    public int alter_custKey(Map<String, String> map) {
        return customerDAO.alter_custKey_service(map);
    }

    //중복 아이디 체크
    @Override
    public CustomerVO idCheck(String cust_id) {
        System.out.println("서비스 cust_id : " + cust_id);
        return customerDAO.idCheck(cust_id);
    }

    //중복 이메일 체크
    @Override
    public CustomerVO emailCheck(String cust_email) {
        System.out.println("서비스 cust_email : " + cust_email);
        return customerDAO.emailCheck(cust_email);
    }

}
