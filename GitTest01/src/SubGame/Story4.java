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
		Util.println(" ");
		System.out.println();
		Util.println("1) 넵! 제가 하겠습니다!! 2) 제 일이 끝나면 생각해보겠습니다... 3) 제가요? ");
		
		
		int choice = sc.nextInt();
		
			
		switch (choice) {
		case 1:
			Util.println("경험치 증가! 하지만 나의 스트레스는 쌓인다.. -.-zzz");
			// 경험치는 증가하지만 스트레스 증가
			dao.updateUser(exp + 20, stress + 20);
			break;
		
		case 2: 
			Util.println("이렇게 말하면 안되는 거였나,,, 스트레스...");
			// 경험치는 변화 없지만 스트레스 감소
			dao.updateUser(exp, stress - 20);
			break;
		case 3:
			Util.println("너무 mz같았나.. 스트레스다!!");
			dao.updateUser(exp, stress - 20);
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
