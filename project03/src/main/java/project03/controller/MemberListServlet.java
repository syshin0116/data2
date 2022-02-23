package project03.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project03.dao.MemberDAO;
import project03.vo.MemberVO;

@WebServlet("/memberList")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		MemberDAO memberDAO = new MemberDAO();
		List<MemberVO> list = memberDAO.member_list();
		PrintWriter out = response.getWriter();
		
		
		String data="<html>";
		data+= "<style>";
		data+= "table{";
		data+= "width: 100%;";
		data+= "border-top: 1px solid #444444;";
		data+= "border-collapse: collapse;";
		data+= "}";
		data+= "th,td{";
		data+= "border-bottom: 1px solid #444444;";
		data+= "padding: 10px;";
		data+= "}";
		data+= "</style>";
		data+= "<body>";
		data+= "<table>";
		data+= "<tr>";
		data+= "<td>시퀀스</td>";
		data+= "<td>아이디</td>";
		data+= "<td>비밀번호</td>";
		data+= "<td>이름</td>";
		data+= "<td>이메일</td>";
		data+= "<td>핸드폰</td>";
		data+= "<td>수정일</td>";
		data+= "<td>등록일</td>";
		for(MemberVO memberVO:list) {
			/* MemberVO memberVO = (MemberVO)list.get(i); */
		data+= "<tr>";
		data+= "<td>"+memberVO.getM_idx()+"</td><td>"+memberVO.getM_id()+"</td>";
		data+= "<td>"+memberVO.getM_pw()+"</td><td>"+memberVO.getM_name()+"</td>";
		data+= "<td>"+memberVO.getM_email()+"</td><td>"+memberVO.getM_phone()+"</td>";
		data+= "<td>"+memberVO.getM_mdfydate()+"</td><td>"+memberVO.getM_rgstdate()+"</td>";
		data+= "</tr>";
		}
		data+= "</table>";
		
		
		data+= "</body>";
		data+= "</html>";
		out.print(data);
	}
}
