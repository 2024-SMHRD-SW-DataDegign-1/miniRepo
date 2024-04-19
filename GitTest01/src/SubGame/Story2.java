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
		String timeline = data.get(0).getTimeline();
		
		  Util.showState(dao.RankCache(),stress, exp,timeline);
		
		// 그림 출력
Util.guideLine();	
String[] str =
{
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣀⣄⣄⠀⠀⠀⣀⣀⡀⠀⠀⠀  ",
"⠀⠀⠀⣤⣦⣶⣦⣄⠀⠀⠀⠀⠀⣀⠀⠐⡿⢟⠟⢟⢷⡄⢀⢰⣦⠀⠀⠀ ⣸⣿⠟⠟⠛⣷⡀⠀ ⠻⠛⠻⣦⠀  ",
"⠀⠀⠀⠉⠁⠀⣰⣿⡃⠀⠀⣷⡆⢽⣇    ⢽⣟  ⣿⡘⡕⢦⢦⠸⣧⣤⣤⣾⡿⠂⠀⠀ ⢀⣼⣿⠃⠀ ",
"⠀⢀⠠⠀⢀⣼⣿⠏⣐⣐⣤⣽⡯⢸⡷    ⡨⣿ ⢸⣿   ⣓⡑⣽⣙ ⣿⠆⠀⠀ ⢼⣿⠟⠁⠀⠀",
"⠀⠀⠀⣠⣿⡟⠳⣆⠨⠛⣋⢻⣯⠘⣿    ⢸⣿ ⠸⡟   ⡱⡕⢽⡇⠲⣿⣃⣀⡀⠀⠈⡁⠀⠁⠀",
"⠈⠀⢸⣿⠏⠀⠀⡬⠻⠦⢓⠜⣿⢡⠻⡎⡞⣎⢗⢬⢫⢸⢜⢵⣪⢮⡃⢶⣶⣾⢿⠿⠿⡻⣛⢏⡴⠘⠿⠀⠀⠀",
"⠄⠀⠀⠀⠀⠀⡸⠁⡜⣎⢗⡝⣬⠜⠾⣔⢵⢝⢮⣫⢮⡳⣝⢮⡺⣜⠞⡒⠦⣲⢲⡹⡱⡝⡽⡉⠁⠀⠀⠀⠀⠀",
"⠀⠀⢀⠠⠐⢨⠁⡸⣪⢺⢜⡾⠁⠀⠔⢳⡳⣕⢧⢳⡱⣕⣕⢧⣓⡟⠀⠈⠀⠈⢞⢼⡱⡝⣎⢗⡀⠀⠀⠀⠠⠀",
"⠀⠄⠀⠀⢠⠇⢀⢏⢮⢮⣛⠀⠀⠀⠀⠀⠫⡺⣎⢧⢳⡱⡮⣧⠏⠀⠀⠀⠀⠀⠈⣿⣪⡳⡕⣿⡄⠀⠀⠠⠀⠀",
"⠀⠀⠀⠀⡞⣜⠨⡳⡵⡿⠅⠀⠀⣀⣤⣥⣄⡈⠁⠻⣜⡞⠛⢡⢎⡾⠿⠽⣒⡄⠀⣿⣺⢎⢮⡇⠃⠀⠐⠀⠀⠀",
"⡀⠁⠀⠀⠉⡱⢘⢼⢽⣝⠀⠀⣺⠫⣓⡒⡲⡕⠀⠀⠈⠀⠀⠀⣃⠖⡒⢔⢢⢊⠀⢵⢏⠏⠋⣘⠂⢆⠀⠀⠀⠀",
"⠀⠀⠀⠀⠀⡸⠜⠕⢟⣖⠀⠀⢀⢞⢡⠮⢲⠩⡆⠀⢄⠀⠀⠐⡎⡪⢫⠽⡨⣺⠀⢼⡏⢴⣋⠁⠑⠀⢱⠀⠈⠀",
"⠀⠀⠀⠈⡼⠡⢤⡀⠘⣾⡀⠀⠨⡪⢌⢍⢉⣪⠇⠀⢀⠀⠀⠀⠙⠬⡢⡲⠼⠁⠀⢩⠂⠯⠼⠂⠀⠀⡜⠀⠀⠀",
"⠄⠈⠀⠠⡇⠀⢠⢞⡄⠸⡂⠄⠂⠈⠑⠓⠉⠀⠀⠀⠘⠂⠀⠀⠀⠀⠀⠠⠀⠄⠁⣀⠖⠢⣀⣀⣠⠖⠁⠀⠀⠀",
"⠀⠀⠀⠀⠣⡀⠈⠂⠁⢀⡀⠀⠠⠐⠀⡐⠀⠀⢀⠀⠂⠃⠀⡀⠐⠀⠀⢀⠀⣤⠖⠥⠤⢄⡀⠀⠀⠀⠀⠀⠐⠀",
"⠀⠠⠀⠀⠀⠑⠐⣦⠚⡊⠎⡓⣔⡴⣟⣿⠇⠀⠀⠀⠀⠀⡀⢀⣀⣤⢦⡶⣿⣻⣺⢁⠣⠡⢈⠒⡄⠀⠀⠀⠀⠀",
"⠁⠀⠀⠀⠠⠀⡞⡡⡮⣲⢟⣾⠽⢝⣗⡿⣽⣫⣗⢞⢺⣹⢫⢫⣺⡺⣽⢿⣻⡺⠣⡨⢘⠌⡠⢑⠌⢦⠀⠀⠁⠀",
"⠀⠀⢀⠠⠀⢸⡵⡧⣾⣺⢵⡿⡄⢅⠢⡙⣽⡾⣾⡵⣵⢫⢼⢽⢞⡿⡽⣟⣵⢯⣧⠨⡂⢅⠢⠡⡊⡴⠀⠀⠀⠀",

};
String[] value = Util.setMiddle(str);
Util.print(value);
Util.guideLine();


		Util.println("==== 비상 !! 옆자리 상사가 서류파일을 가지고 다가온다!! ====");
		Util.println("상사 : 혹시 지금 많이 바빠요? 내가 일이 밀려있는데 이것 좀 대신해줄 수 있어요? ");
		System.out.println();
		Util.println("1) 넵! 제가 하겠습니다!! 2) 제 일이 끝나면 생각해보겠습니다... 3) 제가요? ");
		
		
		int choice = sc.nextInt();
		
			
		switch (choice) {
		case 1:
			Util.println("경험치 증가! ^.^");
			// 경험치는 증가하지만 스트레스 증가
			dao.updateUser(exp + 20, stress);
			break;
		
		case 2: 
			Util.println("이렇게 말하면 안되는 거였나,,, 스트레스...");
			// 경험치는 변화 없지만 스트레스 감소
			dao.updateUser(exp, stress + 20);
			break;
		case 3:
			Util.println("너무 mz같았나.. 스트레스다!!");
			dao.updateUser(exp, stress + 20);
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
