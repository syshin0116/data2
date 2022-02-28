package com.cgv.mvc;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieDAO {

	@Autowired
	SqlSessionTemplate my; //의존성주입(DI)
	
	public List<MovieVO> mvList() {
		return my.selectList("mv.list");
	}
	public MovieVO mvOne(MovieVO vo) {
		return my.selectOne("mv.one", vo);
	}
	public int mvDel(MovieVO vo) {
			return my.delete("mv.del", vo); 
			
	}
	public int mvIn(MovieVO vo) {
		return my.insert("mv.in", vo);
	}
	public int mvUp(MovieVO vo) {
		return my.update("mv.up", vo);
	}
	public double mvRating(MovieVO vo){
		System.out.println("2=====  " + vo);
		System.out.println("selectOne:"+my.selectOne("mv.selectRating", vo));
		double result = 0;
		if(my.selectOne("mv.selectRating",vo)==null) {
			result=0;
		}else {
			result = my.selectOne("mv.selectRating", vo);
		}
		return result;
	}
}
