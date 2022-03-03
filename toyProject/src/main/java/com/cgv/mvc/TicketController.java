package com.cgv.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;

@Controller
public class TicketController {

	@Autowired
	TicketDAO dao;
	
	@Autowired
	MovieDAO dao2;
	
	@RequestMapping("tInsert")
	public void insert(TicketVO vo) {
		System.out.println(vo);
		dao.create(vo);
		
	}
	
	@RequestMapping("tUpdate")
	public void update(TicketVO vo, Model model) {
		System.out.println(vo);
		dao.update(vo);
	}
	
	
	@RequestMapping("tDelete")
	public void delete(TicketVO vo) {
		System.out.println(vo);
		dao.delete(vo);
	}
	
	
	@RequestMapping("tOne")
	public void one(TicketVO vo, Model model) {
		TicketVO vo2=dao.one(vo);
		model.addAttribute("one", vo2);
		
	}
	
	@RequestMapping("tList")
	public void list(TicketVO vo, Model model) {
		System.out.println("컨트롤러 테스트");
		System.out.println(vo);
		List<TicketVO> list= dao.all(vo);
		model.addAttribute("list", list);
		
		MovieVO vo2=new MovieVO();
		List<MovieVO> list2 = new ArrayList<MovieVO>();
		for(int i=0;i<list.size();i++)
		{
			vo2.setMvId(list.get(i).getMvId());
			list2.add(dao2.mvOne(vo2));
			System.out.println(list2.get(i));
		}
		
		model.addAttribute("list2", list2);
	}
	
	@RequestMapping("tTime")
	public void time(MovieVO vo, Model model) {
		System.out.println(vo);
		MovieVO vo2= new MovieVO();
		vo2=dao2.mvOne(vo);
		
		String[] time=vo2.getMvTime().split(",");
		
		String json="{";
		for(int i=0;i<time.length;i++)
		{
			json=json+"\"time"+i+"\":\""+time[i]+"\"";
			if((i+1)!=time.length)
			{
				json=json+",";		
			}
		}
		json=json+"}";
		System.out.println("==================================JASON:"+json);
		model.addAttribute("times",json);
	}
	
	@RequestMapping("tSeat")
	public void seat(TicketVO vo, Model model) {
		//System.out.println(vo);
		
		List<TicketVO> list= dao.usedSeat(vo);
		
		int[] seats= new int[12];
		//System.out.println(seats.length);
		
		for(int i=0;i<12;i++)
		{
			seats[i]=0;
		}
		
		for(int i=0;i<list.size();i++)
		{
			seats[list.get(i).gettSeat()-1]=list.get(i).gettSeat();
		}
		
		model.addAttribute("seats", seats);
		model.addAttribute("time", vo.gettTime());
		model.addAttribute("mvId", vo.getMvId());
	
	}
	
	@RequestMapping("tSeat2")
	public void seat2(TicketVO vo, Model model) {
		System.out.println(vo);
		
		List<TicketVO> list= dao.usedSeat(vo);
		
		int[] seats= new int[12];
		//System.out.println(seats.length);
		
		for(int i=0;i<12;i++)
		{
			seats[i]=0;
		}
		
		for(int i=0;i<list.size();i++)
		{
			seats[list.get(i).gettSeat()-1]=list.get(i).gettSeat();
		}
		
		model.addAttribute("seats", seats);
		model.addAttribute("time", vo.gettTime());
		model.addAttribute("mvId", vo.getMvId());
		model.addAttribute("tId", vo.gettId());
	
	}
	
}
