package SubGame;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import DB.DAO;
import DB.DTO;
import Util.Util;
public class Story2 {

	// 콘솔창의 가로 길이 120 세로길이 30 인데 그중에 상태창이 차지하는 세로길이는 3 그림이 차지하는 세로길이는 22(구분선포함)
	// 스토리 혹은 문제 출력하는 세로길이가 5 입니다.
	
	
		// 내 업무가 밀려있는 상황에서 상사가 자신의 업무를 대신해주길 부탁한다.
//		1. 넵! 제가 하겠습니다!
//		  (경험치 상승. 스트레스 상승)
//		2. 제 일이 끝나면 생각해보겠습니다!
//		  (스트레스 상승)
//	    3. 제가요?
//	       (경험치 마이너스)
	
	public void play() {

		// DB 관련
		DAO dao = new DAO();
		
		// 경험치와 스트레스를 수정하는 방법
		//dao.updateUser(0, 0);
		
		// 사용자 정보를 불러오는 방법
		// updateUser(상승시킬exp, 상승시킬stress);
		ArrayList<DTO> data = dao.searchUser();
		
		// 경험치
		int exp = data.get(0).getExp();
		int stress = data.get(0).getStress();
		Date firstTime = data.get(0).getFirstTime();
		Date lastTime = data.get(0).getLastTime();
		
		System.out.println("경험치 \t 스트레스 \t 생성시간 \t\t 현재시간");
		System.out.println(exp+" \t "+stress+" \t "+firstTime+" \t "+lastTime);
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("==== 비상 !! 옆자리 상사가 서류파일을 가지고 다가온다!! ====");
		System.out.println();
		System.out.print("상사 : 혹시 지금 많이 바빠요?");
		System.out.print(" 내가 일이 밀려있는데 이것 좀 대신해줄 수 있어요?");
		System.out.println();
		System.out.print("1) 넵! 제가 하겠습니다!! 2) 제 일이 끝나면 생각해보겠습니다... 3) 제가요? ");
		
		
		int choice = sc.nextInt();
		
			
		if(choice ==1 ) {
			System.out.print("상사의 호감을 얻어 경험치 증가에 성공했습니다!");			
			dao.updateUser(exp+20, stress);
		}else if(choice ==2 ) {
			System.out.print("찝찝해서 스트레스가 상승한다 :(");
			dao.updateUser(exp, stress+20);
		}else {
			System.out.print("너무 MZ같은 답변이었나,,, 후회된다.. 스트레스 ㅠ.ㅠ");
			dao.updateUser(exp, stress+20);
		}
		
		
	 return;
	
	}
	
}
