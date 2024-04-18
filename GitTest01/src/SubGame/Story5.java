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

		DAO dao = new DAO();

		ArrayList<DTO> data = dao.searchUser();

		int exp = data.get(0).getExp();
		int stress = data.get(0).getStress();
		Date firstTime = data.get(0).getFirstTime();
		Date lastTime = data.get(0).getLastTime();

		Util.showState(dao.RankCache(), stress, exp);

		Util.guideLine();

		Util.println("경험치 \t 스트레스 \t 생성시간 \t\t 현재시간");
		Util.println(exp + " \t " + stress + " \t " + firstTime + " \t " + lastTime);

		Util.println(" 다음 날에 있는 중요한 회의에서 프로젝트 발표를 해야 하는데 준비가 덜 된 상황 ");
		System.out.println();
		Util.println("1) 나가려는 상사에게 상황을 설명하고 도움을 받는다. 2) 혼자서 준비를 완벽하게 마무리하려고 노력한다." + " 3) 준비가 덜 된 상태인 지금 그냥 끝내버린다.");

		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			Util.println("친절한 상사의 도움을 받아 회의 준비를 끝냈다 ^.^");
			dao.updateUser(exp, stress - 20);
			break;

		case 2:
			Util.println("혼자 준비하면서 많은 것을 배울 수 있지만 스트레스는 만땅 =_=");
			dao.updateUser(exp + 20, stress + 20);
			break;

		case 3:
			Util.println("뭐... 알아서 되겠지 O_O");
			dao.updateUser(exp, stress);
			break;
		}

		ClearConsole();

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
