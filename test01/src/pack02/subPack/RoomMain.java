package pack02.subPack;

public class RoomMain extends Object{

	public static void main(String[] args) {
		//필요한 TV 2대 가져다 놔주세요
		TV myTV = new TV();
		TV yourTV = new TV();
		
		//첫번째 tv에 ch, vol, onOFF값 넣어주세요.
		myTV.ch = 7;
		myTV.vol = 9;
		myTV.onOff = true;
		
		//그림과 비교해주세요.
		
		// 전체 변수가 몇 개 생겼을까요??
		System.out.println(myTV);
		//생성된 객체의 주소를 가지고 멤버메서드를 호출할 수 있다.
		
		myTV.on(10);
		//2번째 tv에 멤버변수값을 넣어보고, 
		//멤버 변수를 프린트해보세요.
		//그림을 그려보세요!
		
		yourTV.ch = 9;
		yourTV.vol = 12;
		yourTV.onOff = true;
		System.out.println(yourTV);
		
		Mobile myMobile = new Mobile();
		System.out.println(myMobile);
		myMobile.power= true;
		myMobile.apps = 5;
		myMobile.memory = 10;
		myMobile.volume = 2;
		myMobile.color="빨강";
		myMobile.size= 10;
		myMobile.price= 5;
		myMobile.toString();
		myMobile.on(false);
		}

	

}
