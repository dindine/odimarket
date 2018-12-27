package com.odi.biz.pro_reply;

import java.util.List;

public interface ProReplyService {
	//CRUD 기능 구현 메소드 정의
	//글입력
	void insertBoard(ProReplyVO vo);
	//글수정
	void updateBoard(ProReplyVO vo);
	//글삭제
	void deleteBoard(ProReplyVO vo);
	//글 상세 조회
	ProReplyVO getBoard(ProReplyVO vo);
	//글 목록 전체 조회
	List<ProReplyVO> getBoardList(ProReplyVO vo);
}
