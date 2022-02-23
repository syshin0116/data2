package project02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String address = request.getParameter("address");

		
		System.out.println("아이디:" +user_id);
		System.out.println("패스워드:" +user_pw);
		System.out.println("주소:" +address);

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
		data+= "<td>아이디: </td><td>"+user_id+"</td><br>";
		data+= "</tr>";
		data+= "<tr>";
		data+= "<td>패스워드: </td><td>"+user_pw+"</td><br>";
		data+= "</tr>";
		data+= "<tr>";
		data+= "<td>주소: </td><td>"+address+"</td>";
		data+= "</tr>";
		data+= "</table>";
		data+= "</body>";
		data+= "</html>";
		out.print(data);
	}

}
