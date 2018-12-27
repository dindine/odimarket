package com.odi.biz.controller;

import com.odi.biz.join.CustomerMailSendService;
import com.odi.biz.join.CustomerService;
import com.odi.biz.join.CustomerVO;
import com.odi.biz.join.impl.CustomerSha256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    //인증메일 전송을 위해 주입
    @Autowired
    private CustomerMailSendService customerMailSender;


    //@ModelAttribute 설정을 통해 View에 전달할 데이타를 만들어서 전달
    //@ModelAttribute 로 정의된 메소드는 @RequestMapping 보다 먼저 실행됨
    //"conditionMap" 이라는 이름의 속성명에 Map객체가 저장되어 있음
    @ModelAttribute("conditionMap")
    public Map<String, String> searchCondition() {
        //key: 제목, value: TITLE
        //key: 내용, value: CONTENT
        Map<String, String> conditionMap = new HashMap<>();
        conditionMap.put("아이디", "CUST_ID");
        //conditionMap.put("비번", "CUST_PWD");
        //conditionMap.put("이멜", "CUST_EMAIL");
        //conditionMap.put("전번", "CUST_PHONE");
        //conditionMap.put("레벨", "CUST_LEVEL");
        //conditionMap.put("동네", "CUST_ADDR");
        conditionMap.put("닉넴", "CUST_NICKNAME");
        System.out.println("conditionMap: " + conditionMap);

        return conditionMap;
    }

    //회원가입 컨트롤러
    @RequestMapping("/insertCustomer.do")
    public String insertCustomer(CustomerVO vo, HttpServletRequest request) {
        System.out.println(">>> 회원가입 요청 처리(insertCustomer) 기능처리 및 해당 이메일로 인증 메일 발송");

        // 암호 확인
        System.out.println("암호화 전 비밀번호 :" + vo.getCust_pwd());
        // 비밀번호 암호화 (sha256
        String encryPassword = CustomerSha256.encrypt(vo.getCust_pwd());
        vo.setCust_pwd(encryPassword);
        System.out.println("암호화 후 비밀번호 :" + vo.getCust_pwd());

        //회원가입 메서드
        customerService.insertCustomer(vo);
        //인증 메일 보내기 메서드
        customerMailSender.mailSendWithCustKey(vo.getCust_email(), vo.getCust_id(), request);
        System.out.println(">>> 인증메일 발송 요청 처리");
        return "join_notyet.jsp";
    }

    // id 중복 체크 컨트롤러
    //@ResponseBody : ajax를 사용하면 jsp 파일이 필요 없기 때문에, 메서드 앞에 어노테이션 추가
    // 회원 확인
    @ResponseBody
    @RequestMapping(value = "/idCheck.do", method = RequestMethod.POST)
    public int postIdCheck(HttpServletRequest req) {
        System.out.println(">>> 아이디 중복 확인 처리 진입! ");
        String cust_id = req.getParameter("cust_id");
        CustomerVO idCheck = customerService.idCheck(cust_id);

        int result = 0;

        if (idCheck != null) {
            result = 1;
        }

        System.out.println("result : " + result);
        return result;
    }

    // email 중복 체크 컨트롤러
    //@ResponseBody : ajax를 사용하면 jsp 파일이 필요 없기 때문에, 메서드 앞에 어노테이션 추가
    // 회원 확인
    @ResponseBody
    @RequestMapping(value = "/emailCheck.do", method = RequestMethod.POST)
    public int postEmailCheck(HttpServletRequest req) {
        System.out.println(">>> 이메일 중복 확인 처리 진입! ");
        String cust_email = req.getParameter("cust_email");
        CustomerVO emailCheck = customerService.emailCheck(cust_email);

        int result = 0;

        if (emailCheck != null) {
            result = 1;
        }

        System.out.println("result : " + result);
        return result;
    }

    //회원 목록 조회 컨트롤러
    @RequestMapping("/getCustomerList.do")
    public String getCustomerList(CustomerVO vo, Model model) {
        System.out.println(">> 회원목록 조회 처리(getCustomerList)");

        System.out.println("codition: " + vo.getSearchCondition()
                + ", keyword: " + vo.getSearchKeyword());

        //searchCondition 값 null 체크 - null값에 대한 초기화
        if (vo.getSearchCondition() == null) {
            vo.setSearchCondition("CUST_ID");
        }
        if (vo.getSearchKeyword() == null) {
            vo.setSearchKeyword("");
        }


        List<CustomerVO> customerList = customerService.getCustomerList(vo);

        //Model 형식으로 저장해서 DispatcherServlet에 전달
        model.addAttribute("customerList", customerList);

        return "getCustomerList.jsp";
    }

    //회원 삭제 컨트롤러
    @RequestMapping("/deleteCustomer.do")
    public String deleteCustomer(CustomerVO vo) {
        System.out.println(">>> 회원 삭제 요청 처리(deleteCustomer)");
        customerService.deleteCustomer(vo);
        return "getCustomerList.do";
    }

    //지도 불러오는 컨트롤러
    @RequestMapping("/map.do")
    public String getMap(@RequestParam String addr, CustomerVO vo, Model model) {
        System.out.println(">>> 맵 정보 불러오기(getMap)");
        System.out.println("cust_addr:" + addr);
        model.addAttribute("cust_addr", addr);
        return "join.jsp";
    }

    // e-mail 인증 컨트롤러
    @RequestMapping(value = "/key_alter.do", method = RequestMethod.GET)
    public String key_alterConfirm(@RequestParam("cust_id") String cust_id, @RequestParam("cust_key") String key) {
        System.out.println("cust_id: " + cust_id + " cust_key: " + key);
        Map<String, String> map = new HashMap<String, String>();
        map.put("cust_id", cust_id);
        map.put("cust_key", key);
        customerService.alter_custKey(map); // mailsender의 경우 @Autowired

        return "join_complete.jsp";
    }


}
