package pack03;

import javax.swing.JOptionPane;

public class BasicProcess1 {

	public static void main(String[] args) {
		//기본 입출력
		String age = JOptionPane.showInputDialog("나이를 입력");
		int age2 = Integer.parseInt(age); // String-> int
		//기호 => 연산자
		//산술연산자, 비교연산자, 논리연산자
		
		System.out.println("내년 나이는 "+ (age2 + 1));
		JOptionPane.showMessageDialog(null, "내년 나이는 "+ (age2 + 1));
		
	}

}
