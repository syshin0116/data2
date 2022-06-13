package com.cgv.mvc;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {

	@Autowired
	ReviewDAO dao;
	@Autowired
	MovieDAO mvdao;
	
	@RequestMapping("rList")
	public void list(ReviewVO vo, Model model) {

		List<ReviewVO> list = dao.list(vo);
		model.addAttribute("list", list);
	}

	@RequestMapping("rList2")
	public void list2(Model model) {

		List<ReviewVO> list = dao.listAll();

		model.addAttribute("list", list);
	}

	

	@RequestMapping("rOne")
	public void one(ReviewVO vo, Model model) {
		// 게시물 1개짜리 vo2
		// replyList
		ReviewVO vo2 = dao.one(vo);
		model.addAttribute("one", vo2);

//		List<ReviewVO> list = dao2.list(vo);
//		model.addAttribute("list", list);
	}

	@RequestMapping("rInsert")
	public void insert(ReviewVO vo, Model model, HttpSession session) {
		int result = dao.insert(vo);
		ReviewVO vo2 = dao.createdId();
		
		System.out.println(vo2);
		String text = "게시물 작성 성공";
		if (result != 1) {
			text = "게시물 작성 실패";
		}
		model.addAttribute("result", text);
		model.addAttribute("rId", vo2.getrId());
	}

	@RequestMapping("rDelete")
	public void delete(ReviewVO vo, Model model) {
		int result = dao.del(vo);
		model.addAttribute("result", result);
	}

	@RequestMapping("rUpdate")
	public void update(ReviewVO vo, Model model) {
		// 수정하기 버튼을 누르면, 기존의 db에 저장된 데이터를
		// 가지고 와서, 수정할 수 있는 화면에 넣어 주어야 한다.
		ReviewVO vo2 = dao.one(vo);
		model.addAttribute("one", vo2);
	}

	@RequestMapping("rUpdate2")
	public String update2(ReviewVO vo, Model model) {
		// 수정하고 싶은 것이 있으면 수정처리 요청
		int result = dao.up(vo);
	
		if (result == 1) {
			return "rUpdate2";
		} 
		else {
			return "no";
		}

	}
}