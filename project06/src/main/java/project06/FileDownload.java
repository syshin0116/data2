package project06;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	public void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String file_repo = "C:\\file_repo";
		String fileName = (String)request.getParameter("fileName");
		OutputStream out = response.getOutputStream();
		String downFile = file_repo + "\\" + fileName;
		File f = new File(downFile);
		response.setHeader("Cache-Control", "no-cache");
		//�ѱ� ���ϸ� ��� �߰�
		fileName = URLEncoder.encode(fileName,"UTF-8");
		//---- �ѱ� ���ϸ� ���Ⱑ �Ǿ� �ִ� �κ��� URL Encoding���� ��ȯ
		fileName= fileName.replaceAll("\\+", "%20");
		response.addHeader("Content-disposition",  "attachement; fileName="+fileName);
		//response.addHeader("Content-disposition",  "attachement; fileName=aaa.jpg");
		FileInputStream in = new FileInputStream(f);
		byte[] buffer = new byte[1024*8];
		while(true) {
			int count = in.read(buffer);
			if (count == -1){
				break;
			}
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
	}
	
}
