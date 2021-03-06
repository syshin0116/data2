package web;

import javax.swing.JOptionPane;

public class MemberView {

	public static void main(String[] args) throws Exception {
		//입력화면
		String id = JOptionPane.showInputDialog("id 입력");
		String pw = JOptionPane.showInputDialog("pw 입력");
		String name = JOptionPane.showInputDialog("name 입력");
		String tel = JOptionPane.showInputDialog("tel 입력");
		
		//제어부분(control)
		//가방을 만들어서 입력데이터를 가방에 넣어주자
		MemberVO bag= new MemberVO();
		bag.setId(id);
		bag.setName(name);
		bag.setTel(tel);
		bag.setPw(pw);
		
		//db에 넣는 처리-DAO에게 가방에 넣어서 전달
		MemberDAO dao = new MemberDAO();
		dao.create(bag);
	}
	

}
