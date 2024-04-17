package Game;

import java.util.Random;
import java.util.Scanner;

import Util.Util;

public class 구구단게임 {

	private int mCount;

	public 구구단게임() {
		super();
		this.mCount = mCount;
	}

	public int getmCount() {
		return mCount;
	}

	public void setmCount(int mCount) {
		this.mCount = mCount;
	}

	public boolean play() {


		Scanner sc = new Scanner(System.in);
		Random ran = new Random();

		boolean isNum = true;

		
		for (int i = 0; i < 5; i++) {
			Util.showState("인턴", 40, 60);

			Util.guideLine();
			String[] str = { "⠄⠠⠀⠄⠠⠀⠄⠠⠀⠄⡠⢀⠄⠠⠀⠄⠠⠀⠄⠠⠀⠄⠠⠀⠄⠠⠀⠄⠠⠀⠄⠠⠀⠄⠠⠀⠄⠠⠀⠄⠠⠀⠄⠠⠀⠄⠠⠀⠄⠠⠀⠄⠠⠀⠄⠠⠀⠄⡀",
					"⠌⡀⠡⢈⠀⠡⠈⢄⣡⢖⡴⣲⡜⣦⢥⣌⠠⠁⡈⠄⠡⣈⣤⢳⡜⣧⣛⢾⡱⣏⠶⣥⣌⡄⠁⠌⡀⠡⢈⠠⠁⢌⣠⣡⣌⢦⡥⣬⢤⣡⡈⠠⢁⠈⠄⠁⠌⡐⢀",
					"⠄⠐⡀⠂⢈⢤⡻⣝⠮⢏⢾⡱⣝⢮⡳⣎⡟⣶⢠⣜⡳⣝⢮⡳⣝⢶⡹⣎⠷⣭⢛⠶⡭⢞⡽⢢⡐⢀⡢⠐⠋⠚⠡⠓⣮⢳⡝⣮⢳⣣⢟⡳⣆⠌⡀⠌⢀⠐⡀",
					"⠈⠄⡐⠈⠐⠋⠁⡈⠠⣀⠀⠿⣜⢧⡻⣜⡽⣜⡳⣎⢷⡹⣎⢷⡹⣎⢷⣹⠀⡀⠠⠀⠀⠄⠀⠁⡀⠄⠱⢀⠂⡀⠄⠀⣯⢳⡝⣮⢳⡭⣞⠵⣫⢛⣤⠐⠀⡐⠠",
					"⢀⠂⠄⠂⡁⡈⢄⠰⡀⠆⡄⠘⡽⣎⢷⡹⠶⣭⢳⡝⣮⢳⡝⣮⢳⡝⣮⢳⠀⡔⢢⢘⡐⠢⠜⠰⣈⠀⠣⠀⢎⠰⣁⠂⠉⠑⠘⢣⣟⡲⡍⠀⡀⢀⡀⠐⡠⠀⢂",
					"⡀⠘⡄⠣⠐⠡⠊⡐⢡⠊⡔⡀⠹⣎⢷⣹⡛⠌⠁⠉⠘⠃⠙⠊⠓⠹⠎⠷⠀⡜⢢⢣⠄⠀⡐⠀⢀⠠⠇⠘⣌⠣⢆⢣⠌⡴⠀⣹⠶⡹⠄⢘⡰⢡⠂⢨⡗⣦⡀",
					"⡇⣄⢤⡰⢦⡵⣂⠈⠆⡱⢠⢁⠀⠛⠮⡵⣋⠀⠥⡈⢄⡐⠠⡐⢀⠂⠤⢀⠀⣏⢧⡓⣎⢳⡱⣋⠶⠀⠌⢘⡬⢳⡍⠀⣉⣀⡁⠎⢁⠡⣠⠃⢆⡃⢆⡀⠙⢲⢳",
					"⡝⣮⠳⡝⠧⠏⠓⠀⠘⠀⢁⠠⠈⠐⡀⠸⣇⠀⡁⠘⠀⠌⠑⢌⠢⣉⠂⢠⣂⢈⡀⣉⠈⡁⠁⠉⠈⠐⠈⠰⣍⡳⡌⢀⡿⡜⣧⠄⠘⠢⠅⠚⠀⠘⢢⢉⠖⠀⣱",
					"⡝⠀⠁⡀⠄⡀⢂⠌⡠⠌⡄⢢⢁⠣⡐⠀⣹⠯⣝⡻⢞⠆⢈⠢⡁⢆⠁⢢⣏⢯⡝⣮⣛⡅⠐⣧⢳⡚⠀⣌⣄⣡⢠⡴⢫⡝⠎⢉⡀⠄⢠⢩⠙⣂⠀⠠⠐⠺⡵",
					"⢮⡀⠱⡀⢆⠱⠈⢆⠡⢊⠔⠁⣠⣠⠄⠠⠀⢀⠀⠈⠉⠀⡀⠃⠜⠠⠀⠛⢼⡣⢟⡲⣝⡆⠘⣦⠳⣍⠀⡘⠘⠂⠛⢸⢧⡻⠄⠲⣌⡙⢦⢡⠓⡤⣀⢂⡐⠀⣯",
					"⠾⣔⣀⣁⢤⡰⡄⠈⢆⠡⠊⠄⠐⣯⠀⢢⠑⠢⢌⡐⢢⠁⠤⡐⠠⢄⠂⠄⡸⣝⣫⠷⣭⠆⠘⡶⡹⣌⢥⡡⣍⡜⡠⢘⣧⢻⡤⠄⢀⡨⢤⠈⠌⣀⠁⠊⡐⠨⠁",
					"⠀⠈⠁⠛⠊⠳⢽⣀⣀⣂⡥⣴⢫⡞⣤⣄⣄⣡⠀⠘⠤⡉⠆⠁⢃⠈⠘⢀⡽⣎⢷⡹⣖⢇⡈⢁⠉⡈⢀⠉⡀⢉⢀⡸⣎⠷⡍⠀⣾⡹⡏⠋⠳⣦⠘⡄⠐⠀⠀",
					"⠀⠀⠀⠀⠀⠀⠘⣧⢻⣜⡳⣭⢳⡝⡶⣭⠞⣖⠀⠉⠂⠑⠂⡘⣷⡚⡷⣎⢷⡹⣎⢷⡹⢮⡝⠏⠻⣹⢏⡿⣹⢏⣏⠷⣭⢻⣅⠂⢻⣽⡳⣴⣺⡵⡧⠀⠌⠀⠀",
					"⢀⠀⠀⡀⠀⠀⡀⠈⠳⢎⡷⢭⡳⣝⡳⣎⠿⣜⣳⠳⠞⠂⠒⠹⢶⡹⢧⣛⢮⡳⣝⢮⡝⠧⠉⠀⠀⠀⠉⠘⠃⠛⠜⠛⠘⠃⠈⠐⢀⠈⠛⠑⠓⠉⠠⠘⠀⠀⠀",
					"⠀⠀⠄⠀⡀⠁⢀⠀⡀⢀⠈⠃⠙⠎⠳⢉⠛⠌⠁⠁⡀⠀⡀⠀⡀⠉⠁⠋⠊⠑⠉⠂⠈⠀⡀⠄⠀⠄⢀⠠⠀⢀⠀⠠⠀⠀⠄⠀⡀⠈⢀⠈⠀⠁⡀⠄⠀⡐⠈" };
			String[] value = Util.setMiddle(str);

			System.out.println();
			System.out.println();

			Util.print(value);

			System.out.println();
			System.out.println();
			System.out.println();
			Util.guideLine();

			int correct = 0;
			int wrong = 0;
			int mLife = 2;

			Util.println("===== 구구단을 외자~ 구구단을 외자! =====");
			int first = ran.nextInt(100) + 1;
			int second = ran.nextInt(10) + 1;
			int result = first * second;


			Util.print("문제: " + first + " X " + second + " = ");
			int people = sc.nextInt();
			
			if (people == result) {
				Util.println("축하해요 정답입니다~~!^^");
				correct++;
				 Util.println("계속하려면 엔터키를 누르세요...");
		            sc.nextLine(); // 사용자 입력 대기
			} else {
				Util.println("아쉽게 틀렸네요 ㅠㅠㅠ \t (정답 : " + result + ")");
				wrong++;
				mLife--;
				 Util.println("계속하려면 엔터키를 누르세요...");
		            sc.nextLine(); // 사용자 입력 대기
			}
			sc.nextLine();
			if (mLife == 0) {
				isNum = false;
				Util.println("========== !!! 게임 종료 !!! ==========");
				Util.println("맞춘 개수 : " + correct);
				Util.println("틀린 개수 : " + wrong);
				break;
			}
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

}
