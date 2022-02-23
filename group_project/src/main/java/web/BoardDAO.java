package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class BoardDAO {

		
	
	public void create(BoardVO boardVo) throws Exception {
		
		String id = boardVo.getId();
		String title = boardVo.getTitle();
		String context = boardVo.getContext();
		//1. connector라이브러리 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. 드라이버/커넥터 설정 성공@@@"); 
		
		//2. db 연결 : 1) ip+port, 2) user+pw, 3)db명(big)
		String url = "jdbc:mysql://localhost:3366/big?Unicode=true&characterEncoding=utf-8";
		String user = "root";
		String pass = "1234";
		
		Connection con = DriverManager.getConnection(url, user, pass);

		//3. sql문을 생성
				String sql = "INSERT INTO boards (id, title, rgstdate, context) values(?, ?, now(), ?)";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, title);
		ps.setString(3, context);

		
		System.out.println("3. SQL객체 생성 성공.@@@");
				
		//4. 생성한 sql문을 mysql로 보낸다.
		ps.executeUpdate();
		System.out.println("4. SQL문 전송 성공.@@@");
	}
	public List<BoardVO> board_list() throws Exception{
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//1. connector라이브러리 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. 드라이버/커넥터 설정 성공@@@"); 
		
		//2. db 연결 : 1) ip+port, 2) user+pw, 3)db명(big)
		String url = "jdbc:mysql://localhost:3366/big?Unicode=true&characterEncoding=utf-8";
		String user = "root";
		String pass = "1234";
		
		con = DriverManager.getConnection(url, user, pass);
		String query = "select * from boards";
		pstmt = con.prepareStatement(query);
		rs = pstmt.executeQuery();
		
			while(rs.next()) {
				BoardVO boardVO = new BoardVO();
				
				boardVO.setIdx(rs.getInt("idx"));
				boardVO.setId(rs.getString("id"));
				boardVO.setTitle(rs.getString("title"));
				boardVO.setRgstdate(rs.getTimestamp("rgstdate"));
				boardVO.setMdfydate(rs.getTimestamp("mdfydate"));
				boardVO.setContext(rs.getString("context"));
				list.add(boardVO);
				}
			
					pstmt.close();
					rs.close();
					con.close();
				
		return list;
	}
	public BoardVO board_view(int m_idx) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		BoardVO boardVO = new BoardVO();
		
		//1. connector라이브러리 설정
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("1. 드라이버/커넥터 설정 성공@@@"); 
				
				//2. db 연결 : 1) ip+port, 2) user+pw, 3)db명(big)
				String url = "jdbc:mysql://localhost:3366/big?Unicode=true&characterEncoding=utf-8";
				String user = "root";
				String pass = "1234";
				
			con = DriverManager.getConnection(url, user, pass);

			// ����� ����
			String query = "SELECT * FROM boards WHERE idx = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, m_idx);
			rs = pstmt.executeQuery(); // ������ �����ϰ� ����� ResultSetdp ����
			
			if(rs.next()) {
				boardVO.setIdx(rs.getInt("idx"));
				boardVO.setId(rs.getString("id"));
				boardVO.setTitle(rs.getString("title"));
				boardVO.setRgstdate(rs.getTimestamp("rgstdate"));
				boardVO.setMdfydate(rs.getTimestamp("mdfydate"));
				boardVO.setContext(rs.getString("context"));
			}


		return boardVO;
	}
	
	public void update(BoardVO boardVO) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;	
		
		//1. connector라이브러리 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. 드라이버/커넥터 설정 성공@@@"); 
		
		//2. db 연결 : 1) ip+port, 2) user+pw, 3)db명(big)
		String url = "jdbc:mysql://localhost:3366/big?Unicode=true&characterEncoding=utf-8";
		String user = "root";
		String pass = "1234";
		
		con = DriverManager.getConnection(url, user, pass);

		System.out.println(boardVO.getIdx());
			
		if(boardVO.getTitle() == null || boardVO.getTitle().equals("")) {
			// ��й�ȣ ������ ����� ����
			String query = "UPDATE boards SET context = ?, mdfydate = now() WHERE idx = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, boardVO.getContext());
			pstmt.setInt(2, boardVO.getIdx());
			
			pstmt.executeUpdate();
		}
		else {
			// ��й�ȣ ������ ����� ����
			String query = "UPDATE boards SET title = ?, context = ?, mdfydate = now() WHERE idx = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, boardVO.getTitle());
			pstmt.setString(2, boardVO.getContext());
			pstmt.setInt(3, boardVO.getIdx());
			
			pstmt.executeUpdate();
		}
	}
	public void delete(int idx) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		
			// connection ó��
		//1. connector라이브러리 설정
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("1. 드라이버/커넥터 설정 성공@@@"); 
				
				//2. db 연결 : 1) ip+port, 2) user+pw, 3)db명(big)
				String url = "jdbc:mysql://localhost:3366/big?Unicode=true&characterEncoding=utf-8";
				String user = "root";
				String pass = "1234";
				
				con = DriverManager.getConnection(url, user, pass);
			
			// ����� ����
			String query = "DELETE FROM boards WHERE idx = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, idx);
			
			pstmt.executeUpdate();
		
		
		
	
		}
	
}
