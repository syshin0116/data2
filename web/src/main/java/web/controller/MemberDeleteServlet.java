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

@WebServlet("/memberDelete")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO memberDAO = new MemberDAO();
		int user_idx = Integer.parseInt(request.getParameter("m_idx"));
		MemberVO memberVO = memberDAO.member_view(user_idx);
		String user_name= memberVO.getM_name();
		System.out.println(user_name);
		System.out.println(memberVO.getM_name());
		memberDAO.member_delete(user_idx);
		
	
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		out.println("alert('"+user_name+"님이 삭제되었습니다')");
		out.println("location = '"+request.getContextPath()+"'");
		out.println("</script>");
	}

}
