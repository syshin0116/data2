package web;

public class AccountDAO {
	//CRUD
	//create 기능만 호출. vo만들어서 넣어서 전달, 확인
	public void create(AccountVO vo) {
		System.out.println("dao에서 전달받은 값:" + vo);
		String name = vo.getName();
		int price = vo.getPrice();
		String title = vo.getTitle();

		System.out.println("전달받은 name는  " + name);
		System.out.println("전달받은 title는  " + title);
		System.out.println("전달받은 price는  " + price);

		System.out.println("계좌개설 처리 요청됨.");
	}
	public void login(AccountVO vo) {
		System.out.println("계좌 로그인 처리 요청됨.");
	}
	public void read(AccountVO vo) {
		System.out.println("계좌정보 검색 요청됨.");
	}
	public void update(AccountVO vo) {
		System.out.println("계좌정보 수정 처리 요청됨.");
	}
	public void delete(AccountVO vo) {
		System.out.println("계좌삭제 처리 요청됨.");
	} 
}
