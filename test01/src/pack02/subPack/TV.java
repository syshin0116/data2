package pack02.subPack;

public class TV {
	//틀 만들 때 구성 요소
	//멤버 변수 (나중에 생성되는 객체의 속성값 저장용도)
	//객체 생성할 때 아래 3개의 변수가 복사
	int ch;
	int vol;
	boolean onOff;
	
	//tv를 가지고 할 동작(기능을 정의)
	public String on(int time) {
		System.out.println(time+"시에 TV를 킴.");
		return "ok";
	}
	public String toString() {
		return ch + ", "+ vol + ", " + onOff;
	}
}
