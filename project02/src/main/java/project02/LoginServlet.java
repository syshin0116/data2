package project02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet ("/login")
public class LoginServlet extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3241031767719890867L;

	public void init() throws ServletException{
		System.out.println("intit 메서드 호출");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		doHandler(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		doHandler(request, response);
	}
	public void destroy(){
		System.out.println("destroy 메서드 호출");
	}
	private void doHandler(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String address = request.getParameter("address");

		
		System.out.println("아이디:" +user_id);
		System.out.println("패스워드:" +user_pw);
		System.out.println("주소:" +address);

	}
}
