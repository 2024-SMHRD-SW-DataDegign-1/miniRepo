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
		// 게임 종료 될 때 맞춘 개수보다 틀린 개수가 더 많으면 경험치 X 스트레스 O
		// 게임 종료 될 때 틀린 개수보다 맞춘 개수가 더 많으면 경험치 O 스트레스 X

		Scanner sc = new Scanner(System.in);
		Random ran = new Random();

		Util.print("===== 구구단을 외자~ 구구단을 외자! =====");
		boolean isNum = true;
		int correct = 0;
		int wrong = 0;
		int mLife = 2;
		for (int i = 0; i < 5; i++) {
			int first = ran.nextInt(100) + 1;
			int second = ran.nextInt(10) + 1;
			int result = first * second;

			System.out.print("문제: " + first + " X " + second + " = ");
			int people = sc.nextInt();

			if (people == result) {
				System.out.println("축하해요 정답입니다~~!^^");
				correct++;
				System.out.println();

			} else {
				System.out.println("아쉽게 틀렸네요 ㅠㅠㅠ \t (정답 : " + result + ")");
				wrong++;
				mLife--;
				System.out.println();
			}
			if (mLife == 0) {
				isNum = false;
				System.out.println("========== !!! 게임 종료 !!! ==========");
				break;
			}
		}
		System.out.println("맞춘 개수 : " + correct);
		System.out.println("틀린 개수 : " + wrong);

		return isNum;
	}

}
