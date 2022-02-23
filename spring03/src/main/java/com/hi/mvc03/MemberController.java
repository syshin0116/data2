package com.hi.mvc03;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 스프링 프레임워크에 컨트롤러 역활의 클래스로 등록

public class MemberController {
	//회원과 관련된 여러가지 제어를 담당하는 클래스
	//회원가입, 검색, 수정, 탈퇴, 로그인 기능을 제어함.
	
	@RequestMapping("check.hi")
	public void login(MemberVO vo, MemberDAO dao, HttpSession session) throws Exception {
		System.out.println(vo);
		boolean result = dao.login(vo);
		if(result) {
			//세션을 잡아두어라.
			vo = dao.readOne(vo);
			session.setAttribute("user", vo.getId());
			//name을 세션으로 잡아서, 브라우저 2곳에서 id가 apple인  홍길동님 환영합니다
			session.setAttribute("name", vo.getName());
			System.out.println(vo);
		}
	}
	
	@RequestMapping("create")
	//create라고 요청이 들어오면 회원가입 기능을 처리해주세요.
	public void create(MemberVO vo, MemberDAO dao) throws Exception {
		System.out.println("회원가입 제어 요청됨.");
		//1. 입력한 값 받아옥;
		//2. vo만들어서 넣기.
		System.out.println(vo);
		//3. dao한테 vo주면서 create 호출 (요청)
		
		dao.create(vo);
		
	}
	
	@RequestMapping("del") //핑크화면 
	public void del(MemberVO vo, MemberDAO dao) throws Exception {
		System.out.println("회원탈퇴 제어 요청됨.");
		
		dao.delete(vo);
	}
	@RequestMapping("up") //초록화면
	public void up(MemberVO vo, MemberDAO dao) throws Exception {
		System.out.println("회원수정 제어 요청됨.");
		
		dao.update(vo);
	}

}
