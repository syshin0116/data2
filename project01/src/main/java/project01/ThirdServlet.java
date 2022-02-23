package project01;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/third")
public class ThirdServlet extends HttpServlet {


	 //�ڹ� ��ü ����ȭ ��� 
	 private static final long serialVersionUID = 4203167342058536067L;
	 
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:mm");

	public void init() throws ServletException {

		System.out.println("init �޼ҵ� ȣ��");
		System.out.println("init ȣ��ð�: " + sdf.format(System.currentTimeMillis()));

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doHandle(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LocalDateTime now = LocalDateTime.now();
		System.out.println("doHandle �޼��� ȣ��" + now);
	}

	public void destroy() {

		System.out.println("destroy �޼ҵ� ȣ��");
		System.out.println("Destroy ȣ��ð�: " + sdf.format(System.currentTimeMillis()));

	}
}
