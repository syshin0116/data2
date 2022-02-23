package web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.MemberDAO;
import web.vo.MemberVO;

@WebServlet("/memberView")
public class MemberViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		if(session.getAttribute("user_id") == null) {
			response.sendRedirect("login.jsp");
		}else {
		MemberDAO memberDAO = new MemberDAO();
		int user_idx = Integer.parseInt(request.getParameter("m_idx"));
		
		MemberVO memberVO = memberDAO.member_view(user_idx);
		request.setAttribute("member_view", memberVO);
		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsp/memberView.jsp");
		dispatch.forward(request,response);
		}
	}
	

}
