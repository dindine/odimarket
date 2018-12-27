package com.odi.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.odi.biz.pro_answer.ProAnsService;
import com.odi.biz.pro_answer.ProAnsVO;

@Controller
@SessionAttributes("proAns") // proAns라는 이름으로 session에 저장
public class ProAnsController {
	@Autowired
	private ProAnsService proAnsService;

	
	@RequestMapping("/getProAns.do")
	public String getProAns(@RequestParam("pro_b_idx") String pro_b_idx, ProAnsVO vo, Model model, HttpServletRequest request) {
			
		List<ProAnsVO> list = proAnsService.getAnsList(vo);
		int proAns_totalcount = list.size();
		System.out.println("댓글 리스트 데이터 수 : " + proAns_totalcount);
		if(pro_b_idx.contains(",")) {			
			pro_b_idx = pro_b_idx.substring(0, pro_b_idx.lastIndexOf(","));
		}
		System.out.println("pro_b_idx : " + pro_b_idx);
		//System.out.println("p_idx : " + p_idx);//@RequestParam("p_idx") String p_idx,
		model.addAttribute("b_answers", proAnsService.getAnsList(vo));
		model.addAttribute("proAns_totalcount", proAns_totalcount);
		model.addAttribute("pro_b_idx", pro_b_idx);
		//model.addAttribute("p_idx", p_idx);
		model.addAttribute("c_b_tot", proAns_totalcount);
		//System.out.println("pro_b_idx : " + request.getAttribute("pro_b_idx"));
		//model.addAttribute("pro_b_idx", request.getAttribute("pro_b_idx")); //request.getAttribute("pro_b_idx")
		return "ansList.jsp";
	}

	@RequestMapping("/insertProAns.do")
	public String insertAns(ProAnsVO vo, Model model, HttpServletRequest request) throws IllegalStateException, IOException {
		System.out.println(">>> 댓글 등록 요청 처리(insertAns)");

		System.out.println("댓글등록 vo : " + vo);
		

		// 전달받은 파라미터값을 사용해서 입력처리
		// 스프링에서 파라미터값을 AnsVO 타입의 객체에 입력하고 vo변수에 주입
		proAnsService.insertAns(vo);

		return "complete.jsp";
	}

	@RequestMapping("/updateProAns.do")
	public String updateAns(ProAnsVO vo, Model model) throws IllegalStateException, IOException {
		System.out.println(">>> 댓글 수정 요청 처리(updateAns)");
		System.out.println("글쓴이 전달 : " + vo);

		
		// 전달받은 파라미터값을 사용해서 입력처리
		// 스프링에서 파라미터값을 AnsVO 타입의 객체에 입력하고 vo변수에 주입
		proAnsService.updateAns(vo);

		return "complete.jsp";
	}

	@RequestMapping("/deleteProAns.do")
	public String deleteAns(ProAnsVO vo) {
		System.out.println(">>> 댓글 삭제 요청 처리(deleteAns)");
		System.out.println("삭제 할 데이터 전달 : " + vo);

		// 전달받은 파라미터값을 사용해서 입력처리
		// 스프링에서 파라미터값을 AnsVO 타입의 객체에 입력하고 vo변수에 주입
		proAnsService.deleteAns(vo);

		return "complete.jsp";
	}
}
