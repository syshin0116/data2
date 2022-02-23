package web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.MemberDAO;
import web.vo.MemberVO;

@WebServlet("/memberUpdate")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberDAO memberDAO = new MemberDAO();
		MemberVO memberVO = new MemberVO();
		
		memberVO.setM_idx(Integer.parseInt(request.getParameter("m_idx")));
		memberVO.setM_pw(request.getParameter("m_pw"));
		memberVO.setM_name(request.getParameter("m_name"));
		memberVO.setM_email(request.getParameter("m_email"));
		memberVO.setM_phone(request.getParameter("m_phone"));
		memberDAO.member_update(memberVO);
		
		memberVO = memberDAO.member_view(Integer.parseInt(request.getParameter("m_idx")));
		request.setAttribute("member_view", memberVO);
		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsp/memberView.jsp");
		dispatch.forward(request,response);

	}
	

}
