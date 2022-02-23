package com.hi.mvc04;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			
			
		//1~100 <-- 0~99
//			System.out.println(r.nextInt(100)+1);
		//10~90 <--- 0~99
			System.out.println(r.nextInt(81)+10);
		}
	}
}
