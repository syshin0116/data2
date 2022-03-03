package com.cgv.mvc;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class MemberController {

	@Autowired
	MemberDAO dao; 
	
	@RequestMapping("check")
	public String check(MemberVO vo, HttpSession session) throws Exception {
		System.out.println(vo);
		MemberVO vo2 = dao.login(vo);
		System.out.println(vo2);
		
		if(vo2 != null) { //로그인 성공! 
			session.setAttribute("mId", vo2.getmId());
			return "redirect:movie.jsp";
		}else {  
			return "check";
		}
	}

	@RequestMapping("mMyInfo")
	public void info(MemberVO vo , Model model ) {
		MemberVO vo2 = dao.one(vo);
		model.addAttribute("one", vo2);
	}
	
	@RequestMapping("mDelete")
	public void del(MemberVO vo, HttpSession session) {
		int result = dao.del(vo);
		session.invalidate();
	}
	@RequestMapping("login")
	public void login() {
	}
	
	@RequestMapping("mRegister")
	public void regis() {
	}	
	@RequestMapping("mUpdate")
	public String up(MemberVO vo, Model model) {
		System.out.println("1>>" + vo);
		int result = dao.up(vo);
		MemberVO vo2 = dao.one(vo);
		System.out.println("2>>" + vo2);
		model.addAttribute("one", vo2);
		return "mMyInfo";
		
	}
	
	@RequestMapping("mModify") //수정하는 화면으로 가기.
	public void  modify(MemberVO vo, Model model) {
		System.out.println(vo);
		MemberVO vo2 = dao.one(vo);
		model.addAttribute("one", vo2);
		
		//수정한 값 가지고 와서, 
		//dao에게 수정해달라고 요청
		//views-> mModify.jsp
		//db에 수정이 되었는지 확인해서 값을 가지고 와야함.
		
	}
	

	
	
	@RequestMapping("create")
	public String regis(MemberVO vo) throws Exception {
		System.out.println(vo);
		int result = dao.create(vo);
		if(result == 1) {
			return "ok";
		}else {
			return "mRegister";
		}
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:movie.jsp";
	}
	
	
	
//	@RequestMapping("list")
//	public void list(Model model) {
//		List<MemberVO> list = dao.all();
//		model.addAttribute("list", list);
//	}
	
	
	
}