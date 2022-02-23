package project05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String session_user_id = (String)session.getAttribute("user_id");
		if(session_user_id==null) {
			if(user_id.equals("korea") && user_pw.equals("12345")) {
				session.setAttribute("user_id",  user_id);
				out.println("로그인 되었습니다.");
			}else {
				out.println("아이디 패스워드를 다시 입력해주세요.");
			}
		}else {
			out.println("기존에 로그인 되었습니다.<a href='logout'>로그아웃</a>");
		}
	}

}
