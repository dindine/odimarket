package com.odi.biz.pro_answer.impl;

import com.odi.biz.pro_answer.ProAnsService;
import com.odi.biz.pro_answer.ProAnsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
