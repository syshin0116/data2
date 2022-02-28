package com.cgv.mvc;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TicketDAO {

	@Autowired
	SqlSessionTemplate my;
	
	public void create(TicketVO vo) {
		my.insert("ticket.insert", vo);
	}
	
	public void update(TicketVO vo) {
		my.update("ticket.update", vo);
	}
	
	public void delete(TicketVO vo) {
		my.delete("ticket.delete", vo);
	}
	
	public TicketVO one(TicketVO vo) {
		return my.selectOne("ticket.one", vo);
	}
	
	public List<TicketVO> all(TicketVO vo) {
		return my.selectList("ticket.list", vo);
	}
	
	public List<TicketVO> usedSeat(TicketVO vo) {
		return my.selectList("ticket.seat", vo);
	}
}
