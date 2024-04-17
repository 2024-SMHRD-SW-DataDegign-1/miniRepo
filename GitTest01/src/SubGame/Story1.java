package SubGame;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import DB.DAO;
import DB.DTO;
import Util.Util;

public class Story1 {
	public void play() {

		DAO dao = new DAO();

		int exp1 = 1;
		int stress1 = 1;

		ArrayList<DTO> data = dao.searchUser();

		// 경험치
		int exp = data.get(0).getExp();
		int stress = data.get(0).getStress();
		Date firstTime = data.get(0).getFirstTime();
		Date lastTime = data.get(0).getLastTime();
		
		System.out.println("경험치 \t 스트레스 \t 생성시간 \t\t 현재시간");
		System.out.println(exp+" \t "+stress+" \t "+firstTime+" \t "+lastTime);

		Scanner sc = new Scanner(System.in);

		Util.println("===== 비상! 부장님이 찾아오셨다 =====");
		Util.println("부장님 : 자네 혹시 등산 좋아하나??");
		Util.println("맨날 앉아있으니 건강이 나빠지지 " + "등산을 해야 건강에도 좋고 어때 이번 주말에 같이 갈텐가?");
		Util.println("1. 등산 좋죠 같이 가시죠! 2. 저 주말에 약속이 있어서요..");

		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			Util.println("경험치 증가! 하지만 나의 스트레스는 쌓인다.. -.-zzz");
			// 경험치는 증가하지만 스트레스 증가
			dao.updateUser(exp + 20, stress + 20);
			break;
		
		case 2: {
			Util.println("가기 싫은 등산은 피했지만 부장님의 표정이 좋지 않다..");
			// 경험치는 변화 없지만 스트레스 감소
			dao.updateUser(exp, stress - 20);
			break;
		}
		
		}

	}

}