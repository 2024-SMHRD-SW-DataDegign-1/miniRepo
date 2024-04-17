package Game;

import java.util.Scanner;

import Util.Util;

public class SentenceGame {
	String[] mAnswerList = {
			"답안지",
			"빈부강약을 막론하고 일하지 않는 자를 배척하라.",
			"화가나면 열을 세어라. 풀리지 않는다면 백을 세어라",
			"전쟁에선 어느편이 스스로를 승자라고 부를지라도 승리자는 없고 모두 패배자 뿐이다.",
			"일 잘하는 사람에게는 못 쓸 땅이 없다.",
			"내 몸이 중이면 중의 행세를 하라.",
			"아이들에게 비평보다도 귀감이 필요하다."
	};
	
	Scanner mSc;
	int mLife;
	
	public SentenceGame()
	{
		
		mLife = 5;
	}
	
	public boolean Play()
	{
		boolean result = true;
		for(int i =0; i< mAnswerList.length; i++)
		{

			Util.showState("인턴",40, 60);
			showConsole();
			
			System.out.println();
			playGame(i);
			if(mLife == 0)
			{
				result = false;
				break;
			}
			
			ClearConsole();
		}

		
		return result;
		
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
    
    public void playGame(int idx)
    {
		mSc = new Scanner(System.in);
		Util.print("문장 : " + mAnswerList[idx]);
		
		Util.print("입력 : ");
		String value = mSc.next();
		if(!mAnswerList[idx].equals(value))
		{
			mLife--;
			
		}
		Util.print("남은 목숨 : " + mLife);
    }
    
    private void showConsole()
    {
    	
    	Util.guideLine();
		String[] str = 
			{ 
					"#######  ##   ##   #####   ######   #####              #  #  #  #####   ######   ######",   
					"##   ##  ##   ##  #######  #######  ######             #  #  # #######  #######  #######",  
					"##       ##   ##  ##   ##       ##      ##             #  #  # ##   ##       ##       ##", 
					"#######  #### ##  ##   ##  ######       ##            ##  #  # ##   ##  ######   ##   ##", 
					"    ###  ##   ##  ##   ##  ##   ##      ##            ##  #  # ##   ##  ##   ##  ##   ##", 
					"##  ###  ##   ##  #######  ##   ##      ##            ##  #  # #######  ##   ##  #######",  
					"#######  ##   ##   #####   ##   ##      ##            ########  #####   ##   ##  ######", 
			};
		

		String[] value = Util.setMiddle(str);			

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		Util.print(value);

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		Util.guideLine();
    }
    
    private void showState()
    {

    }
}

