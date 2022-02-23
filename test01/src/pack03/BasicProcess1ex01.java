package pack03;

import javax.swing.JOptionPane;

public class BasicProcess1ex01 {

	public static void main(String[] args) {
		String no1 = JOptionPane.showInputDialog("숫자1:");
		String no2 = JOptionPane.showInputDialog("숫자2:");
		int number1 = Integer.parseInt(no1);
		int number2 = Integer.parseInt(no2);

		if (number1 == number2) {
			JOptionPane.showMessageDialog(null, "동일해요!");
		} else {
			JOptionPane.showMessageDialog(null, "달라요!");
		}
	}
}
