package pack03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	//DAO: Data Access Object
	//CRUD(크루드)
	//회원가입(Create)
	//회원정보 검색, 로그인(Read)
	//회원정보 수정(Update)
	//회원탈퇴(Delete)
	public void create(MemberVO vo) throws Exception {
		System.out.println("dao에서 전달받은 값:" + vo);
		String id2 = vo.getId();
		String pw2 = vo.getPw();
		String name2 = vo.getName();
		String tel2 = vo.getTel();
		System.out.println("전달받은 id는  "+id2);
		System.out.println("전달받은 pw는  "+pw2);
		System.out.println("전달받은 name는  "+name2);
		System.out.println("전달받은 tel는  "+tel2);
		System.out.println("회원가입 처리 요청됨.");
		
		//1. connector 라이브러리 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. 드라이버/커넷터 설정 성공@@@");
		
		//2. db 연결: 1) ip+port, 2) user+pw 3) db명(big)
		String url = "jdbc:mysql://localhost:3366/big";
		String user = "root";
		String pass = "1234";
		Connection con = DriverManager.getConnection(url, user, pass);
		
		System.out.println("2. DB 연결 성공@@@");
		//3. sql 문을 생성
		String sql = "insert into member values (?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("3. SQL 객체 생성 성공.@@@");
		ps.setString(1, id2);
		ps.setString(2, pw2);
		ps.setString(3, name2);
		ps.setString(4, tel2);
		//4. 생성한 sql 문을 mysql로 보낸다
		ps.executeUpdate();
		System.out.println("4. SQL문 전송 성공.@@@");
	}
	public void login(MemberVO vo) {
		System.out.println("회원 로그인 처리 요청됨.");
	}
	public void readOne(MemberVO vo) throws Exception {
		System.out.println("회원정보 검색 요청됨.");
		
		String id2 = vo.getId();
	
		
		//1. connector 라이브러리 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. 드라이버/커넷터 설정 성공@@@");
		
		//2. db 연결: 1) ip+port, 2) user+pw 3) db명(big)
		String url = "jdbc:mysql://localhost:3366/big";
		String user = "root";
		String pass = "1234";
		Connection con = DriverManager.getConnection(url, user, pass);
		
		System.out.println("2. DB 연결 성공@@@");
		//3. sql 문을 생성
		String sql = "select * from member where id = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("3. SQL 객체 생성 성공.@@@");
		ps.setString(1, id2);

		//4. 생성한 sql 문을 mysql로 보낸다
		ResultSet rs = ps.executeQuery();
		
	}
	public void update(MemberVO vo) {
		System.out.println("회원정보 수정 처리 요청됨.");
	}
	public void delete(MemberVO vo) {
		System.out.println("회원탈퇴 처리 요청됨.");
	}
}
