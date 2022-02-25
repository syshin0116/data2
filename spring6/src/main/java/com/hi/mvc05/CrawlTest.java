package com.hi.mvc05;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CrawlTest {

	public static void main(String[] args) {
		//1. 사이트에 연결
		//2. html문서를 받아온다. (http응답)
		//3. 조건을 주어 추출하고자 하는 위치를 찾아서 해당 노드를 가지고 온다.
		//	 결과는 list자료구조를 사용
		//   기존에 있는 ArrayList를 재사용해서 기능으 ㄹ더 붙혀놓은 Elements(상속)
		String url = "https://finance.naver.com/item/main.naver?code=035720";
		
		try { 
			Document doc = Jsoup.connect(url).get();
			//System.out.println(doc);
//			Elements list = doc.select("span.code");
//			System.out.println(list);
//			System.out.println(list.get(0).text());
			
			Elements list2 = doc.select("table > tbody > tr:nth-child(1) > td.first span.blind");
			System.out.println(list2.size());
			System.out.println(list2.get(0).text());

			Elements list3 = doc.select("table > tbody > tr:nth-child(1) > td:nth-child(2) span.blind");
			System.out.println(list3.size());
			System.out.println(list3.get(0).text());
			
			String today = list2.get(0).text();
			String[] s = today.split(","); //{"95","000"}
			String today2 = String.join("", s); //"95000"
			int today3 = Integer.parseInt(today2);
			
//			Elements list3 = doc.select("em.date");
//			System.out.println(list3);
//			System.out.println(list3.get(0).text());
		} catch (IOException e) {
			System.out.println("크롤링하는 중 에러발생");
			e.printStackTrace();
		} //1,2번
		
	}

}
