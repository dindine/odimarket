package com.odi.biz.pro_answer;

import java.util.List;

public interface ProAnsService {
    //CRUD 기능 구현 메소드 정의
    //댓글입력
    void insertAns(ProAnsVO vo);

    //댓글수정
    void updateAns(ProAnsVO vo);

    //댓글삭제
    void deleteAns(ProAnsVO vo);

    //댓글 상세 조회
    ProAnsVO getAns(ProAnsVO vo);

    //댓글 목록 전체 조회
    List<ProAnsVO> getAnsList(ProAnsVO vo);

    //댓글 갯수
    int proAnsCnt(ProAnsVO vo);
}
