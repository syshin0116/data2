package com.cgv.mvc;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {

	@Autowired
	MovieDAO mvDao;
	@Autowired
	ReviewDAO rDao;

	@RequestMapping("mvList")
	public void list(MovieVO vo, ReviewVO vo2, Model model, HttpSession session) {
		// db Review 데이블에서 VO 받아옴
		List<MovieVO> list = mvDao.mvList(); //모든 table data 가져옴
		int[] movieIdList = new int[list.size()];//mvId개수에 따른 배열 movieIdList 생성
		for(int i = 0; i < list.size(); i++) {//mvId값 배열에 넣음
			movieIdList[i] = list.get(i).getMvId();
		}
		System.out.println("1===============");
		HashMap<Integer, Double> result = new HashMap<Integer, Double>(); //mvId:rRating 넣을 해쉬맵 result 생성
		for (int i = 0; i < movieIdList.length; i++) { // mvId값 마다
			vo.setMvId(movieIdList[i]);//
			System.out.println("mvDao.mvRating:"+mvDao.mvRating(vo));
			double avg = mvDao.mvRating(vo);
			result.put(movieIdList[i], avg);
		}
		System.out.println(result);
		//System.out.println("Controller: "+mvDao.mvRating(vo));
		
		
/*		List<ReviewVO> list2 = rDao.listAll();
		model.addAttribute("rList", list2);
		HashMap<Integer, Integer> result = new HashMap<>();
		System.out.println(list2);*/

		// db Movie 테이블에서 VO받아옴

		model.addAttribute("mvList", list);
	}

	@RequestMapping("mvOne")
	public void one(MovieVO vo, Model model, HttpSession session) {
		MovieVO vo2 = mvDao.mvOne(vo);
		model.addAttribute("one", vo2);
		session.setAttribute("mId", "root");
		System.out.println("vo2:"+vo2);
	}

	@RequestMapping("mvDel")
	public void delete(MovieVO vo, Model model) {
		int result = mvDao.mvDel(vo);
		model.addAttribute("mvResult", result);
	}

	@RequestMapping("mvIn")
	public void insert(MovieVO vo, Model model) {

		int result = mvDao.mvIn(vo);
		String text = "영화등록 성공";
		if (result != 1) {
			text = "영화등록 실패";
		}
		model.addAttribute("result", text);
	}

	@RequestMapping("mvUp")
	public void update(MovieVO vo, Model model) {
		MovieVO vo2 = mvDao.mvOne(vo);
		model.addAttribute("one", vo2);
	}

	@RequestMapping("mvUp2")
	public void update2(MovieVO vo, Model model) {
		// 수정하고 싶은 것이 있으면 수정처리 요청.
		int result = mvDao.mvUp(vo);
		String text = "영화수정 성공";
		if (result != 1) {
			text = "영화수정실패";
		}
		model.addAttribute("result", text);
		model.addAttribute("one", vo);
	}
}
