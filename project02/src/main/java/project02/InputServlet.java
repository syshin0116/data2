package project02;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/input")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init�޼��� ȣ��");
	}
	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		System.out.println("���̵�:"+user_id);
		System.out.println("��й�ȣ:"+user_pw);
		String[] subject = request.getParameterValues("subject");
		
		/*
		 * for(int i=0;i<subject.length;i++) { System.out.println("������ ����:"+subject[i]);
		 * }
		 */
		for(String str:subject) {
			System.out.println("������ ����:"+str);
		}
	}

}
