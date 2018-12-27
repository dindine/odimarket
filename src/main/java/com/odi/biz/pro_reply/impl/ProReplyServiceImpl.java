package com.odi.biz.pro_reply.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odi.biz.pro_reply.ProReplyService;
import com.odi.biz.pro_reply.ProReplyVO;

@Service("proReplyService")
public class ProReplyServiceImpl implements ProReplyService {

	@Autowired
	private ProReplyDAO proReplyDAO;
	
	@Override
	public void insertBoard(ProReplyVO vo) {
		proReplyDAO.insertBoard(vo);

	}

	@Override
	public void updateBoard(ProReplyVO vo) {
		proReplyDAO.updateBoard(vo);

	}

	@Override
	public void deleteBoard(ProReplyVO vo) {
		proReplyDAO.deleteBoard(vo);

	}

	@Override
	public ProReplyVO getBoard(ProReplyVO vo) {
		return proReplyDAO.getBoard(vo);
	}

	@Override
	public List<ProReplyVO> getBoardList(ProReplyVO vo) {
		
		return proReplyDAO.getBoardList(vo);
	}

}
