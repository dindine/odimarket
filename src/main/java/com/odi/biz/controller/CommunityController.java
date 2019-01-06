package com.odi.biz.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.odi.biz.community.CommunityService;
import com.odi.biz.product.ProductVO;

@Controller
@SessionAttributes("community")
public class CommunityController {
	
	@Autowired
	private CommunityService communityService;
	
	@RequestMapping("/communityList.do")
    public String getProductList(HttpSession session, ProductVO vo, Model model) {
        System.out.println(">> 제품 목록 조회 처리(communityList)");

        List<ProductVO> communityList = communityService.getCommunityList(vo);

        model.addAttribute("communityList", communityList);

        System.out.println("communityList: " + communityList);

        return "community.jsp";
    }
	
	@RequestMapping("/insertCommunity.do")
	public String insertCommunity(ProductVO vo, Model model, MultipartHttpServletRequest mhsq)
			throws IllegalStateException, IOException {
		String p_category = vo.getP_category();
		//String cust_id = vo.getCust_id();
		if (p_category.contains(",")) {
			p_category = p_category.substring(0, p_category.lastIndexOf(","));
		}
		vo.setP_category(p_category);
		vo.setSeller("jin");
		System.out.println("vo : " + vo);
		MultipartFile uploadfile = vo.getUploadfile();
		if (!uploadfile.isEmpty()) {
			String fileName = uploadfile.getOriginalFilename();
			System.out.println("fileName: " + fileName);

			String saveFileName = System.currentTimeMillis() + fileName;

			uploadfile.transferTo(new File("c:/MyStudy/temp/" + saveFileName));
			vo.setP_ori_image1(fileName);

			vo.setP_new_image1(saveFileName);
		} else {
			vo.setP_ori_image1("");
			vo.setP_new_image1("");
		}
		MultipartFile uploadfile2 = vo.getUploadfile2();
		if (!uploadfile.isEmpty()) {
			String fileName = uploadfile2.getOriginalFilename();
			System.out.println("fileName: " + fileName);
			String saveFileName = System.currentTimeMillis() + fileName;

			uploadfile2.transferTo(new File("c:/MyStudy/temp/" + saveFileName));
			vo.setP_ori_image2(fileName);

			vo.setP_new_image2(saveFileName);
		} else {
			vo.setP_ori_image2("");

			vo.setP_new_image2("");
		}

		MultipartFile uploadfile3 = vo.getUploadfile3();
		if (!uploadfile.isEmpty()) {
			String fileName = uploadfile3.getOriginalFilename();
			System.out.println("fileName: " + fileName);
			String saveFileName = System.currentTimeMillis() + fileName;

			uploadfile3.transferTo(new File("c:/MyStudy/temp/" + saveFileName));
			vo.setP_ori_image3(fileName);

			vo.setP_new_image3(saveFileName);
		} else {

			vo.setP_ori_image3("");

			vo.setP_new_image3("");

		}

		MultipartFile uploadfile4 = vo.getUploadfile4();
		if (!uploadfile.isEmpty()) {
			String fileName = uploadfile4.getOriginalFilename();
			System.out.println("fileName: " + fileName);
			String saveFileName = System.currentTimeMillis() + fileName;

			uploadfile4.transferTo(new File("c:/MyStudy/temp/" + saveFileName));
			vo.setP_ori_image4(fileName);

			vo.setP_new_image4(saveFileName);
		} else {

			vo.setP_ori_image4("");

			vo.setP_new_image4("");
		}

		MultipartFile uploadfile5 = vo.getUploadfile5();
		if (!uploadfile.isEmpty()) {
			String fileName = uploadfile5.getOriginalFilename();
			System.out.println("fileName: " + fileName);
			String saveFileName = System.currentTimeMillis() + fileName;

			uploadfile5.transferTo(new File("c:/MyStudy/temp/" + saveFileName));
			vo.setP_ori_image5(fileName);

			vo.setP_new_image5(saveFileName);
		} else {

			vo.setP_ori_image5("");

			vo.setP_new_image5("");
		}

		System.out.println("상품 vo : " + vo);
		communityService.insertCommunity(vo);

		return "communityList.do";
	}

}
