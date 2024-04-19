package PlayStation;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import DB.DAO;
import DB.DTO;
import MainGame.SentenceGame;
import MainGame.UpDown;
import MainGame.가위바위보;
import MainGame.구구단게임;
import Music.MyThread;
import SubGame.Story1;
import SubGame.Story2;
import SubGame.Story3;
import SubGame.Story4;
import Util.Util;
import javazoom.jl.player.MP3Player;

public class Ex02 {	

   static MyThread thr = new MyThread();
   
	String[] mLevel = {"인턴", "사원", };
	static String[] mTime = {"출근", "오전", "점심", "오후", "퇴근"};
	static int mTimeIdx = 0;
	
	static final int mVictory = 15;
	static final int mLose = 16;
	
	static DAO dao = new DAO();
	static Scanner sc = new Scanner(System.in);
	static boolean isGame = false;
	public static void main(String[] args) {
		Util.setEncoding();
		ClearConsole();
		thr.start();
		
		Random rand = new Random();
		Story1 story1 = new Story1();
		Story2 story2 = new Story2();
		Story3 story3 = new Story3();
		Story4 story4 = new Story4();
		
		SentenceGame main1 = new SentenceGame();
		UpDown main2 = new UpDown();
		가위바위보 main3 = new 가위바위보();
		구구단게임 main4 = new 구구단게임();
		
	
		while(true)
		{
			if(!isGame)
			{
				Util.println("1. 게임 시작 \t 2.종료");
				int choice = sc.nextInt();
				if(choice == 1)
				{ 
					isGame = true;
				}
				else if(choice == 2)
				{  thr.stop();
					break;
				}
				else
				{
					Util.println("다시 입력해주세요!");
					continue;
				}
			}
			if(isGame)
			{
				
				if(mTimeIdx == 0 || mTimeIdx == 2 || mTimeIdx == 4)
				{
					// 서브 이벤트
					int gameNum = rand.nextInt(4);
					switch(gameNum)
					{
					case 0:
						story1.play();
						break;
					case 1:
						story2.play();
						break;
					case 2:
						story3.Play();
						break;
					case 3:
						story4.play();
						break;
					}
					isContinue();
					nextTime();
				}
				else
				{
					// 메인 이벤트
					int gameNum = rand.nextInt(4);
					boolean result = false;
					switch(gameNum)
					{
					case 0:
						result = main1.Play();
						break;
					case 1:
						result = main2.play();
						break;
					case 2:
						result = main3.play();
						break;
					case 3:
						result = main4.play();
						break;
					}
					if(result)
					{
						setState(mVictory);
					}
					else
					{
						setState(mLose);
					}
					isContinue();
					nextTime();
				}
			}

		}
		
	}
	
	private static void nextTime()
	{
		if(mTimeIdx == 4)
		{
			mTimeIdx = 0;
			return;
		}
		mTimeIdx++;
	}
	
	private static void setTime()
	{
		dao.updateTime(mTime[mTimeIdx]);
	}
	
	private static void setState(int type)
	{
		ArrayList<DTO> data = dao.searchUser();
		// 경험치
		int exp = data.get(0).getExp();
		int stress = data.get(0).getStress();
		int num = 0;
		switch(type)
		{
		case mVictory:
			num = exp + 20;
			break;
		case mLose:
			num = exp - 10;
			break;
		default:
				break;
		}
		if(num < 0)
		{
			num = 0;
		}
		dao.updateUser(num, stress);
	}
	
	public static void isContinue()
	{
		Util.println("게임이 종료되었습니다 계속 하실건가요?");
		Util.println("1. 계속할래요 \t 2. 그만할래요");
		int choice = sc.nextInt();
		if(choice == 2)
		{
			isGame = false;
		}
		ClearConsole();
	}
	
	public static void ClearConsole() {
		try {
			ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
			Process startProcess = pb.inheritIO().start();
			startProcess.waitFor();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Delay(int MilTime)
	{
		try
		{
			Thread.sleep(5000);
			
		}
		catch(InterruptedException  e)
		{
			e.printStackTrace();
		}
	}

}


//ArrayList<DTO> data = dao.searchUser();
//// 경험치
//int exp = data.get(0).getExp();
//int stress = data.get(0).getStress();
//String level = dao.RankCache();
