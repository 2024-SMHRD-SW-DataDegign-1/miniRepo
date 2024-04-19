package SubGame;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import DB.DAO;
import DB.DTO;
import Util.Util;

public class Story3 {
	private Scanner sc;

	
	public Story3()
	{
		sc = new Scanner(System.in);
	}
	public void Play()
	{
		
		// DB 관련
		DAO dao = new DAO();
		// 경험치와 스트레스를 수정하는 방법
		//dao.updateUser(exp1, stress1);
		
		// 사용자 정보를 불러오는 방법
		// updateUser(상승시킬exp, 상승시킬stress);
		ArrayList<DTO> data = dao.searchUser();
		// 경험치
		int exp = data.get(0).getExp();
		int stress = data.get(0).getStress();
		String time = data.get(0).getTimeline();
		Util.showState("인턴", exp, stress, time);

		showConsole();

		Util.println("직장 동기가 도움을 요청하는 상황이다 당신의 선택은?");
		Util.println("1. 그래! 도와줄게!!\t2. 아니 나도 바빠 ");
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:
			dao.updateUser(exp+20,stress);
			break;
		case 2:
			dao.updateUser(exp, stress);
			break;
			
		}
		
		ClearConsole();
		
	}
	
    private void showConsole()
    {
    	Util.guideLine();
    	String[] str =
    		{
    			"⠀⠠⠀⠀⠄⢐⢐⢐⠡⠡⠡⢑⠐⢄⠤⠠⡀⠀⠄⢀⠠⠀⠀⠄⠀⠄⢀⠠⠀⠀⠄⠀⠄⢀⠠⠀⠀⠄⠀⠠⠀⠠",
    			"⠀⠐⠀⠁⠠⠑⡔⢐⠨⠠⢁⢂⠌⡂⡀⢀⢁⢂⠄⡄⠀⡀⠁⡀⠐⠀⡀⠀⠄⠁⢀⠐⠀⡀⠀⠄⠁⡀⠈⢀⠀⠂",
    			"⠈⡀⠐⠈⠈⡐⢔⠐⠨⢐⠐⠄⢀⠀⠈⠆⢢⢘⢌⠌⠀⡀⠄⠀⡀⠂⠀⠠⠐⠈⡐⡐⡀⡄⠀⠂⠀⠄⠠⠀⠄⠂",
    			"⠀⠀⠄⠂⠁⠀⠑⢌⠨⢐⢈⠢⢀⢂⢜⢌⢢⠱⠈⠂⢀⠠⠀⠄⠀⠠⠈⠀⠰⡐⢔⠠⢑⠄⡐⡈⠀⠠⠀⠄⠠⠐",
    			"⠄⠂⠀⠐⠀⠈⡀⠀⠑⠐⢔⢘⠄⡂⡆⣣⣵⡇⠀⠁⠀⡀⠄⠀⡈⠀⠐⠈⠀⡨⠂⠌⡐⢐⠐⠈⠀⠄⠠⠀⠄⠀",
    			"⠂⠀⠁⠈⠀⠁⢀⠀⠂⠑⠨⢂⢃⠆⡻⣿⣿⢫⣇⢆⢅⢀⠠⠀⡀⢈⠀⠄⠅⡂⠅⡁⠢⠁⠀⡁⠀⠂⠀⠄⠀⠂",
    			"⠐⠈⠀⠁⠈⢀⠢⡀⠐⠀⠠⠀⠀⠑⢌⠹⢫⠫⠱⠑⠔⠠⠊⠀⠀⠂⡪⢈⢐⠠⢁⠢⠑⠀⠁⢀⠀⠁⡀⠂⠐⠀",
    			"⠂⠁⢀⢁⣀⠢⢁⢢⢀⠁⠀⠄⠁⠀⠢⠈⠂⠀⢈⠂⠀⠀⠈⠐⠠⠀⠨⢐⠠⠨⡐⠈⢀⠐⠀⠠⠀⠂⠀⡀⠂⠀",
    			"⠐⠈⠐⠐⡔⡨⡘⢄⠢⡂⡁⠠⢊⠂⠑⠐⠄⠂⠁⠀⠀⠀⠀⠀⠀⠑⠈⠂⠌⡂⢀⠈⠀⠠⠐⠀⠠⠐⠀⢀⠀⠁",
    			"⠀⠂⠐⠀⠐⡐⡐⢐⠐⡐⠨⠨⠠⢑⠀⠀⠀⠡⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡡⡠⡡⡰⡠⣂⠀⠐⠀⡀⠄⠈",
    			"⠂⠐⠀⠈⢀⠀⠪⡐⢐⠠⠡⢈⠂⡂⠅⠀⠀⠌⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⢰⠱⡑⡕⢕⢕⢜⢔⢝⢔⠀⢀⠀⠂",
    			"⠀⠂⠈⢀⠀⠠⠀⠈⠐⠨⠨⢐⠐⠄⡕⡀⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⡰⡑⡕⢕⢕⢕⢕⢕⢕⢕⢕⢕⢕⠀⠀⠐",
    			"⠠⠐⠈⠀⢀⠐⠀⠈⡀⠄⠠⠀⠀⠄⠀⡂⠀⠀⠀⠀⠀⠀⠀⠀⠀⡸⡨⡪⡪⡪⡢⡣⡱⡑⡕⢕⢕⢕⢕⠅⠈⠀",
    			"⠀⠄⠂⠁⠀⡀⠄⠁⢀⠀⠠⠐⠀⡯⡯⡢⠀⠀⠀⠀⠀⠀⠀⡀⡔⢕⢕⢜⢌⢎⢪⢪⢪⠪⡪⡪⡢⡣⡱⠁⠀⠁",
    			"⠂⠀⠐⠈⠀⡀⠀⠂⠀⠠⠀⠂⠀⢣⡫⡺⡤⡤⡠⡄⡆⡎⢎⢪⠪⡪⡢⡣⡱⡱⠑⡰⡱⡱⡱⡸⡨⡪⡊⠀⢈⠀",
    			"⠐⠈⢀⠀⢁⠀⡀⠁⠈⢀⠠⠐⠈⠀⠣⡣⡣⣫⢪⢎⢎⡪⡪⡪⡪⡪⡪⡊⠊⠀⠐⣕⢵⢱⢱⡱⡱⡱⠁⠀⠄⠀",
    			"⠈⠀⡀⠄⠀⡀⠀⠄⠁⠀⡀⠄⠐⠀⡀⠨⡹⡨⡪⡪⡪⡪⡪⡪⡪⡪⡪⠂⠀⢈⠀⠑⡇⡧⡣⡣⡣⠅⠀⠂⢀⠈",
    			"⠂⠁⠀⠠⠀⠄⠀⠂⠀⢁⠀⡀⠄⢀⠠⠀⢇⢇⢣⢣⢱⠸⡨⡪⡪⡪⡊⠀⠈⡀⠀⠄⠸⡜⡜⡎⡧⠁⠀⠂⠀⡀",
    			"⠄⠈⠀⠐⠀⡀⠂⠈⠀⡀⢀⠀⠠⠀⠀⠄⠘⡌⡎⢆⢇⢣⠣⡪⡪⡊⠀⡀⠁⢀⠀⠂⠀⠣⡣⠇⠅⠀⡈⠀⠄⠀",
    			"⠂⠀⢁⠀⠁⢀⠀⠂⠁⠀⡀⠀⠄⠐⠀⠠⠀⠈⠊⠎⡪⡢⡣⠣⠊⠀⡀⠀⠄⠀⠠⠀⠁⡀⠀⠄⠀⠂⠀⠄⠂⠀"
    		};
		

		String[] value = Util.setMiddle(str);			
		
		Util.print(value);

		Util.guideLine();
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
}
