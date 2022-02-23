package pack03;

import javax.swing.JOptionPane;

public class BasicProcess1ex02 {

	public static void main(String[] args) {
		String id = JOptionPane.showInputDialog("ID를 입력해주세요");
		if (id.equals("root")) {
			JOptionPane.showMessageDialog(null, "맞아요!");
		} else {
			JOptionPane.showMessageDialog(null, "틀려요!");
		}
	}
}
