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
 * ȸ�������� Ȯ���ؼ� ���̵�� ��й�ȣ�� ����ϴ� ȸ���� ã�� �α��� ������ �ִ� Action
 * �α��� ���� session�� ���̵�� �̸��� �����ϴ� ȸ������ �Ѵ�.
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//session ������ �����´�.
		HttpSession session = request.getSession();
		
		//login.html ���Ͽ��� �Ѿ�� �Ķ���͸� ����
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		LoginDAO loginDAO = new LoginDAO();
		
		//�α��� ó���� �ϴ� �Լ� ����
		int m_idx = loginDAO.login(user_id,  user_pw);
		
		//�������� ȸ�������� ����
		if(m_idx>0) {
			MemberDAO memberDAO = new MemberDAO();
			MemberVO memberVO = memberDAO.member_view(m_idx);
		//Session�� �α����� ȸ������ ǥ��	
			session.setAttribute("user_id", memberVO.getM_id());
			session.setAttribute("user_name", memberVO.getM_name());
			response.sendRedirect("memberList");
			
		// �׷� ���̵�� ��й�ȣ�� ���� ȸ���� ����
		}else {
			response.sendRedirect("login.jsp");
		}
		
	}

}
