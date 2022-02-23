package web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.MemberDAO;
import web.vo.MemberVO;

@WebServlet("/memberList")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		if(session.getAttribute("user_id") == null) {
			response.sendRedirect("login.jsp");
		}else {
		//---- Member라고하는 정보를 이용하는 오브젝트(객체)
		//----Member Data Access Object
		
		MemberDAO memberDAO = new MemberDAO();
		List<MemberVO> list = memberDAO.member_list();
		request.setAttribute("member_list",list);
		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsp/memberList.jsp");
		dispatch.forward(request,response);
		}
	}
}
