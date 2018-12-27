package com.odi.biz.pro_answer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odi.biz.pro_answer.ProAnsService;
import com.odi.biz.pro_answer.ProAnsVO;

@Service("proAnsService")
public class ProAnsServiceImpl implements ProAnsService {

	@Autowired
	private ProAnsDAO proAnsDAO;
	
	@Override
	public void insertAns(ProAnsVO vo) {
		proAnsDAO.insertAns(vo);

	}

	@Override
	public void updateAns(ProAnsVO vo) {
		proAnsDAO.updateAns(vo);

	}

	@Override
	public void deleteAns(ProAnsVO vo) {
		proAnsDAO.deleteAns(vo);

	}

	@Override
	public ProAnsVO getAns(ProAnsVO vo) {
		return proAnsDAO.getAns(vo);
	}

	@Override
	public List<ProAnsVO> getAnsList(ProAnsVO vo) {
		
		return proAnsDAO.getAnsList(vo);
	}

	@Override
	public int proAnsCnt(ProAnsVO vo) {
		int cnt = proAnsDAO.proAnsCnt(vo);
		return cnt;
	}

}
