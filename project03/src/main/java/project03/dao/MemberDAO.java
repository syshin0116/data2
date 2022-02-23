package project03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project03.db.DataBase;
import project03.vo.MemberVO;
/*
 * Member Database Access Object
 * */
public class MemberDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private DataBase database= null;
	
	public MemberDAO() {
		database = new DataBase();
	}
	
	/**
	 * generic 표기법
	 * 내가 원하는 객체를 리스트에 담으려고 확정 짓기위해 사용.
	 * 회원의 목록을 가져오는 함수
	 * @return
	 */
	
	public List <MemberVO> member_list(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		con = database.getConnection();
		//----member을 select해서 MemberVO 객체에 데이터를 담은 후 List에 하나씩 추가한다.
		
		String query = "SELECT * FROM member ORDER BY m_idx ASC";
		
		try {
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
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public void insert(MemberVO memberVO) {
		String query = "INSERT INTO member(m_id, m_pw, m_name, m_email, m_phone, m_mdfydate, m_rgstdate)"
				+ " VALUES ( ?,?,?,?,?,'null',systimestamp)";
		try {
			pstmt= con.prepareStatement(query);
			pstmt.setString(1, memberVO.getM_id());
			pstmt.setString(2, memberVO.getM_pw());
			pstmt.setString(3, memberVO.getM_name());
			pstmt.setString(4, memberVO.getM_email());
			pstmt.setString(5, memberVO.getM_phone());
		
			
			if(pstmt.executeUpdate()>0) {
				System.out.println(memberVO.getM_name()+"유저가 등록되었습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(pstmt !=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public MemberVO view(int M_idx) {
		MemberVO memberVO = new MemberVO();
		String query= "SELECT * FROM member WHERE m_idx=?";
		
		try {
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
				memberVO.setM_mdfydate(rs.getTimestamp("m_mdfydate"));
				memberVO.setM_rgstdate(rs.getTimestamp("m_rgstdate"));
			} else {
				System.out.println("원하는 유저가 없습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
		return memberVO;
	}
	public void update(MemberVO memberVO) {
		String query = "UPDATE member SET m_id = ?, m_pw = ?, m_name =?, m_email=?, m_phone=?, m_mdftdate=systimestamp"
				+ " WHERE m_idx=?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberVO.getM_id());
			pstmt.setString(2, memberVO.getM_pw());
			pstmt.setString(3, memberVO.getM_name());
			pstmt.setString(4, memberVO.getM_email());
			pstmt.setString(5, memberVO.getM_phone());
			pstmt.setInt(6, memberVO.getM_idx());

			
			if(pstmt.executeUpdate()>0) {
				System.out.println(memberVO.getM_name()+"유저 정보를 수정했습니다.");
			}else {
				System.out.println("원하는 유저가 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void delete(int M_idx) {
		MemberVO memberVO = new MemberVO();
		
		String query = "DELETE FROM member WHERE m_idx = ?";
		try {
			String username = memberVO.getM_name();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, M_idx);
			if(pstmt.executeUpdate()>0) {
				System.out.println("유저"+username+"이 삭제되었습니다.");
			}else {
				System.out.println("원하는 유저가 없습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
