package com.odi.biz.pro_answer.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.odi.biz.pro_answer.ProAnsVO;


@Repository("proAnsDAO")
public class ProAnsDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//게시글 상세조회
	public ProAnsVO getAns(ProAnsVO vo) {
		System.out.println("===> 상품속 대댓글 -> MyBatis로 getAns() 처리");
		return mybatis.selectOne("ProAnsDAO.pro_ans_One", vo);
	}
	
	
	//게시글 전체 조회
		public List<ProAnsVO> getAnsList(ProAnsVO vo) {
			System.out.println("===>  상품속 대댓글 -> MyBatis로 getAnsList() 처리");
			return mybatis.selectList("ProAnsDAO.pro_ans_all_List", vo);
		}

		public void insertAns(ProAnsVO vo) {
			System.out.println("===> 상품속 대댓글 ->  MyBatis로 insertAns() 처리");
			mybatis.insert("ProAnsDAO.pro_answer_insert", vo);
		}

		public void updateAns(ProAnsVO vo) {
			System.out.println("===> 상품속 대댓글 ->  MyBatis로 updateAns() 처리");
			mybatis.insert("ProAnsDAO.pro_answer_update", vo);

		}

		public void deleteAns(ProAnsVO vo) {
			System.out.println("===> 상품속 대댓글 ->  MyBatis로 deleteAns() 처리");
			mybatis.insert("ProAnsDAO.pro_answer_delete", vo);

		}
		
		//게시물에 해당하는 댓글 전체 건수 조회
		public int proAnsCnt(ProAnsVO vo) {
			System.out.println("===> 상품속 대댓글 ->  MyBatis로 proAnsCnt() 처리");
			int cnt = mybatis.selectOne("ProAnsDAO.b_a_totalCount", vo);
			return cnt;
			
		}
		
		
}
