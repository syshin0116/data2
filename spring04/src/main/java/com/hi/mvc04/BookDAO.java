package com.hi.mvc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO {
	//DAO: Data Access Object
	//CRUD(크루드)
	//회원가입(Create)
	//회원정보검색, 로그인(Read)
	//회원정보수정(Update)
	//회원탈퇴(Delete)
	public void create(BookVO vo) throws Exception {
		System.out.println("dao에서 전달받은 값:" + vo);
		String id2 = vo.getId();
		String urls2 = vo.getUrls();
		String name2 = vo.getName();
		String img2 = vo.getImg();
		
		System.out.println("전달받은 id는 " + id2);
		System.out.println("전달받은 urls는 " + urls2);
		System.out.println("전달받은 name는 " + name2);
		System.out.println("전달받은 img는 " + img2);
		
		System.out.println("회원가입 처리 요청됨.");
		
		//db프로그램 순서
		//1. connector라이브러리 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. 드라이버/커넥터 설정 성공@@@");
		
		//2. db 연결 : 1) ip+port, 2) user+urls, 3)db명(big)
		String url = "jdbc:mysql://localhost:3366/big";
		String user = "root";
		String pass = "1234";
		
		Connection con = DriverManager.getConnection(url, user, pass);
		
		System.out.println("2. db연결 성공@@@");
		
		//3. sql문을 생성
		String sql = "insert into book values (?, ?, ?, ?)";

		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("3. SQL객체 생성 성공.@@@");
		ps.setString(1, id2);
		ps.setString(2, name2);
		ps.setString(3, urls2);
		ps.setString(4, img2);
		
		//4. 생성한 sql문을 mysql로 보낸다.
		ps.executeUpdate();
		System.out.println("4. SQL문 전송 성공.@@@");
	}
	
	public BookVO readOne(BookVO vo) throws Exception {
		System.out.println("회원정보 검색 처리 요청됨.");
		System.out.println("dao에서 전달받은 값:" + vo);
		String id2 = vo.getId();
		System.out.println("전달받은 id는 " + id2);
		System.out.println("회원가입 처리 요청됨.");
		
		//db프로그램 순서
		//1. connector라이브러리 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. 드라이버/커넥터 설정 성공@@@");
		
		//2. db 연결 : 1) ip+port, 2) user+urls, 3)db명(big)
		String url = "jdbc:mysql://localhost:3366/big";
		String user = "root";
		String pass = "1234";
		
		Connection con = DriverManager.getConnection(url, user, pass);
		
		System.out.println("2. db연결 성공@@@");
		
		//3. sql문을 생성
		String sql = "select * from book where id = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("3. SQL객체 생성 성공.@@@");
		ps.setString(1, id2);
		
		//4. 생성한 sql문을 mysql로 보낸다.
		ResultSet rs = ps.executeQuery();
		//System.out.println("결과값 있는지 체크 결과는 >>" + rs.next());
		System.out.println("4. SQL문 전송 성공.@@@");
		BookVO vo2 = new BookVO();
		if(rs.next()) {
			String id = rs.getString("id");
			String urls = rs.getString("urls");
			String name = rs.getString("name");
			String img = rs.getString("img");
			vo2.setId(id);
			vo2.setUrls(urls);
			vo2.setName(name);
			vo2.setImg(img);
		}else {
			System.out.println("검색 결과 없음.");
		}
		return vo2;
		
	}
	public ArrayList<BookVO> readAll() throws Exception {
		System.out.println("회원전체 목록 검색 처리 요청됨.");
		System.out.println("회원정보 검색 처리 요청됨.");
		
		//db프로그램 순서
		//1. connector라이브러리 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. 드라이버/커넥터 설정 성공@@@");
		
		//2. db 연결 : 1) ip+port, 2) user+urls, 3)db명(big)
		String url = "jdbc:mysql://localhost:3366/big";
		String user = "root";
		String pass = "1234";
		
		Connection con = DriverManager.getConnection(url, user, pass);
		
		System.out.println("2. db연결 성공@@@");
		
		//3. sql문을 생성
		String sql = "select * from book";

		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("3. SQL객체 생성 성공.@@@");
		
		//4. 생성한 sql문을 mysql로 보낸다.
		ResultSet rs = ps.executeQuery();
		//System.out.println("결과값 있는지 체크 결과는 >>" + rs.next());
		System.out.println("4. SQL문 전송 성공.@@@");
		//가방들을 모을 저장공간을 만들어야 함.
		//배열은 적합하지 않음.
		ArrayList<BookVO> list = new ArrayList();
		while(rs.next()) {
			BookVO vo2 = new BookVO();
			String id = rs.getString("id");
			String urls = rs.getString("urls");
			String name = rs.getString("name");
			String img = rs.getString("img");
			vo2.setId(id);
			vo2.setUrls(urls);
			vo2.setName(name);
			vo2.setImg(img);
			list.add(vo2);
		}
		return list;
		
	}
	public void update(BookVO vo) throws Exception {
		System.out.println("회원수정 처리 요청됨.");
		System.out.println("dao에서 전달받은 값:" + vo);
		String id2 = vo.getId();
		String urls2 = vo.getUrls();
		String name2 = vo.getName();
		String img2 = vo.getImg();
		
		System.out.println("전달받은 id는 " + id2);
		System.out.println("전달받은 urls는 " + urls2);
		System.out.println("전달받은 name는 " + name2);
		System.out.println("전달받은 img는 " + img2);
		
		//db프로그램 순서
		//1. connector라이브러리 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. 드라이버/커넥터 설정 성공@@@");
		
		//2. db 연결 : 1) ip+port, 2) user+urls, 3)db명(big)
		String url = "jdbc:mysql://localhost:3366/big";
		String user = "root";
		String pass = "1234";
		
		Connection con = DriverManager.getConnection(url, user, pass); 
		
		System.out.println("2. db연결 성공@@@");
		
		//3. sql문을 생성
		String sql = "update book set img = ? where id = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("3. SQL객체 생성 성공.@@@");
		ps.setString(1,img2);
		ps.setString(2,id2);

		
		//4. 생성한 sql문을 mysql로 보낸다.
		ps.executeUpdate();
		System.out.println("4. SQL문 전송 성공.@@@");
	}
	public void delete(BookVO vo) throws Exception {
		System.out.println("회원탈퇴 처리 요청됨.");
		System.out.println("dao에서 전달받은 값:" + vo);
		String id2 = vo.getId();
		String urls2 = vo.getUrls();
		String name2 = vo.getName();
		String img2 = vo.getImg(); 
		
		System.out.println("전달받은 id는 " + id2);
		System.out.println("전달받은 urls는 " + urls2);
		System.out.println("전달받은 name는 " + name2);
		System.out.println("전달받은 img는 " + img2);
		
		
		//db프로그램 순서
		//1. connector라이브러리 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. 드라이버/커넥터 설정 성공@@@");
		
		//2. db 연결 : 1) ip+port, 2) user+urls, 3)db명(big)
		String url = "jdbc:mysql://localhost:3366/big";
		String user = "root";
		String pass = "1234";
		
		Connection con = DriverManager.getConnection(url, user, pass);
		
		System.out.println("2. db연결 성공@@@");
		
		//3. sql문을 생성
		String sql = "delete from book where id = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("3. SQL객체 생성 성공.@@@");
		ps.setString(1, id2);

		
		//4. 생성한 sql문을 mysql로 보낸다.
		ps.executeUpdate();
		System.out.println("4. SQL문 전송 성공.@@@");
	}
}