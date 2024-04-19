package MainGame;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import DB.DAO;
import DB.DTO;
import Util.Util;

public class 구구단게임 { // 1

	private int mCount;
	private int[] num1 = new int[5];
	private int[] num2 = new int[5];

	public 구구단게임() {
		super();
		Random ran = new Random();
		this.mCount = mCount;
		for (int i = 0; i < 5; i++) {
			num1[i] = ran.nextInt(100) + 1;
			num2[i] = ran.nextInt(10) + 1;
		}
	}

	public int getmCount() {
		return mCount;
	}

	public void setmCount(int mCount) {
		this.mCount = mCount;
	}

	public boolean play() {
		Random ran = new Random();
		for (int i = 0; i < 5; i++) {
			num1[i] = ran.nextInt(100) + 1;
			num2[i] = ran.nextInt(10) + 1;
		}
		
		DAO dao = new DAO();

		ArrayList<DTO> data = dao.searchUser();

		// 경험치
		int exp = data.get(0).getExp();
		int stress = data.get(0).getStress();

		String timeline = data.get(0).getTimeline();
		
		int people = -1;

		Scanner sc = new Scanner(System.in);


		boolean isNum = true;

		int correct = 0;
		int wrong = 0;
		int mLife = 2;

		for (int i = 0; i < 5; i++) {
			Util.showState(dao.RankCache(), stress, exp,timeline);

			Util.guideLine();
			String[] str = {
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿",
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿",
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠛⠛⠻⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⠿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿",
"⣿⣿⣿⣿⣿⣿⣿⡿⠿⠛⠛⠛⠿⣿⣿⠋⠀⠀⠀⠀⠀⠀⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠛⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠁⠀⠀⠀⠀⠀⠈⠻⣿⣿⡿⠟⠛⠛⠻⠿⣿⣿⣿",
"⣿⡟⠛⠛⢿⡿⠉⠀⠀⠀⠀⠀⠀⠈⢿⡀⠀⣠⣾⣿⡆⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠁⠀⠀⣠⡿⠿⠿⠿⠿⠿⠿⢿⣿⡏⠀⠀⠀⣴⣿⣦⠀⠀⠀⡿⠃⠀⠀⠀⠀⠀⠀⠀⠙⣿",
"⣿⠀⠀⠀⢸⡇⠀⠀⢠⣶⣶⠀⠀⠀⠘⣿⣿⣿⠟⠛⠁⠀⢀⣼⣿⣿⣿⠏⠁⠉⣿⣿⣿⣿⣿⣿⠿⠿⠿⠿⠿⠿⣿⣿⠏⠀⠀⢀⣼⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣄⠀⠀⠙⠛⠋⠀⠀⣰⠇⠀⠀⢰⣾⣿⣷⠀⠀⠀⢸",
"⣿⠀⠀⠀⢸⣧⣤⣴⣿⣿⡿⠀⠀⠀⢰⣿⣿⣇⠀⠀⠀⠀⠙⢿⣿⣿⠋⠀⠀⢠⣿⣿⣿⣿⠏⠀⠀⠀⠀⠀⠀⠀⢸⠇⠀⠀⠀⠉⠀⠁⠐⢶⣶⣶⣶⣶⠂⠀⠀⣰⠋⠀⠀⢀⣀⠀⠀⠈⠻⡀⠀⠀⠘⣿⣿⡿⠀⠀⠀⢸",
"⣿⠀⠀⠀⢸⣿⣿⣿⡿⠋⠀⠀⠀⣠⠟⠛⢿⣿⣿⣷⣦⠀⠀⠀⣿⠏⠀⠀⢠⣿⣿⣿⣿⣿⠀⠀⠀⣴⣶⣶⣶⣶⡏⠀⠀⠀⣠⣴⣤⠀⠀⠀⢹⣿⡿⠁⠀⠀⣰⠇⠀⠀⢰⣿⣿⣷⠀⠀⠀⢹⣄⠀⠀⠀ ⠀⠀⠀⠀⣾",
"⣿⠀⠀⠀⢸⣿⣿⠟⠁⠀⠀⢀⣴⣿⡀⠀⠀⠙⠿⠟⠃⠀⠀⢀⠏⠀⠀⣰⣿⠇⠀⠀⢹⣿⠀⠀⠀⠉⠉⠉⠛⢿⡅⠀⠀⠰⣿⣿⣿⡇⠀⠀⢸⡿⠁⠀⠀⣰⣿⡄⠀⠀⠈⠿⠿⠏⠀⠀⠀⢸⣿⣿⣶⣦⡶⠂⠀⠀⣼⣿",
"⣿⠀⠀⠀⢸⡿⠁⠀⠀⠀⠠⠿⠿⠿⠷⣄⠀⠀⠀⠀⠀⢀⣠⠎⠀⠀⠰⠿⠟⠀⠀⠀⠸⠿⣀⣀⣀⣤⣤⠀⠀⠀⢱⡀⠀⠀⠉⠛⠋⠀⠀⠀⡼⠁⠀⠀⣰⣿⣿⣷⣄⡀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⡿⠋⠀⠀⢀⣼⣿⣿",
"⣿⠀⠀⠀⢸⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣽⣿⣿⣷⣾⣿⣿⣏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣹⣿⣿⣿⣿⡇⠀⠀⠀⣿⣦⣄⣀⠀⢀⣀⣤⡞⠁⠀⠀⣰⣿⣿⣿⣿⣿⣿⣿⣶⣶⣶⣿⣿⣿⣿⣿⣿⣇⠀⠀⣠⣾⣿⣿⣿",
"⣿⠀⠀⠀⣸⣿⣶⣶⣶⣶⣶⣶⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣶⣶⣶⣾⡇⠀⠀⢰⠟⠉⠛⠿⣿⠟⠀⠀⠀⢰⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿",
"⣿⣷⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠀⣼⣆⡀⠀⠀⠀⠀⠀⢀⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿",
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣶⣶⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿",
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿",
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿"
			};
			String[] value = Util.setMiddle(str);

			System.out.println();
			System.out.println();
			
			Util.print(value);

			System.out.println();
			System.out.println();
			Util.guideLine();

			int idx = 0;

			Util.println("====구구단을 외자! 구구단을 외자~!==== ... 기회는 5번!! 목숨은 2개!! ");
			if (i < 5) {
				Util.print(" 문제 : " + num1[i] + " X " + num2[i] + "  \t  정답은?  ");
				people = sc.nextInt();

				if (people > 0) {

					int result = num1[i] * num2[i];
					if (people == result) {
						Util.println(">>>> 축하해요 정답입니다~!^-^ <<<<");
						correct++;
						// Util.println("계속하려면 엔터키를 누르세요...");
						// sc.nextLine(); // 사용자 입력 대기
					} else {
						Util.println(">>>> 아쉽게 틀렸네요ㅠ.ㅠ <<<<\t( 정답: " + result + " )");
						Util.println("남은 목숨 : " +(mLife-1)+"개");
						wrong++;
						mLife--;
						// Util.println("계속하려면 엔터키를 누르세요...");
						// sc.nextLine(); // 사용자 입력 대기
					}

				}
				if (mLife == 0) {
					isNum = false;

					// Util.println("맞춘 개수 : " + correct);
					// Util.println("틀린 개수 : " + wrong);
					
					Util.println("========= !!!게임 종료!!! ========= " +" <" + " 맞춘 개수: " + correct + " , " + "틀린 개수: " + wrong + " >" );
					Delay(1000);
					ClearConsole();
					return isNum;
				}
				// sc.nextLine();
				if (i != 4) {
					Delay(1000);
					ClearConsole();
				}
			}

		}
		if (isNum == true) {
			Util.println("========= !!!게임 종료!!! ========= " +" <" + " 맞춘 개수: " + correct + " , " + "틀린 개수: " + wrong + " >" );
			Delay(1000);
			ClearConsole();
		}
		return isNum;

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