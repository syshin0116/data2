package com.cgv.mvc;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MovieController {

	@Autowired
	MovieDAO dao;

	@RequestMapping("mvList")
	public void list(MovieVO vo, Model model, HttpSession session) {
		List<MovieVO> list = dao.mvList();
		model.addAttribute("mvList", list);
		session.setAttribute("mId", "root");
	}

	@RequestMapping("mvOne")
	public void one(MovieVO vo, Model model, HttpSession session) {
		MovieVO vo2 = dao.mvOne(vo);
		model.addAttribute("one", vo2);
		session.setAttribute("mId", "root");
	}
	@RequestMapping("mvDel")
	public void delete(MovieVO vo, Model model) {
		int result = dao.mvDel(vo);
		model.addAttribute("mvResult", result);
	}
	
	@RequestMapping("mvIn")
	public void insert(MovieVO vo, Model model) {
		
		int result = dao.mvIn(vo);
		String text = "영화등록 성공";
		if(result != 1) {
			text = "영화등록 실패";
		}
		model.addAttribute("result", text);
	}
	
	@RequestMapping("mvUp")
	public void update(MovieVO vo, Model model) {
		MovieVO vo2 = dao.mvOne(vo);
		model.addAttribute("one", vo2);
	}
	@RequestMapping("mvUp2")
	public void update2(MovieVO vo, Model model) {
		//수정하고 싶은 것이 있으면 수정처리 요청. 
		int result = dao.mvUp(vo);
		String text = "영화수정 성공";
		if(result != 1) {
			text = "영화수정실패";
		}
		model.addAttribute("result", text);
		model.addAttribute("one", vo);
	}
}
