package com.hi.mvc04;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 스프링 프레임워크에 컨트롤러 역활의 클래스로 등록

public class BookController {
	//회원과 관련된 여러가지 제어를 담당하는 클래스
	//회원가입, 검색, 수정, 탈퇴, 로그인 기능을 제어함.
	@RequestMapping("money.do")
	public void ajax2(double money, int choice, Model model) {
		if (choice==1) {
			money= money * 0.7;
		}else if(choice==2) {
			money = money * 0.9;
		}
		model.addAttribute("moneyResult", (int)money);
	}
	
	@RequestMapping("ajax1")
	public void ajax1(String phone, Model model) {
		System.out.println("ajax1 호출됨");
		//세글자 010 --> 111
		//     011 --> 222
		//     나머지 --> 333
		//랜덤한값 3글자 만들어서
		System.out.println("전달받은 전화번호 " +phone);
		String pre = phone.substring(0,3);
		String no = "";
		if(pre.equals("010")) {
			no += "111";
		}else if (pre.equals("011")){
			no += "222";
		}else {
			no += "333";
		}
		Random r = new Random();
		no += r.nextInt(900)+100;
		System.out.println("전송할 인증번호"+no);
		//views까지 no값을 전달하고 ram에서 제거
		//model 객체의 속성으로 지정
		model.addAttribute("no", no);
	}
	
	@RequestMapping("create")
	//create라고 요청이 들어오면 회원가입 기능을 처리해주세요.
	public void create(BookVO vo, BookDAO dao) throws Exception {
		System.out.println("북마크 제어 요청됨.");
		//1. 입력한 값 받아옥;
		//2. vo만들어서 넣기.
		System.out.println(vo);
		//3. dao한테 vo주면서 create 호출 (요청)
		
		dao.create(vo);
	}

	@RequestMapping("del") //핑크화면 
	public void del(BookVO vo, BookDAO dao) throws Exception {
		System.out.println("북 삭제 제어 요청됨.");
		
		dao.delete(vo);
	}
	@RequestMapping("up") //초록화면
	public void up(BookVO vo, BookDAO dao) throws Exception {
		System.out.println("북 정보 수정 제어 요청됨.");
		
		dao.update(vo);
	}
	@RequestMapping("list")
	public void list(BookVO vo, BookDAO dao, HttpServletRequest request) throws Exception {
		
		
		ArrayList<BookVO> list = dao.readAll();
	 	request.setCharacterEncoding("utf-8");
		request.setAttribute("book_list", list);
	}

}
