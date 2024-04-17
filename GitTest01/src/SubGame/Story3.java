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

		Util.showState("인턴", 100, 100);




		showConsole();


		
		
		// 경험치
		int exp = data.get(0).getExp();
		int stress = data.get(0).getStress();
		
		Util.println("저기 인턴아 나 바빠서 그러는데 이거 혹시 해줄 수 있어?");
		Util.println("1. 어.. 그래 도와줄게\t2. 아니 나도 바빠 죽겠는데");
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
}
