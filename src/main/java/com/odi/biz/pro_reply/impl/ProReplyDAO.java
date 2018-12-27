package com.odi.biz.pro_reply.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.odi.biz.pro_reply.ProReplyVO;


@Repository("proReplyDAO")
public class ProReplyDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//게시글 상세조회
	public ProReplyVO getBoard(ProReplyVO vo) {
		System.out.println("===> 상품속 댓글 -> MyBatis로 getBoard() 처리");
		return mybatis.selectOne("ProReplyDAO.pro_reply_One", vo);
	}
	
	
	//게시글 전체 조회
		public List<ProReplyVO> getBoardList(ProReplyVO vo) {
			System.out.println("===>  상품속 댓글 -> MyBatis로 getBoardList() 처리");
			System.out.println("전달받은 p_idx : " + vo.getP_idx());
			return mybatis.selectList("ProReplyDAO.pro_reply_all_List", vo);
		}

		public void insertBoard(ProReplyVO vo) {
			System.out.println("===> 상품속 댓글 ->  MyBatis로 insertBoard() 처리");
			mybatis.insert("ProReplyDAO.pro_reply_write", vo);
		}

		public void updateBoard(ProReplyVO vo) {
			System.out.println("===> 상품속 댓글 ->  MyBatis로 updateBoard() 처리");
			mybatis.insert("ProReplyDAO.pro_reply_modify", vo);

		}

		public void deleteBoard(ProReplyVO vo) {
			System.out.println("===> 상품속 댓글 ->  MyBatis로 deleteBoard() 처리");
			mybatis.insert("ProReplyDAO.pro_reply_delete", vo);

		}
}
