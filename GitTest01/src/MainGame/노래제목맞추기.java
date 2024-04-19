package MainGame;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import DB.DAO;
import DB.DTO;
import Util.Util;

public class 노래제목맞추기 {

	// 노래 가사 리스트(정답지)
	private String[][] mData;
	
	// 사용자 입력을 받기 위한 Scanner 객체 생성
	Random ran = new Random();
	Scanner mSc;

	String userInput;
	
	// 생성자
	public 노래제목맞추기() {
		initTextData();
	}

	 // 노래 가사 데이터 초기화
	   private void initTextData() {
	      // 가사 데이터를 초기화하는 코드를 작성합니다.
	      mData = new String[][] {
	            // TODO : 영어 제목의 노래를 집어넣어주세요!
	            { "Smarter baby, smarter", "하날 보면 열까지", "간파해서 돌파하지", "smart", "s____" },
	            { "낭비하지 마, 네 시간은 은행", "서둘러서 정리해, 걔는 real bad", "받아주면 안돼, no, you better trust me", "eta", "e__" },
	            { "Baby (baby), got me looking so crazy (crazy)", "빠져버리는 daydream (daydream)",
	                  "Got me feeling you 너도 말해줄래?", "hype boy", "h___ ___" },
	            { "힘껏 내팽개친 roses, 말론 안 통하지 역시 어쩜 이리 안 변해", "인정 같은 소린 됐고", "이쯤에서 끝내 let go 인내심도 out of space (space)",
	                  "maniac", "m_____" },
	            { "다친대도, 길을 걸어, kiss me", "쉽지 않음 내가 쉽게 easy", "Stage 위엔 불이 튀어 내 body", "easy", "e___" }, };

	   }
	
	
	public boolean play() {
		DAO dao = new DAO();
		ArrayList<DTO> data = dao.searchUser();
		// 경험치
		int exp = data.get(0).getExp();
		int stress = data.get(0).getStress();
		String level = dao.RankCache();
		String time = data.get(0).getTimeline();
		Util.showState(level,stress, exp, time);
		showConsole();

		// 승패 여부를 저장할 변수
		boolean isCorrect = false;

		// 목숨 갯수 초기화
		int life = 3;
		int[] arr = ranNum();

		for (int k = 0; k < 3; k++) {

			int temp = arr[k];

			// 현재 가사 인덱스
			int currentLyricIndex = 0;

			// 가사를 순서대로 알려주고 제목을 맞추는 게임 진행
			String randomLyric = mData[temp][currentLyricIndex];

			while (life > 0) {
				// 가사를 출력하여 사용자가 추측할 수 있도록 함
				if (currentLyricIndex == 0) {
					Util.println("가사: " + randomLyric);
				}
				if (life == 1) {
					Util.println("(힌트 : " + mData[temp][4] + ")");
				} else {
					Util.println("(힌트 : " + ")");
				}
				Util.print("노래 제목을 입력하세요: ");
				
				mSc = new Scanner(System.in);
				
				userInput = mSc.next();
				ClearConsole();

				System.out.println(userInput);
				showConsole();

				// 사용자 입력이 가사와 일치하는지 확인하여 정답 여부 결정
				// 여기서는 단순히 입력이 가사와 같으면 정답으로 처리
				if (userInput.equals(mData[temp][3])) { // "정답"은 실제 정답으로 대체되어야 합니다.
					Util.println(userInput);
					Util.println(mData[temp][3]);
					isCorrect = true;
					Util.println("정답입니다!");
					break;
				} else {
					Util.println(userInput);
					Util.println(mData[temp][3]);
					life--;
					Util.println("틀렸습니다. 남은 목숨: " + life);
					if (life == 0) {
						Delay(2000);
						return isCorrect;
					}
					currentLyricIndex++;
					if (currentLyricIndex < mData[temp].length - 2) {
						randomLyric = mData[temp][currentLyricIndex];
						Util.println("다음 가사: " + randomLyric);
					} else {
						Util.println("더 이상 가사가 없습니다. 정답은 \"" + mData[temp][3] + "\"입니다.");
					}
				}
			}
		}
		
		return isCorrect;
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
	
	public int[] ranNum() {
		// 1. 랜덤 도구 꺼내오기

		// 2. 정수형 데이터 3개를 보관할 수 있는 배열 선언
		int[] arr = new int[3];

		// 랜덤한 숫자 5개를 배열에 담을거야!
		for (int i = 0; i < arr.length; i++) {
			// 배열의 각 인덱스에 접근하여 랜덤한 숫자를 넣어주기!
			arr[i] = ran.nextInt(6)+1;

			// 중복되지 않는 숫자를 원해!
			// 현재 숫자와 배열 안에 들어 있는 숫자를 비교
			// 만약에 중복되는 숫자가
			//
			for (int j = 0; j < i; j++) {
				if (arr[j] == arr[i]) {
					i--;
					break;
				}
			}
		}
		return arr;
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
	
	private void showConsole() {
		Util.guideLine();
		String[] str1 = {
			"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⣴⣶⣿⣶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
			"⠄⠀⠂⠀⠐⠀⠀⠂⠀⠐⠀⠀⠂⠀⠐⠀⠀⠂⠀⠐⠀⠀⠂⠀⠐⢀⣠⣢⣶⣿⣿⣿⣿⣿⣿⣿⣯⠀⠀⠀⠄⠂⠀⠐⠀⠀⠂⠀⠐⠀",
			"⠀⠠⠀⠐⠀⠀⠁⠀⠐⠀⠀⠁⠀⠐⠀⠀⠁⠀⠐⠀⣀⣅⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⢿⣿⣟⠀⠀⠁⠀⠀⠠⠐⠀⠐⠀⠈⠀⢀",
			"⠀⡀⠠⠐⠀⠈⠀⠐⠀⠠⠈⠀⠀⠂⠀⠈⠀⠀⠂⣾⣿⣿⣿⣿⣿⣿⣿⣿⠿⠟⠋⠉⠀⡀⢼⣿⣿⠀⠀⠀⠂⠁⠀⠀⢀⠀⠄⠂⠀⢀",
			"⠀⠀⠀⠀⢀⠀⠂⠀⠄⠀⢀⠀⠁⠀⡀⠁⠀⠁⠀⣿⣿⣿⣿⠿⠛⠙⠉⠀⠀⠀⡀⠄⠁⠀⢸⣿⣷⠀⠀⠁⠀⢀⠠⠈⠀⠀⠀⠀⡀⠠",
			"⠀⢀⠐⠈⠀⠀⠀⠠⠀⠠⠀⠀⡀⠂⠀⠀⠂⠁⠀⣿⣿⡇⠀⠀⠀⡀⠄⠀⠄⠂⠀⠀⠀⢀⢸⣿⣿⠀⠀⠀⠁⠀⠀⠀⠀⡀⠂⠁⠀⠀",
			"⠀⠀⡀⠀⠀⠄⠈⠀⠀⠀⡀⠀⡀⠀⠀⠄⠀⡀⠀⣿⣿⡇⠀⠀⠂⠀⠀⠀⢀⠀⢀⠠⠐⠀⢸⣿⣿⠀⠀⠁⠀⠂⠀⠈⠀⠀⠀⠀⢀⠐",
			"⠀⢀⠀⠠⠐⠀⠀⠄⠁⠀⢀⠀⠀⠠⠀⠠⠀⠀⠀⣿⣿⡇⠀⠀⠄⠀⠂⠈⠀⠀⠀⠀⠀⢀⢸⣿⣿⠀⠀⠐⠀⠀⡈⠀⠐⠀⠐⠈⠀⠀",
			"⠐⠀⠀⠀⢀⠀⠀⠄⠀⠀⠄⠀⠄⠀⠀⠄⠀⠈⠀⣿⣿⡇⠀⠠⠀⠠⠀⠄⠀⠄⠂⠁⠀⠀⣸⣿⣿⠀⠀⠀⠄⠁⠀⠀⡀⠄⠀⠄⠀⢀",
			"⠀⠀⠂⠁⠀⠀⡀⠄⠐⠀⠀⡀⠄⠀⠁⠀⠀⠂⠁⣿⣿⡇⠀⠀⢀⠀⠀⢀⠀⢀⢀⣴⣼⣶⣾⣿⣯⠀⠠⠀⠠⠀⢀⠠⠀⠀⠀⢀⠠⠀",
			"⠀⠐⠀⠀⡀⠂⠀⠀⠀⢀⠀⠀⠀⡀⠀⠂⠀⠂⠀⣿⣿⡇⠀⠀⡀⠀⠈⠀⠀⣴⣿⣿⣿⣿⣿⣿⡿⠀⠀⢀⠀⢀⠀⠀⠀⠀⡈⠀⠀⠀",
			"⠁⠀⠠⠀⠀⠀⡀⠠⠈⠀⠀⠀⠁⠀⢀⣔⣾⣾⣿⣿⣿⡇⠀⠀⠀⠐⠀⠠⢸⣿⣿⣿⣿⣿⣿⣿⠋⠀⠀⠀⡀⠀⠀⠐⠀⠁⠀⠀⢀⠠",
			"⠀⢀⠠⠀⠂⠁⠀⠀⠀⠀⠐⠈⠀⢰⣿⣿⣿⣿⣿⣿⣿⠇⠀⠈⠀⠀⠂⠀⠈⠿⣿⣿⣿⡿⠟⠁⠀⠠⠈⠀⠀⠀⠁⠀⠠⠀⢀⠐⠀⠀",
			"⡀⠀⠀⠀⠀⡀⠀⠐⠈⠀⠀⠄⠀⣿⣿⣿⣿⣿⣿⣿⡟⠀⠄⠂⠀⠁⠀⠠⠀⠀⠀⠀⡀⠀⠀⢀⠠⠀⢀⠠⠀⠂⠀⠈⠀⠀⠀⠀⢀⠀",
			"⠀⠀⠈⠀⠀⡀⠠⠐⠀⠐⠀⠀⡀⠘⠿⢿⡿⡿⠟⠉⠀⠀⠀⢀⠀⠄⠁⠀⢀⠈⠀⢀⠀⢀⠐⠀⠀⠀⠀⠀⠀⢀⠀⠁⠀⠈⠀⠈⠀⠀",};
		String[] value1 = Util.setMiddle(str1);

		System.out.println();

		Util.print(value1);

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		Util.guideLine();
	}
}
