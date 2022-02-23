package web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.MemberDAO;
import web.vo.MemberVO;
/**
 * 
 * @author hi
 * 회원가입 정보를 저장하는 Action
 */

@WebServlet("/memberSave")
public class MemberSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//login.html 파일에서 넘어온 파라미터를 저장
		request.setCharacterEncoding("utf-8");
		MemberDAO memberDAO = new MemberDAO();
		MemberVO memberVO = new MemberVO();
		
		memberVO.setM_id(request.getParameter("m_id"));
		memberVO.setM_pw(request.getParameter("m_pw"));
		memberVO.setM_name(request.getParameter("m_name"));
		memberVO.setM_email(request.getParameter("m_email"));
		memberVO.setM_phone(request.getParameter("m_phone"));
		memberVO.setM_file(request.getParameter("m_file"));
		memberDAO.member_save(memberVO);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		out.println("alert('"+memberVO.getM_name()+"님이 회원가입되었습니다')");
		out.println("location = '"+request.getContextPath()+"'");
		out.println("</script>");
	}

}
