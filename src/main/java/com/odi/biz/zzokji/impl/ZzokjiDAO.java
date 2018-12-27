//package com.odi.biz.zzokji.impl;
//
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//@Repository("zzokjiDAO")
//public class ZzokjiDAO {
//	@Autowired
//	private SqlSessionTemplate mybatis;
//
//	public CharSequence count_receive_note(String payload) {
//		System.out.println("===> 쪽지 갯수 -> MyBatis로 count_receive_note() 처리");
//		return mybatis.selectOne("ZzokjiDAO.zzopki_count", payload);
//	}
//
//}
