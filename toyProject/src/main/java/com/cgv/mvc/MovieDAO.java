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
		return my.insert("mv.insert", vo);
	}
}
