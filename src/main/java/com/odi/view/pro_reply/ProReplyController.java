package com.odi.view.pro_reply;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.odi.biz.pro_reply.ProReplyService;
import com.odi.biz.pro_reply.ProReplyVO;

@Controller
@SessionAttributes("proReply") // proReply라는 이름으로 session에 저장
public class ProReplyController {
	@Autowired
	private ProReplyService proReplyService;

	@RequestMapping("/productcontent.do")
	public String showview() {
		return "product_content.jsp";
	}

	@RequestMapping("/getProReply.do")
	public String getProReply(@RequestParam("p_idx") String p_idx, ProReplyVO vo, Model model) {
		if(p_idx.contains(",")) {			
			p_idx = p_idx.substring(0, p_idx.lastIndexOf(","));
		}
		vo.setP_idx(p_idx);
		System.out.println("확인용 : " + vo);
		List<ProReplyVO> list = proReplyService.getBoardList(vo);
		int proReply_totalcount = list.size();
		System.out.println("리스트 : " + list +" \n리스트 데이터 수 : " + proReply_totalcount);
		model.addAttribute("proReply", proReplyService.getBoardList(vo));
		model.addAttribute("proReply_totalcount", proReply_totalcount);
		
		model.addAttribute("p_idx", p_idx);
		return "boardList.jsp";
	}

	@RequestMapping("/insertProReply.do")
	public String insertBoard(ProReplyVO vo, Model model) throws IllegalStateException, IOException {
		System.out.println(">>> 글 등록 요청 처리(insertBoard)");

		System.out.println("글등록 vo : " + vo);
		// 파일 업로드 처리
		// MultipartFile 인터페이스 주요 메소드
		// String getOriginalFilename() : 업로드한 파일명
		// void transferTo(File destFile) : 업로드한 파일을 destFile에 저장
		// boolean isEmpty() : 업로드한 파일의 존재여부(없으면 true 리턴)
		try {

			MultipartFile uploadFile = vo.getUploadFile();
			if (!uploadFile.isEmpty()) {
				String fileName = uploadFile.getOriginalFilename();
				String newName = fileName + System.currentTimeMillis() + uploadFile.getSize();
				uploadFile.transferTo(new File("c:/MyStudy/temp/" + fileName));
				vo.setPro_b_ori_name(fileName);
				vo.setPro_b_file_name(newName);
				
			} else {
				vo.setPro_b_ori_name("");
				vo.setPro_b_file_name("");
			}

		} catch (Exception e) {
			System.out.println("파일오류");
			vo.setPro_b_ori_name("");
			vo.setPro_b_file_name("");
		}

		// 전달받은 파라미터값을 사용해서 입력처리
		// 스프링에서 파라미터값을 BoardVO 타입의 객체에 입력하고 vo변수에 주입
		proReplyService.insertBoard(vo);
		String cust_id = vo.getPro_b_writer();
		model.addAttribute("cust_id", cust_id);

		return "product_content.jsp?cust_id="+cust_id;
	}

	@RequestMapping("/updateProReply.do")
	public String updateBoard(ProReplyVO vo, Model model) throws IllegalStateException, IOException {
		System.out.println(">>> 글 수정 요청 처리(updateBoard)");
		System.out.println("글쓴이 전달 : " + vo);

		try {

			MultipartFile uploadFile = vo.getUploadFile();
			System.out.println("uploadFile : " + uploadFile);
			if (!uploadFile.isEmpty()) {
				String fileName = uploadFile.getOriginalFilename();
				String newName = fileName + System.currentTimeMillis() + uploadFile.getSize();
				uploadFile.transferTo(new File("c:/MyStudy/temp/" + fileName));
				vo.setPro_b_ori_name(fileName);
				vo.setPro_b_file_name(newName);
				
			} else {
				
				vo.setPro_b_ori_name(vo.getPro_b_ori_name());
				vo.setPro_b_file_name(vo.getPro_b_file_name());
			}

		} catch (Exception e) {
			System.out.println("파일오류 : " + vo.getPro_b_ori_name());
			
			vo.setPro_b_ori_name(vo.getPro_b_ori_name());
			vo.setPro_b_file_name(vo.getPro_b_file_name());
		}
		// 전달받은 파라미터값을 사용해서 입력처리
		// 스프링에서 파라미터값을 BoardVO 타입의 객체에 입력하고 vo변수에 주입
		proReplyService.updateBoard(vo);

		return "product_content.jsp";
	}

	@RequestMapping("/deleteProReply.do")
	public String deleteBoard(ProReplyVO vo) {
		System.out.println(">>> 글 삭제 요청 처리(deleteBoard)");
		System.out.println("삭제 할 데이터 전달 : " + vo);

		// 전달받은 파라미터값을 사용해서 입력처리
		// 스프링에서 파라미터값을 BoardVO 타입의 객체에 입력하고 vo변수에 주입
		proReplyService.deleteBoard(vo);

		return "complete.jsp";
	}
}
