package com.odi.biz.controller;

import com.odi.biz.product.ProductService;
import com.odi.biz.product.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/getProductList.do")
    public String getProductList(HttpSession session, ProductVO vo, Model model) {
        System.out.println(">> 제품 목록 조회 처리(getProductList)");

        List<ProductVO> productList = productService.getProductList(vo);

        model.addAttribute("productList", productList);

        System.out.println("productList: " + productList);

        List<String> categoryList = productService.getCategory();
        System.out.println("카테고리: " + categoryList);
        model.addAttribute("categoryList", categoryList);
        session.setAttribute("categoryList", categoryList);

        return "ProductListCategory.jsp";
    }

    @RequestMapping("/getProductList_cate.do")
    public String getProductList_cate(@RequestParam String p_category, ProductVO vo, Model model) {

        List<ProductVO> productList = productService.getProductList_cate(p_category);

        model.addAttribute("productList", productList);

        System.out.println("productList: " + productList);

        List<String> categoryList = productService.getCategory();
        System.out.println("카테고리: " + categoryList);
        model.addAttribute("categoryList", categoryList);

        return "ProductListCategory.jsp";
    }

    @RequestMapping("/getProduct.do")
    public String getProduct(@RequestParam String cust_id, @RequestParam String p_idx, ProductVO vo, Model model) {
        System.out.println(">> 제품 상세 조회 요청 처리 (getProduct)");
        System.out.println("user_id : " + cust_id);

        ProductVO product = productService.getProduct(vo);
        model.addAttribute("product", product);


        if (p_idx.contains(",")) {
            p_idx = p_idx.substring(0, p_idx.lastIndexOf(","));
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("cust_id", cust_id);
        hashMap.put("p_idx", p_idx);
        ProductVO zzimInfo = productService.zzimInfo(hashMap);
        model.addAttribute("zzimInfo", zzimInfo);
        System.out.println("zzimInfo 정보 : " + zzimInfo);

        ArrayList<String> imgarr = new ArrayList<>();
        imgarr.add(product.getP_ori_image1());
        imgarr.add(product.getP_ori_image2());
        imgarr.add(product.getP_ori_image3());
        imgarr.add(product.getP_ori_image4());
        imgarr.add(product.getP_ori_image5());
        model.addAttribute("imgarr", imgarr);

        List<String> categoryList = productService.getCategory();
        System.out.println("카테고리: " + categoryList);
        model.addAttribute("categoryList", categoryList);

        return "product_content.jsp";
    }

    @RequestMapping("/insertProduct_form.do")
    public String insertProduct(ProductVO vo, Model model) {
        System.out.println(">> 상품 등록 처리(insertProduct)");
        List<String> categoryList = productService.getCategory();
        System.out.println("카테고리: " + categoryList);
        model.addAttribute("categoryList", categoryList);

        return "insertProduct.jsp";
    }

    @RequestMapping("/insertProduct.do")
    public String insertProduct(ProductVO vo, Model model, MultipartHttpServletRequest mhsq)
            throws IllegalStateException, IOException {
        String p_category = vo.getP_category();
        if (p_category.contains(",")) {
            p_category = p_category.substring(0, p_category.lastIndexOf(","));
        }
        vo.setP_category(p_category);
        vo.setSeller("hye");

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
        productService.insertProduct(vo);

        return "getProductList.do";
    }
    
    
    
    @RequestMapping("/updateProduct_form.do")
    public String updateProduct_form(ProductVO vo, Model model) {
        System.out.println(">> 상품 수정 폼 (updateProduct_form)");

        model.addAttribute("product", productService.getProduct(vo));

        List<String> categoryList = productService.getCategory();

        System.out.println("카테고리: " + categoryList);

        model.addAttribute("categoryList", categoryList);

        return "updateProduct.jsp";
    }

    @RequestMapping("/updateProduct.do")

    public String updateProduct(ProductVO vo, Model model, MultipartHttpServletRequest mhsq)
            throws IllegalStateException, IOException {

        String p_category = vo.getP_category();
        if (p_category.contains(",")) {
            p_category = p_category.substring(0, p_category.lastIndexOf(","));
        }
        vo.setP_category(p_category);
        vo.setSeller("hye");

        System.out.println(">> 상품 수정 처리(updateProduct)");

        MultipartFile uploadfile = vo.getUploadfile();
        if (!uploadfile.isEmpty()) {
            String fileName = uploadfile.getOriginalFilename();
            System.out.println("fileName: " + fileName);

            String saveFileName = System.currentTimeMillis() + fileName;

            uploadfile.transferTo(new File("c:/MyStudy/temp/" + saveFileName));
            vo.setP_ori_image1(fileName);

            vo.setP_new_image1(saveFileName);
        } else {
            vo.setP_ori_image1(vo.getP_ori_image1());

            vo.setP_new_image1(vo.getP_new_image1());

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
            vo.setP_ori_image1(vo.getP_ori_image2());

            vo.setP_new_image1(vo.getP_new_image2());

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

            vo.setP_ori_image1(vo.getP_ori_image3());

            vo.setP_new_image1(vo.getP_new_image3());

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

            vo.setP_ori_image1(vo.getP_ori_image4());

            vo.setP_new_image1(vo.getP_new_image4());
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

            vo.setP_ori_image1(vo.getP_ori_image5());

            vo.setP_new_image1(vo.getP_new_image5());
        }

        System.out.println("상품 vo : " + vo);
        productService.updateProduct(vo);

        return "getProductList.do";
    }

    @RequestMapping("/deleteProduct.do")
    public String deleteProduct(ProductVO vo, Model model) {
        System.out.println(">> 제품 삭제 처리(deleteProduct)");
        System.out.println("상품 vo : " + vo);

        productService.deleteProduct(vo);

        return "getProductList.do";
    }

    @RequestMapping("/getPno.do")
    public String getPno(String p_category, Model model) {
        System.out.println(">> 카테고리 데이터 갯수 조회");
        model.addAttribute("p_category");

        return "ProductListCategory.jsp";
    }

    @RequestMapping("/exitsP_no.do")
    public String exitsP_no(String category, Model model) {
        System.out.println("");
        List<String> categoryList = productService.exitsP_no(category);

        return "ProductListCategory.jsp";
    }

    @RequestMapping("/getCategory.do")
    public String getCategory(Model model) {
        List<String> categoryList = productService.getCategory();
        model.addAttribute("categoryList", categoryList);
        System.out.println(">> 카테고리 목록 조회");

        return "ProductListCategory.jsp";
    }

    @RequestMapping("/getCategory_IDX.do")
    public String getCategory_IDX(String category_kname, Model model) {
        model.addAttribute("category_kname");
        System.out.println(">> 카테고리 고유 태그 이름 조회");

        return "ProductListCategory.jsp";
    }

    @RequestMapping("/myZzimList.do")
    public String myZzimList(@RequestParam String cust_id, Model model) {
        if (cust_id.contains(",")) {
            cust_id = cust_id.substring(0, cust_id.lastIndexOf(","));
        }
        List<ProductVO> zzimList = productService.myZzimList(cust_id);
        System.out.println("나의 찜 리스트 : " + zzimList);
        model.addAttribute("zzimList", zzimList);

        return "myZzimList.jsp";
    }

    @RequestMapping("/zzimDel.do")
    public String zzimDel(@RequestParam String cust_id, @RequestParam String p_idx, Model model) {
        if (cust_id.contains(",")) {
            cust_id = cust_id.substring(0, cust_id.lastIndexOf(","));
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("cust_id", cust_id);
        hashMap.put("p_idx", p_idx);
        hashMap.put("zzim_check", 0);

        System.out.println("hashMap : " + hashMap);
        productService.zzimSel(hashMap); // 찜 테이블에 찜 체크

        ProductVO productVO = new ProductVO();
        productVO.setP_idx(p_idx);
        productService.zzimCount(productVO); // 찜 카운트 업데이트

        return "myZzimList.do";
    }

    @ResponseBody
    @RequestMapping("/like.do")
    public Map<String, Object> like(@RequestParam("cust_id") String cust_id, @RequestParam("p_idx") String p_idx,
                                    HttpSession session, Model model) {
        if (p_idx.contains(",")) {
            p_idx = p_idx.substring(0, p_idx.lastIndexOf(","));
        }

        System.out.println("cust_id : " + cust_id + ", p_idx : " + p_idx);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("cust_id", cust_id);
        hashMap.put("p_idx", p_idx);

        System.out.println("hashMap : " + hashMap);
        ArrayList<String> msgs = new ArrayList<>();

        ProductVO pid = new ProductVO();
        pid.setP_idx(p_idx);
        System.out.println("pid : " + pid);
        ProductVO productVO = productService.getProduct(pid);
        ProductVO likeCheckVO;
        try {
            likeCheckVO = productService.zzimInfo(hashMap);
        } catch (Exception e) {
            likeCheckVO = new ProductVO();
        }

        System.out.println("상품 정보 : " + productVO);
        System.out.println("찜 테이블 정보 : " + likeCheckVO);

        int zzim = Integer.parseInt(productVO.getZzim()); // 상품의 찜 카운트
        System.out.println("zzim : " + zzim);
        int zzim_check = 0;
        try {
            zzim_check = Integer.parseInt(likeCheckVO.getZzim_check()); // 좋아요 체크 값

            if (zzim_check == 0) {
                System.out.println("좋아요 추가");
                msgs.add("좋아요!");
                zzim++;
                zzim_check++;

                hashMap.put("cust_id", cust_id);
                hashMap.put("p_idx", p_idx);
                hashMap.put("zzim_check", zzim_check);

                System.out.println("hashMap : " + hashMap);
                productService.zzimSel(hashMap); // 찜 테이블에 찜 체크
                System.out.println("상품 정보_count : " + productVO);

                productService.zzimCount(productVO); // 찜 카운트 업데이트
                System.out.println("완료!!!");
            } else {
                msgs.add("좋아요 취소!");
                zzim--;
                zzim_check--;

                hashMap.put("cust_id", cust_id);
                hashMap.put("p_idx", p_idx);
                hashMap.put("zzim_check", zzim_check);

                System.out.println("hashMap : " + hashMap);
                productService.zzimSel(hashMap); // 찜 테이블에 찜 체크

                hashMap.put("like_check", zzim_check);

                productService.zzimCount(productVO); // 찜 카운트 업데이트

            }
        } catch (Exception e) {
            zzim_check = 0;
            if (zzim_check == 0) {
                System.out.println("좋아요 추가");
                msgs.add("좋아요!");
                zzim++;
                zzim_check++;

                hashMap.put("cust_id", cust_id);
                hashMap.put("p_idx", p_idx);
                hashMap.put("zzim_check", zzim_check);

                System.out.println("hashMap : " + hashMap);
                productService.insertZzim(hashMap); // 찜 테이블에 찜 체크
                System.out.println("상품 정보_count : " + productVO);

                productService.zzimCount(productVO); // DB 찜 카운트 추가
                System.out.println("완료!!!");
            } else {
                msgs.add("좋아요 취소!");
                zzim--;
                zzim_check--;

                hashMap.put("cust_id", cust_id);
                hashMap.put("p_idx", p_idx);
                hashMap.put("zzim_check", zzim_check);

                System.out.println("hashMap : " + hashMap);
                productService.insertZzim(hashMap); // 찜 테이블에 찜 체크

                hashMap.put("like_check", zzim_check);

                productService.zzimCount(productVO); // DB 찜 카운트 추가

            }
        }
        productVO = productService.getProduct(pid);
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg", msgs);
        resultMap.put("zzim", productVO.getZzim());
        resultMap.put("zzim_check", String.valueOf(zzim_check));
        resultMap.put("p_idx", p_idx);

        System.out.println("resultMap : " + resultMap);
        model.addAttribute("p_idx", p_idx);
        model.addAttribute("cust_id", "ri");
        System.out.println("resultMap.toString() : " + resultMap.toString());

        return resultMap;

    }
}
