package project03.vo;

import java.sql.Timestamp;

/*@author 승엽
member의 value object
변수와 값으로 이루어진 데이터 객체 
*/
public class MemberVO {
	
	private int m_idx; 				//시퀀스
	private String m_id;			//아이디
	private String m_pw;			//비밀번호
	private String m_name;			//아이디
	private String m_email;			//이메일
	private String m_phone;			//전화번호
	private Timestamp m_mdfydate;	//수정일
	private Timestamp m_rgstdate;	//등록일
	  
	
	 public int getM_idx() {
		return m_idx;
	}
	public void setM_idx(int m_idx) {
		this.m_idx = m_idx;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	public Timestamp getM_mdfydate() {
		return m_mdfydate;
	}
	public void setM_mdfydate(Timestamp m_mdfydate) {
		this.m_mdfydate = m_mdfydate;
	}
	public Timestamp getM_rgstdate() {
		return m_rgstdate;
	}
	public void setM_rgstdate(Timestamp m_rgstdate) {
		this.m_rgstdate = m_rgstdate;
	}
			
			 
	
}
