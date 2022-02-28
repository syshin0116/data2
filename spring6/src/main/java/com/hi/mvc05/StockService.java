package com.hi.mvc05;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
	@Autowired
	StockDAO dao;

	public void crawl(String code) {

		// 크롤링을 해서 db에 입력
		// dao.insert(vo);

		// 1. 사이트에 연결 요청(http요청)
		// 2. html문서를 받아온다.(http응답) 7000줄 코드를 받음.
		// 3. 조건을 주어 추출하고자 하는 위치를 찾아서 해당 노드를 가지고 온다.
		// 결과는 list자료구조를 사용
		// 기존에 ArrayList를 재사용해서 기능을 더 붙여놓은
		// Elements(상속해서 만들어 놓음.)
		String url = "https://finance.naver.com/item/main.naver?code="+code;

		try {
			Document doc = Jsoup.connect(url).get();

			
			Elements list5 = doc.select("#middle > div.h_company > div.wrap_company > h2 > a");
			if(list5.size()!=0) {
			String company = list5.get(0).ownText();// 회사이름

			Elements list2 = doc.select("div.today span.blind");

			String today = list2.get(0).text();
			String[] s = today.split(","); // {"95","000"}
			String today2 = String.join("", s); // "95000"
			int today3 = Integer.parseInt(today2); // 오늘가

			Elements list3 = doc.select("table > tbody > tr:nth-child(1) > td:nth-child(2) span.blind");
			String yesterday = list3.get(0).text();
			String[] y = yesterday.split(","); // {"95","000"}
			String yesterday2 = String.join("", s); // "95000"
			int yesterday3 = Integer.parseInt(yesterday2);

			Elements list4 = doc.select("td.first span.blind");
			String high = list4.get(0).text();
			String[] h = high.split(","); // {"95","000"}
			String high2 = String.join("", h); // "95000"
			int high3 = Integer.parseInt(high2);

			// 1. 크롤링한 5개의 값을 vo에 넣어야 함.
			StockVO vo = new StockVO();
			vo.setCode(code);
			vo.setCompany(company);
			vo.setHigh(high3);
			vo.setToday(today3);
			vo.setYesterday(yesterday3);

			System.out.println(vo);
			
			// 2. DAO에 vo을 주면서 insert해달라고 요청함.
			dao.insert(vo);
			}
		} catch (IOException e) {
			System.out.println("크롤링하는 중 에러발생…");
			e.printStackTrace();
		} // 1,2

	}
}
