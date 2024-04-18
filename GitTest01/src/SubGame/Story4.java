package SubGame;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import DB.DAO;
import DB.DTO;
import Util.Util;

public class Story4 {

	public void play() {
		Scanner sc = new Scanner(System.in);
		
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
		
		
		Util.println("경험치 \t 스트레스 \t 생성시간 \t\t 현재시간");
		Util.println(exp+" \t "+stress+" \t "+firstTime+" \t "+lastTime);
		
		
		// 그림 출력
Util.guideLine();	
String[] str =
{
	
	
};
String[] value = Util.setMiddle(str);
Util.print(value);
Util.guideLine();


		Util.println("==== 비상 !! 중요한 회의에 참석해야 하는데 준비가 아직 덜 됐다! ====");
		System.out.println();
		Util.println(" 혼자해결하기에는 빠듯할 거 같은데 상사에게 도움을 요청해야할까?! ");
		System.out.println();
		Util.println("1) 미리 상사에게 상황을 설명하고 도움을 구하자! 2) 회의 전까지 어떻게든 되겠지~! 좀 걱정되는데..?");
		
		
		int choice = sc.nextInt();
		
			
		switch (choice) {
		case 1:
			Util.println("휴~ 상사의 조언을 받아 성공적으로 회의를 마무리했다! 경험치 증가 ~! ");
			// 경험치는 증가
			dao.updateUser(exp + 20, stress);
			break;
		
		case 2: 
			Util.println(" ");
			// 경험치는 변화 없지만 스트레스 감소
			dao.updateUser(exp , stress + 20);
			break;
		}
		
	 return;
	
	
	 
	}
	   public void ClearConsole() {
	        try {
	           ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
	           Process startProcess = pb.inheritIO().start();
	           startProcess.waitFor();
	           
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	    }	
	
	
	
	
}
