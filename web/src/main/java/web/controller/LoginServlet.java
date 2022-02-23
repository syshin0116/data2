package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.LoginDAO;
import web.dao.MemberDAO;
import web.vo.MemberVO;
/**
 * 
 * @author hi
 * 회원정보를 확인해서 아이디와 비밀번호를 사용하는 회원을 찾아 로그인 권한을 주는 Action
 * 로그인 권한 session에 아이디와 이름을 저장하는 회원으로 한다.
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//session 정보를 가져온다.
		HttpSession session = request.getSession();
		
		//login.html 파일에서 넘어온 파라미터를 저장
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		LoginDAO loginDAO = new LoginDAO();
		
		//로그인 처리를 하는 함수 생성
		int m_idx = loginDAO.login(user_id,  user_pw);
		
		//정상적인 회원정보가 있음
		if(m_idx>0) {
			MemberDAO memberDAO = new MemberDAO();
			MemberVO memberVO = memberDAO.member_view(m_idx);
		//Session에 로그인한 회원정보 표현	
			session.setAttribute("user_id", memberVO.getM_id());
			session.setAttribute("user_name", memberVO.getM_name());
			response.sendRedirect("memberList");
			
		// 그런 아이디와 비밀번호를 가진 회원이 없음
		}else {
			response.sendRedirect("login.jsp");
		}
		
	}

}
