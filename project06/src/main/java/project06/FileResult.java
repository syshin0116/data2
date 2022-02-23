package project06;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class FileResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파일이 저장되있는 폴더
		File files = new File("c:\\file_repo");
		//저장된 폴더 안에 있는 모든 파일정보를 가져옴
		File arrayfiles[] = files.listFiles();
		ArrayList<Map<String,String>> list = new ArrayList<Map<String, String>>();
		for(File fname: arrayfiles) {
			//가져온 파일명을 담을 객체(VO)
			Map<String, String> map = new HashMap<String,String>();
			map.put("filename", fname.getName());//finame:파일명
			list.add(map);
		}
		request.setAttribute("file_list", list);
		RequestDispatcher dispatch = request.getRequestDispatcher("/result.jsp");
		dispatch.forward(request, response);
	}
}
