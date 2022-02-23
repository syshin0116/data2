package pack03;

import javax.swing.JOptionPane;

public class BasicProcess1ex03 {

	public static void main(String[] args) {
		String id = JOptionPane.showInputDialog("ID를 입력해주세요");
		String pw = JOptionPane.showInputDialog("PW를 입력해주세요");
		if(id.equals("root") && pw.equals("1234")){
			JOptionPane.showMessageDialog(null, "로그인 성공!");
		}else {
			JOptionPane.showMessageDialog(null, "로그인 실패!");
		}
	}
}
