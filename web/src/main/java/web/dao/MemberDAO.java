package web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import web.vo.MemberVO;
/*
 * Member Database Access Object
 * <Resource name="jdbc/mariadb"
				auth="Container"
				type="javax.sql.DataSource"
				driverClassName="org.mariadb.jdbc.Driver"
				url="jdbc:mariadb://localhost:3306/mars"
				username="mars"
				password="p@ssword"
				maxActive="50"
				maxWait="-1"/>
 * */
public class MemberDAO {
	MemberVO memberVO = new MemberVO();

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private DataSource dataFactory;
	public MemberDAO() {
		try {
		Context ctx = new InitialContext();
		Context envContext = (Context) ctx.lookup("java:/comp/env");
		dataFactory = (DataSource)envContext.lookup("jdbc/mariadb");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * generic 표기법
	 * 내가 원하는 객체를 리스트에 담으려고 확정 짓기위해 사용.
	 * 회원의 목록을 가져오는 함수
	 * @return
	 */
	
	public List <MemberVO> member_list(){
		List<MemberVO> list = new ArrayList<MemberVO>();

		try {
			con = dataFactory.getConnection();
			//----member을 select해서 MemberVO 객체에 데이터를 담은 후 List에 하나씩 추가한다.
			String query = "SELECT * FROM member";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO memberVO = new MemberVO();
				
				memberVO.setM_idx(rs.getInt("m_idx"));
				memberVO.setM_id(rs.getString("m_id"));
				memberVO.setM_pw(rs.getString("m_pw"));
				memberVO.setM_name(rs.getString("m_name"));
				memberVO.setM_email(rs.getString("m_email"));
				memberVO.setM_phone(rs.getString("m_phone"));
				memberVO.setM_mdfydate(rs.getTimestamp("m_mdfydate"));
				memberVO.setM_rgstdate(rs.getTimestamp("m_rgstdate"));
				list.add(memberVO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}	
		return list;
	}
	
	
	/**
	 * generic 표기법
	 * 회원시퀀스에 해당하는 회원정보를 하나 가져오는 함수
	 * 회원의 목록을 가져오는 함수
	 * @return
	 */
	
	public MemberVO member_view(int M_idx){
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String query= "SELECT * FROM member WHERE m_idx=?";
			con = dataFactory.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, M_idx);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				memberVO.setM_idx(rs.getInt("m_idx"));
				memberVO.setM_id(rs.getString("m_id"));
				memberVO.setM_pw(rs.getString("m_pw"));
				memberVO.setM_name(rs.getString("m_name"));
				memberVO.setM_email(rs.getString("m_email"));
				memberVO.setM_phone(rs.getString("m_phone"));
				memberVO.setM_phone(rs.getString("m_file"));
				memberVO.setM_mdfydate(rs.getTimestamp("m_mdfydate"));
				memberVO.setM_rgstdate(rs.getTimestamp("m_rgstdate"));
			} else {
				System.out.println("원하는 유저가 없습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
					con.close();
					pstmt.close();
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}	
		return memberVO;
	}
	public void member_save(MemberVO memberVO) {
		
		String query = "INSERT INTO member(m_id, m_pw, m_name, m_email, m_phone, m_file)"
				+ " VALUES ( ?,?,?,?,?,?)";
		try {
			con = dataFactory.getConnection();
			pstmt= con.prepareStatement(query);
			pstmt.setString(1, memberVO.getM_id());
			pstmt.setString(2, memberVO.getM_pw());
			pstmt.setString(3, memberVO.getM_name());
			pstmt.setString(4, memberVO.getM_email());
			pstmt.setString(5, memberVO.getM_phone());
			pstmt.setString(6, memberVO.getM_file());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	public boolean idcheck(String m_id) {
		String query = "SELECT m_idx FROM member WHERE m_id=?";
		boolean idcheck = false;
		try {
			con = dataFactory.getConnection();
			pstmt = con.prepareStatement(query);
		    pstmt.setString(1, m_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				idcheck= true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return idcheck;
	}
	public void member_update(MemberVO memberVO) {
		

		try {
			con = dataFactory.getConnection();
			
			
			if(memberVO.getM_pw() ==null || memberVO.getM_pw().equals("")) {
				String query = "UPDATE member SET m_name =?, m_email=?, m_phone=?, m_mdfydate=now()"
						+ " WHERE m_idx=?";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, memberVO.getM_name());
				pstmt.setString(2, memberVO.getM_email());
				pstmt.setString(3, memberVO.getM_phone());
				pstmt.setInt(4, memberVO.getM_idx());
				pstmt.executeQuery();
			}else {
				String query = "UPDATE member SET m_pw = ?, m_name =?, m_email=?, m_phone=?, m_mdfydate=now()"
						+ " WHERE m_idx=?";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, memberVO.getM_pw());
				pstmt.setString(2, memberVO.getM_name());
				pstmt.setString(3, memberVO.getM_email());
				pstmt.setString(4, memberVO.getM_phone());
				pstmt.setInt(5, memberVO.getM_idx());
				pstmt.executeQuery();
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void member_delete(int M_idx) {

		String query = "DELETE FROM member WHERE m_idx = ?";
		try {
			con = dataFactory.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, M_idx);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
}
