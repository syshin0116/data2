package pack02;

import java.util.Date;

import pack01.ReturnClass;

public class ReturnMain {

	public static void main(String[] args) {
		ReturnClass rc = new ReturnClass();
		System.out.println(rc);
		//자바에서는 객체지향형 언어이므로
		//그 기능을 담당하는 부품이 있어서
		//반드시 부품을 사용해야하는데,
		//부품의 주소가 필요하다.
		//생성된 객체의 주소!!!
		//특정한 기능을 사용하고 싶으면
		//주소만 있으면 된다.!!
		//반환이 없는 경우게는 결과값을 변수에 넣을 수도 없고, print할 수도 없다.
		rc.add(100);
		double sum1 = rc.add(22.1, 10);
		int sum2 = rc.add(22, 10);
		String sum3 = rc.add("나는", "프로그래");
		String sum4 = rc.add(10000, "만원입니다.");
		int[] x2 = rc.add();
		System.out.println(sum1);
		System.out.println(sum2);
		System.out.println(sum3);
		System.out.println(sum4);
		System.out.println(x2);
		System.out.println(x2[0]);
		System.out.println(x2[1]);
		System.out.println(x2[2]);
		
		Date date2 = rc.add2();
		System.out.println(date2.getHours());
		
	}
}
