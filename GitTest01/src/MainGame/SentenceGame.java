package MainGame;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import DB.DAO;
import DB.DTO;
import Util.Util;
import java.nio.charset.Charset;



public class SentenceGame {
	String[] mAnswerList = {
			"love",
			"Life itself is a quotation.",
			"Music has charms to soothe a savage breast.",
			"One lives but once in the world.",
			"I' never going back the past is in the past.",
			"You can't have your cake and eat it.",
	};
	
	Scanner mSc;
	int mLife;
	
	public SentenceGame()
	{
		
		mLife = 5;
	}
	
	public boolean Play()
	{
		mLife = 5;
		boolean result = true;
		DAO dao = new DAO();
		System.out.println();
		ArrayList<DTO> data = dao.searchUser();
		// 경험치
		int exp = data.get(0).getExp();
		int stress = data.get(0).getStress();
		String level = dao.RankCache();
		String time = data.get(0).getTimeline();
		for(int i =0; i< mAnswerList.length; i++)
		{
			Util.showState(level,stress, exp, time);
			showConsole();
			
			System.out.println();
			playGame(i);
			ClearConsole();
			if(mLife == 0)
			{
				result = false;
				break;
			}
			

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
		
		
		Util.println("문장 : " + mAnswerList[idx]);
		
		Util.print("입력 : ");
		String value = mSc.nextLine();
		
		if(!mAnswerList[idx].equals(value))
		{
			mLife--;
			showResult("땡!");
		}
		else
		{
			showResult("정답!");
		}
		Delay(2000);
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
    
    private void showResult(String result)
    {
    	Util.print(result +" 남은 목숨 : " + mLife);
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
	
}

