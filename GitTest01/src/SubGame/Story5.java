package SubGame;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import DB.DAO;
import DB.DTO;
import Util.Util;

public class Story5 {

	public void play() {
		Scanner sc = new Scanner(System.in);
		// DB 관련
		DAO dao = new DAO();
		// 경험치와 스트레스를 수정하는 방법
		// dao.updateUser(exp1, stress1)

		// 사용자 정보를 불러오는 방법
		// updateUser(상승시킬exp, 상승시킬stress)
		ArrayList<DTO> data = dao.searchUser();

		// 경험치
		int exp = data.get(0).getExp();
		int stress = data.get(0).getStress();
		Date firstTime = data.get(0).getFirstTime();
		Date lastTime = data.get(0).getLastTime();
		String timeline = data.get(0).getTimeline();
		
		Util.showState(dao.RankCache(), stress, exp ,timeline);

		// 그림
		Util.guideLine();
		String[] str = { "⡱⣧⢻⡼⣝⢮⣫⢮⡻⣜⡽⣮⡳⣵⣫⢞⡽⡺⣵⡫⣞⣝⢮⣫⢮⡻⣪⠷⣵⡫⣞⡽⡺⣵⡫⣞⠽⠊⠁⠀⠈⠓⠫⠞⢮⢫⢗⢟⠼⠝⠊⠉⠀⠙⢮⡻⣪⠷⣵⡫⣞⡽⡺⣵⡫⣞⣝⢮⣫⢮⡻⣪⠷⣵⡫⣞⢽⢮⣫⢗⢯⡻",
				"⣽⡪⡷⣝⢮⣳⣝⢮⡻⢮⢞⡮⣞⡵⣳⣝⡽⣹⢮⢞⡵⣝⢧⡻⠎⠙⠁⠈⠈⠉⠊⠙⠙⠈⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠳⢻⡪⣯⢺⣝⢽⡪⡾⡵⣝⢧⡻⣎⢯⡳⣻⡪⣯⡺⣳⡫⣮⡫⡷⣝",
				"⢮⡻⣜⢷⢝⡮⣞⡵⣫⢟⡵⣫⢮⣫⣞⡼⡺⣵⣫⡻⣪⡻⡎⠃⠀⠀⠀⠀⠀ ⠀⢀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⠋⠚⠑⠋⢟⡼⣳⢝⢾⣕⢯⡻⣜⠷⣵⢫⣗⢽⣪⡻⣎⢷",
				"⢷⣝⢮⡳⡯⣞⡵⣝⢷⢝⡮⣯⢳⡳⣮⢝⡽⢶⢵⡫⠗⠁⠀⠀⠀⠀⢰⣤⣦⣤⣴⣿⣿⣿⣤⣦⣴⣤⡄⠀⠀⠀⠀⠐⣿⣾⣾⣷⣷⣿⣾⣶⣠⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠈⠻⣪⢯⡳⣵⡫⣗⢽⡫⣞⡵⣝⢷⢕⣯⢺⢧",
				"⡵⣳⣝⡽⡺⣎⢷⣝⢮⡻⡺⣮⡳⣽⣪⡻⣚⠗⠉⠀⠀⠀⠀⠀⠀⠀⣙⣛⣛⣛⣿⣿⣿⣿⣟⣛⣛⣛⠃⠀⠀⠀⠀⠈⠉⠉⠉⠉⣽⣿⣿⡿⠿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠺⢝⡮⣳⢝⢷⡝⣮⡻⣜⢗⡯⣺⡳⣫",
				"⣝⢮⡺⣎⣟⢮⡳⣝⡵⣫⢟⡼⠺⠎⠊⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⠿⠿⠿⠟⠛⠙⠛⠿⠿⠿⡿⡇⠀⠀⠀⠀⢀⣀⣀⣤⣾⣿⣿⢿⣶⣶⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣁⡿⣱⢯⡺⣕⢯⣫⢾⡕⣯⢞",
				"⡷⣝⡽⣪⢞⢷⣝⢮⣫⢗⢷⠶⡶⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠂⠀⠀⠀⢸⣿⣿⠿⠿⠛⠁⠈⠉⠋⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣫⡻⣜⢷⡹⣳⡫⣞⡵⣫⢾⢕",
				"⢽⢮⡝⡷⣹⢧⡳⣯⢺⣝⡳⣻⢺⣕⢟⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢁⣨⣤⣥⣿⣿⣿⣿⣵⣥⣬⣄⠁⠀⠀⠀⠀⠀⢰⣶⣷⣾⣾⣷⣿⣾⣶⣶⣶⣶⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣜⢵⢯⢞⡽⣪⢟⡼⣝⢮⡳⣯",
				"⣪⣗⢽⡺⣳⢝⣮⡳⣝⢮⣫⡳⣏⢾⣕⢯⠆⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⣟⣉⣉⣉⣉⣛⣻⣿⣿⡇⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠉⠉⠉⠉⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣠⣈⣞⢷⡹⣳⢝⢷⢝⢾⡕⣯⡳⣝",
				"⢵⡝⣮⢻⢮⡳⡵⡻⡮⣳⣝⢮⡳⣗⣝⢗⣡⣠⣄⣄⣠⣀⡀⠀⠀⠀⠈⠛⠿⠿⠿⠿⡿⠿⠿⠿⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠿⠿⠿⠇⠀⠀⠀⠀⠀⠀⣠⣞⢽⣝⡵⣝⡵⣫⣞⡝⣷⡹⣳⡫⣗⡽⣪⢯⡺",
				"⣫⢞⢷⡹⣧⢻⣝⣝⠾⣵⡹⣳⢝⡮⣞⣝⢷⢕⢷⣝⡵⣫⡻⣻⡳⡶⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡾⣣⢟⢮⡞⣮⡳⡽⢮⡮⣫⢮⡻⡼⣝⢮⣫⢗⡽⣝",
				"⢷⣹⡳⣝⡮⣳⢵⡝⡯⣮⢻⣪⡻⣎⢷⡹⣮⡫⡷⣪⢷⡝⣽⡪⣯⡺⡵⣝⢷⢦⣀⣠⡤⣤⢦⣴⣤⣤⣤⣀⣀⠀⠀⠀⠀⠀⠀⣀⣠⢤⢖⡶⣺⣫⡻⣛⣟⢟⣟⢟⡗⣷⡹⣳⢝⡷⣹⢮⣝⣝⢗⣝⢷⢝⣮⢻⣎⢷⣝⡵⣫⢮",
				"⡳⣵⡫⣮⣫⢗⡽⣎⢿⡜⡷⡵⣫⣞⢽⣪⢗⡽⣺⢵⡳⣝⡮⣳⢵⣛⢾⢕⡯⣳⣝⢮⣞⢵⣛⢶⡕⡷⡵⣫⣝⢟⢶⣄⣠⢶⢞⣵⡫⣞⢯⡺⣕⢷⡝⣽⡪⡯⣮⢻⣜⢧⡻⣵⡫⡾⡵⣳⢵⣝⢽⣪⢗⡯⣞⢵⡳⣳⢵⡝⡷⣝",
				"⢜⣗⢽⡣⣟⢮⡻⣜⢷⢕⣧⢻⣕⢟⠊⠓⠙⠊⢳⠑⢋⠚⠊⠋⠊⢛⠘⢙⡧⣻⢮⠓⠑⠋⢾⡃⠛⣜⢯⠈⢱⢯⡚⠙⡪⠚⠙⠓⢹⠊⠋⣞⢽⣕⢯⡋⠚⣝⡞⠑⢑⡯⠓⠙⠊⠓⠙⢷⣝⡽⣹⢮⣫⢗⡽⡮⣳⣝⢮⡮⣳⢽",
				"⢵⣫⢞⡽⣪⢷⣝⢮⡳⣯⡺⡵⣝⡻⣤⡄⠀⣤⣝⠀⠸⡄⠀⣄⠀⣬⠀⢨⡟⣮⡓⠀⢦⡄⠐⡇⠀⡆⠀⠀⠀⠀⡇⠀⣧⢤⣄⠀⢨⡃⠀⣟⢮⣞⢽⠂⠀⢯⣏⠀⢨⡃⠀⢴⢴⡤⠄⠀⣷⢝⡧⣻⡜⣯⡺⣝⢮⣞⢵⡫⣗⡽",
				"⢝⡮⡻⣮⡳⣳⢵⡫⡷⣕⢟⣮⣫⢞⠷⠀⠀⠸⣧⠀⢘⡇⠀⡇⠀⣺⠀⠰⢏⢾⣕⠀⠙⠀⢐⡇⠀⣽⠋⠉⠉⢻⡆⠀⠞⢧⡯⠀⢘⠆⠀⣟⢮⡞⠁⢀⡀⠈⢱⠀⢨⣧⣄⣀⡀⣀⣠⣜⢗⢯⣞⡵⣫⣞⢵⣫⢗⡽⣕⢿⣜⡽",
				"⢟⡮⣻⣜⢽⣪⢗⡟⣮⣫⢗⡵⣳⡻⠀⣠⣆⡀⢰⠀⢨⡇⠀⡇⠀⢽⠀⢀⡰⣯⡺⠓⠐⠔⠛⠑⠄⡞⠀⢰⠆⠀⡇⠀⣀⣺⠇⠀⣸⠅⠀⣟⢮⢯⡔⠚⠛⢲⠜⠠⢦⠀⠀⠀⠀⠀⠀⠀⣽⢳⢮⣫⢞⡮⣳⣝⢮⢷⢝⡮⣞⢮",
				"⣻⢺⢵⣝⡵⣫⣞⢽⣪⢮⡻⣎⢷⢽⡎⠁⣹⡝⣷⣀⣔⠇⠀⠃⠀⢹⠀⢨⣟⢼⡝⠦⠢⠢⠆⠆⠀⣇⠀⢸⡃⠀⡇⠀⣯⠫⠀⠠⣾⡁⠀⣯⢳⣝⠧⠔⠀⢄⡄⢄⣐⠏⠉⠉⠉⠉⠉⢉⡷⣝⢧⣫⢷⣝⢮⢞⣗⣝⢷⢝⡮⣗",
				"⣳⡫⣗⢮⣳⢳⣝⢮⡳⣝⢾⢕⣟⢮⡇⠀⠘⠙⠊⠊⢓⠄⣄⠀⣄⠐⠀⠰⣏⢾⣝⠄⠠⠴⠤⠴⠤⢳⡀⠈⠀⣰⡇⠀⡆⢀⣤⢻⢞⡄⠀⣯⢳⣝⡇⠀⠦⠜⠀⠄⠨⡇⠀⠚⠒⠓⠀⠐⣟⢮⣳⡳⣳⢵⡫⡷⡵⣝⡮⣻⡪⣗",
				"⣮⢻⡪⣷⡹⡧⣻⡪⣟⢮⡳⣯⡺⡵⣧⣤⣤⣤⣤⣤⣬⢯⣫⡻⣝⢿⡤⣼⢝⢧⢷⣤⣤⣤⣤⣤⣤⣝⡻⣳⣫⢻⢦⣤⢟⡮⣳⡝⣯⢦⡤⣯⢳⡵⡧⣤⣤⡼⣤⡤⡾⣥⣤⣤⣤⣤⣤⡬⣯⡳⣵⡫⣗⢽⣎⢟⡮⣳⣝⢮⡻⣪" };
		String[] value = Util.setMiddle(str);

		Util.print(value);

		Util.guideLine();

		// 서브 이벤트
		Util.println(" ==== 보고서 결과물을 상사한테 전달한 후 나의 실수를 발견함 ====");

		Util.println("1) 상사에게 실수를 보고하고 같이 해결해본다.  2) 상사가 나에게 찾아와 내 실수가 맡냐고 물어본다.  3) 모른 척 한다.");

		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			Util.println("다행이다.. 한소리 들을 줄 알았는데 같이 도와주시네 ^.^");
			dao.updateUser(exp + 20, stress - 20);
			break;

		case 2:
			Util.println("하 욕은 욕대로 배불리 다 먹고.. 이거 또 언제 다 고쳐,,  =_=");
			dao.updateUser(exp, stress + 20);
			break;

		case 3:
			Util.println("뭐... 알아서 되겠지~~ O_O");
			dao.updateUser(exp, stress);
			break;
		}
		Delay(1000);
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

	public void Delay(int MilTime) {
		try {
			Thread.sleep(MilTime);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
