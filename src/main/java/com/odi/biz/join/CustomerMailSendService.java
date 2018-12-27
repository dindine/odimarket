package com.odi.biz.join;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//import com.spring.biz.customer.impl.CustomerDAO;

@Service
public class CustomerMailSendService {


    @Autowired
    private CustomerService customerService;
    @Autowired
    private JavaMailSender mailSender;
    // 난수를 이용한 키 생성
    private boolean lowerCheck;
    private int size;

    // 이메일 난수 만드는 메서드
    private String init() {
        Random ran = new Random();
        StringBuffer sb = new StringBuffer();
        int num = 0;

        do {
            num = ran.nextInt(75) + 48;
            if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
                sb.append((char) num);
            } else {
                continue;
            }

        } while (sb.length() < size);
        if (lowerCheck) {
            return sb.toString().toLowerCase();
        }
        return sb.toString();
    }

    public String getKey(boolean lowerCheck, int size) {
        this.lowerCheck = lowerCheck;
        this.size = size;
        return init();
    }

    //------------------------------------------

    // 회원가입 발송 이메일(인증키 발송)
    public void mailSendWithCustKey(String cust_email, String cust_id, HttpServletRequest request) {
        String key = getKey(false, 20); //난수 생성부분
        System.out.println("key : " + key);
        //customerService = sqlSession.getMapper(CustomerServiceImpl.class);
        Map<String, String> map = new HashMap<>();
        map.put("cust_id", cust_id);
        map.put("cust_key", key);

        customerService.getKey(map);

        System.out.println("CustomerMailSendService - " + " cust_id: " + cust_id + ", getKey: " + key);
        try {
            MimeMessage mail = mailSender.createMimeMessage();

            System.out.println("메일 : " + mail);
            String htmlStr = "<h2>안녕하세요 오디마켓입니다!! :D </h2><br><br>"
                    + "<h3>" + cust_id + "님</h3>" + "<p>인증하기 버튼을 누르시면 로그인을 하실 수 있습니다 : "
                    + "<a href='http://localhost:8080" + request.getContextPath() + "/key_alter.do?cust_id=" + cust_id + "&cust_key=" + key + "'>인증하기</a></p>"
                    + "(혹시 잘못 전달된 메일이라면 이 이메일을 무시하셔도 됩니다.)";
            mail.setSubject("[본인인증] 오디마켓 인증메일입니다.", "utf-8");
            mail.setText(htmlStr, "utf-8", "html");
            mail.addRecipient(RecipientType.TO, new InternetAddress(cust_email));
            mailSender.send(mail);
        } catch (Exception e) {
            System.out.println("메일 발송 오류입니다!!");
            e.printStackTrace();
        }
    }

}




