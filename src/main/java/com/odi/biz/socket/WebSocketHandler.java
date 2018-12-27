//package com.odi.biz.socket;
//
///*
//@Component - 제네릭이며 응용 프로그램에서 사용할 수 있습니다., 기본 자동 구성 요소 스캔 주석이며 주석이 달린 클래스가 자동 스캔 구성 요소임을 나타냅니다.
//@Service - 서비스 계층 레벨에서 클래스에 주석을 답니다., 주석 된 클래스가 비즈니스 계층의 서비스 구성 요소임을 나타냅니다.
//@Controller - 주로 Spring MVC에서 사용되는 프리젠 테이션 레이어 레벨에서 클래스에 주석을 추가합니다.,Annotated 클래스는 컨트롤러 구성 요소임을 나타내며 주로 프레젠테이션 계층에서 사용됩니다.
//@Repository - 데이터베이스 저장소 역할을하는 지속성 계층에 클래스에 주석을 추가합니다. , 주석 된 클래스가 비즈니스 계층의 서비스 구성 요소임을 나타냅니다.
//모든 웹 서비스 유형의 DB 연결에 @Service 사용
//저장된 모든 proc DB 연결에 @Repository 사용
// 
// *
// 지속성 계층 구성 요소를 표현하려면 : @Repository
//
//서비스 계층 구성 요소를 나타 내기 위해 : @Service
//
//표현 계층 구성 요소를 표현하려면 @Controller
//
//그렇지 않으면 모든 컴포넌트에 @Component를 사용할 수 있습니다.
// */
//import org.apache.log4j.LogManager;
//import org.slf4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.socket.CloseStatus;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//import com.odi.biz.zzokji.impl.ZzokjiDAO;
//
//@Repository
//
//public class WebSocketHandler extends TextWebSocketHandler {
//
//	@Autowired
//	private ZzokjiDAO zzokjiDAO;
//
//	private final Logger logger = (Logger) LogManager.getLogger(getClass());
//
//	@Override
//	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//
//	}
//
//	@Override
//	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//
//	}
//
//	@Override
//	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//
//		this.logger.info(message.getPayload());
//
//		session.sendMessage(new TextMessage(zzokjiDAO.count_receive_note(message.getPayload())));
//
//		// 현재 수신자에게 몇개의 메세지가 와있는지 디비에서 검색함.
//
//	}
//}
