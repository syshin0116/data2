package com.hi.mvc05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
	@Autowired
	StockDAO dao;

	
	public void crawl(String code) {
		//크롤링을 해서 db에 입력
		//dao.insert(vo);
	}
}
