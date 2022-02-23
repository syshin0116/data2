package pack02.subPack;

public class Mobile {
	boolean power;
	int volume;
	int memory;
	int apps;
	String color; //선언 전역변수(global), 변수의 자동 초기화
	//null로 초기화
	int size; //0으로 초기화 (int형의 초기값)
	int price; //0으로 초기화
	
	
	public void tel(String no) {
		System.out.println(no + "로 전화를 걸다.");
	}
	
	public void kakao(String name) {
		System.out.println(name + "과 카톡하다.");
	}
	
	public boolean on(boolean power){
		if(power==true) {
		System.out.println("핸드폰이 이미 켜져있습니다.");
		return true;
		}else {
			System.out.println("핸드폰이 켜졌습니다.");
			return true;
		}
	}

	public String toString() {
		return "휴대폰 [power=" + power + ", volume=" + volume + ", memory=" + memory + ", apps=" + apps + ", 색="
				+ color + ", 크기=" + size + ", price=" + price + "]";
	}
	
}
