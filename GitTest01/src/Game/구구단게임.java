package Game;

import java.util.Random;
import java.util.Scanner;

import Util.Util;

public class 구구단게임 {

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

		int people = -1;

		Scanner sc = new Scanner(System.in);
		Random ran = new Random();

		boolean isNum = true;

		int correct = 0;
		int wrong = 0;
		int mLife = 2;

		for (int i = 0; i < 6; i++) {
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
					"⠀⠄⠀⡀⠁⢀⠀⡀⢀⠈⠃⠙⠎⠳⢉⠛⠌⠁⠁⡀⠀⡀⠀⡀⠉⠁⠋⠊⠑⠉⠂⠈⠀⡀⠄⠀⠄⢀⠠⠀⢀⠀⠠⠀⠀⠄⠀⡀⠈⢀⠈⠀⠁⡀⠄⠀⡐⠈" };
			String[] value = Util.setMiddle(str);

			System.out.println();
			System.out.println();

			Util.print(value);

			System.out.println();
			System.out.println();
			System.out.println();
			Util.guideLine();

			int idx = 0;
			if (people > 0) {

				int result = num1[i - 1] * num2[i - 1];
				if (people == result) {
					Util.println(">>>> 축하해요 정답입니다~!^-^ <<<<");
					correct++;
					// Util.println("계속하려면 엔터키를 누르세요...");
					// sc.nextLine(); // 사용자 입력 대기
				} else {
					Util.println(">>>> 아쉽게 틀렸네요ㅠ.ㅠ <<<< (이전 문제: " + num1[i - 1] + " X " + num2[i - 1] + "  정답: "
							+ result + ")");
					wrong++;
					mLife--;
					// Util.println("계속하려면 엔터키를 누르세요...");
					// sc.nextLine(); // 사용자 입력 대기
				}

			}
			if (mLife == 0) {
				isNum = false;
				Util.println("========= !!!게임 종료!!! =========" + " <" + " 맞춘 개수: " + correct + " , " + "틀린 개수: " + wrong
						+ " >");
				// Util.println("맞춘 개수 : " + correct);
				// Util.println("틀린 개수 : " + wrong);
				break;
			}

			Util.println("==== 구구단을 외자! 구구단을 외자! ====");

			Util.println("문제: " + num1[i] + " X " + num2[i] + " = ");
			people = sc.nextInt();

			// sc.nextLine();
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