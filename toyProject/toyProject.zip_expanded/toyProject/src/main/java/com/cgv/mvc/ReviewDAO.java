package com.cgv.mvc;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewDAO {

	@Autowired
	SqlSessionTemplate my;
	
	public ReviewVO createdId() {
		return my.selectOne("review.createdId");
	}
	
	public List<ReviewVO> listAll() {
		return my.selectList("review.all");
	}
	public List<ReviewVO> list(ReviewVO vo) {
		System.out.println("dao: " +  vo);
		return my.selectList("review.list", vo);
	}
	public ReviewVO one(ReviewVO vo) {
		return my.selectOne("review.one", vo);
	}
	public int insert(ReviewVO vo) {
		return my.insert("review.in", vo);
	}
	public int up(ReviewVO vo) {
		return my.update("review.up", vo);
	}
	public int del(ReviewVO vo) {
		return my.delete("review.del", vo);
	}
}