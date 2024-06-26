
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
		System.out.println();
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
		String timeline = data.get(0).getTimeline();
		
		  Util.showState(dao.RankCache(),stress, exp,timeline);
		
		
		// 그림 출력
Util.guideLine();	
String[] str =
{
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣶⢿⣿⣻⣿⣳⣄⢀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⢶⡿⣯⣷⡿⠿⠝⠟⠾⠟⣿⣿⣻⡿⣷⣆⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⣿⣟⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⢿⣽⣯⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢨⣿⢷⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⣾⣻⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ",
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⣿⣽⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀   ",
"⠀⠀⠀⠀⠀⠀⠀⠀⢀⣄⣲⠤⡠⢸⡅⠀⢀⠤⠢⢄⠀⣽⠀⠀⠨⣍⣍⣍⡧⠀⠀⠀⠀⠀⠀⠀⠀⠈⣷⠅⠰⣁⣀⣀⡀⢀⠀⠀⢠⠀⣀⣀⣀⣰⠀⠼⡟⠀⠀⠀⠀⠀⠀⠀⣤⠀⠀⢹⡀⠀⠢⠒⢴⠆⢸⢁⡀⣀⡐⣦⣀⡀⢝⠀⠀⢠⡠⠠⣄⠀⢽⠀⠀⠀⠀⠀",
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⠂⣑⠆⢘⡆⠀⠘⠥⡠⠜⠀⣞⠀⢀⣈⣓⡒⣒⢒⣂⡀⠀⠀⠀⠀⠀⠀⡰⡅⠂⢂⠹⣯⣟⣾⠎⢠⠀⠈⢺⣗⣯⣿⠣⠐⠐⡹⡄⠀⠀⠀⠀⠀⡰⢣⡀⠀⢸⠄⠀⣀⠖⠑⠦⠨⠃⠁⠀⡕⠓⣢⠀⡹⠴⠄⠀⢀⡼⡁⠀⣺⠀⠀⠀⠀⠀",
"⠀⠀⠀⠀⠀⠀⠀⠀⢠⣄⠽⠭⠤⢸⠆⠀⠤⠦⠐⠔⠒⣺⠀⠀⢐⣒⣒⣂⣖⠀⠀⠀⠀⠀⠀⠀⠀⢽⠀⡱⠠⠁⠀⠉⠀⠀⠰⠀⠀⠀⠈⠁⠀⠂⠌⡨⠢⡇⠀⠀⠀⠀⠔⠁⠀⠙⠀⢸⠂⠀⠀⠒⠒⠒⢸⠂⠀⠀⠫⠔⠊⠀⡺⠀⠀⠠⠊⠀⠙⠂⢼⠀⠀⠀⠀⠀ ",
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠨⠃⠀⠀⠀⠀⠀⠀⠚⠀⠀⠀⠳⠔⠴⠔⠆⠀⠀⠀⠀⠀⠀⠀⠸⢕⢐⠈⠀⠀⢀⢔⢂⠈⠀⠀⣒⢄⠀⠀⠈⡂⡐⡽⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⠁⠀⠀⠀⠀⠀⠘⠀⠀⠀⠀⠀⠀⠀⠊⠀⠀⠀⠀⠀⠀⠀⠙⠀⠀⠀⠀⠀    ",
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⢼⣗⠀⠀⠀⠥⣤⣬⢵⡴⣭⡤⡤⠁⠀⠀⠐⣿⢦⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ",
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣺⢯⣿⢽⡄⠀⠀⠀⠀⡏⠉⠉⠁⡋⠀⠀⠀⠀⣼⣻⣟⡾⡽⣧⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ",
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣶⣿⣟⢾⣺⢽⣺⣻⣟⡶⣄⡀⢸⠀⠀⠀⠀⢸⠀⢀⣤⢾⣻⣽⣺⢽⢽⣺⢽⣿⣶⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ",
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⣟⣷⢿⣺⢾⢽⣺⢽⣯⣗⢷⢯⢿⡌⢉⣼⢺⢲⣗⠉⢘⣿⢽⢽⣺⣳⡯⡯⣟⢾⢽⣺⣯⣿⣽⣶⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣟⣷⢿⣽⣟⢾⢽⢽⣺⢽⣺⣽⡽⡽⣯⠘⠁⢈⡷⣗⠁⠑⠃⣯⢯⣟⣾⣻⣺⢽⢽⢽⢽⣺⣺⣷⢿⡾⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ",
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣽⣯⣿⣻⣽⢾⣝⣯⣻⣺⢽⣺⣺⢽⣯⢷⠀⠀⢰⡫⣺⠀⠀⠀⣿⡽⣞⣗⢷⢽⢽⢽⢽⢽⣺⢵⣿⣻⣟⣿⡥⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀",
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣷⣻⣽⡯⣗⣗⣗⢷⢽⢽⣺⢽⢽⣺⣻⠀⠀⢸⣚⢞⠄⠀⠀⣿⣝⣗⡯⣯⢯⢯⡯⡯⣟⢾⢽⣽⣯⡿⣾⡧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀",	
};


String[] value = Util.setMiddle(str);
Util.print(value);
System.out.println();
Util.guideLine();


		Util.println(" 비상 !! 중요한 회의에 참석해야 하는데 준비가 아직 덜 됐다! ");
		Util.println(" 혼자해결하기에는 빠듯할 거 같은데 상사에게 도움을 요청해야할까?! ");
		System.out.println();
		Util.println("1) 미리 상사에게 상황을 설명하고 도움을 구하자! 2) 회의 전까지 어떻게든 되겠지~! 그래도 좀 걱정되는데..?");
		
		
		int choice = sc.nextInt();
		
			
		switch (choice) {
		case 1:
			Util.println("휴~ 상사의 조언을 받아 성공적으로 회의를 마무리했다! 경험치 증가 ~! ");
			// 경험치 증가
			dao.updateUser(exp + 20, stress);
			break;
		
		case 2: 
			Util.println("준비가 너무 안된채로 들어가버렸다 ㅠㅠ 내 잘못이지,, 스트레스 ㅠ.ㅠ");
			// 경험치는 변화 없지만 스트레스 상승
			dao.updateUser(exp , stress + 20);
			break;
		}
		
		Delay(2000);
		ClearConsole();
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
	   
	   public void Delay(int MilTime)
	   {
	      try
	      {
	         Thread.sleep(MilTime);
	         
	      }
	      catch(InterruptedException  e)
	      {
	         e.printStackTrace();
	      }
	   }
	
	
	
}
