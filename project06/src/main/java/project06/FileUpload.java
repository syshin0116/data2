package project06;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request, response);
		
	}
	public void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		File currentDirPath = new File("c://file_repo");
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath); //������ ����Ǵ� ���丮 ���
		factory.setSizeThreshold(1024*1024);//���� �뷮 ����
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List items = upload.parseRequest(request);
			
			//÷������ �Ӹ� �ƴ϶� �� ������(text)�� ���۵ȴ�.
			for(int i=0;i<items.size();i++) {
				FileItem fileItem = (FileItem) items.get(i);
				if(fileItem.isFormField()) { // �Ϲ� �Ķ�̤������� ����. �Ϲ� �Ķ���Ͷ�� true
					//�Ϲ� text �Ķ����
					System.out.println(fileItem.getFieldName()+"="+fileItem.getString("utf-8"));
				}else { 
					// ÷������ �Ķ����
				}
				System.out.println("�Ķ���͸�:"+fileItem.getFieldName());
				System.out.println("���ϸ�:"+fileItem.getName());
				System.out.println("����ũ��:"+fileItem.getSize()+"bytes");
				System.out.println("÷������Ÿ��:"+fileItem.getContentType());
				
				System.out.println(fileItem.getName().lastIndexOf("\\"));
				System.out.println(fileItem.getName()+"");
				if(fileItem.getSize()>0) {
					int idx=fileItem.getName().lastIndexOf("\\");
				
					if(idx == -1) {
						idx=fileItem.getName().lastIndexOf("\\");
						fileItem.getName().indexOf("\\"); 
					}
						String fileName=fileItem.getName().substring(idx+1);
						System.out.println("filename:"+fileName);
						File uploadFile = new File(currentDirPath+"\\"+fileName);
						//�߰�����
						if(uploadFile.exists()) {//����������ġ�� �ش� �̸��� ÷�������� �ִٸ�
							int fileName_idx=fileName.lastIndexOf(".");
							
							SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
							Calendar c= Calendar.getInstance();
							String strToday = sdf.format(c.getTime());
							String new_fileName = fileName.substring(0, fileName_idx)+"_"+strToday+fileName.substring(fileName_idx);
							
							File uploadFile_new = new File(currentDirPath+"\\"+new_fileName);
							fileItem.write(uploadFile_new);
						}else {
							fileItem.write(uploadFile);//���丮�� ����
						}
						
					
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/result");
	}
}
