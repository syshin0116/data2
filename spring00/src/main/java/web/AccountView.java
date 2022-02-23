package web;

import javax.swing.JOptionPane;

public class AccountView {

	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("name 입력");
		String title = JOptionPane.showInputDialog("title 입력");
		int price = Integer.parseInt(JOptionPane.showInputDialog("price 입력"));

		
		//제어부분(control)
		//가방을 만들어서 입력데이터를 가방에 넣어주자
		AccountVO bag= new AccountVO();
		bag.setName(name);
		bag.setPrice(price);
		bag.setTitle(title);
		
		//db에 넣는 처리-DAO에게 가방에 넣어서 전달
		AccountDAO dao = new AccountDAO();
		dao.create(bag); 

	}

}
