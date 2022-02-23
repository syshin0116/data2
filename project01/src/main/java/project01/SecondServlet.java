package project01;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet{
	
	SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss:mm");
	public void init() throws ServletException{

		System.out.println("init �޼ҵ� ȣ��");
		System.out.println("init ȣ��ð�: "+ sdf.format(System.currentTimeMillis()));

	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
	
		System.out.println("doGet �޼ҵ� ȣ��");
		System.out.println("doGet ȣ��ð�: "+ sdf.format(System.currentTimeMillis()));

	}
	public void destroy() {
	
		System.out.println("destroy �޼ҵ� ȣ��");
		System.out.println("Destroy ȣ��ð�: "+ sdf.format(System.currentTimeMillis()));

	}
}
