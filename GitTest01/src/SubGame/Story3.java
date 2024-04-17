package SubGame;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import DB.DAO;
import DB.DTO;
import Util.Util;

public class Story3 {
	private Scanner sc;
	//4. 동기 중 한명이 나한테 자기가 밀린 업무를 맡기려고 한다. "저기 00아 나 바빠서 그러는데 이거 혹시 해줄 수 있어?" ( 나를 만만하게 보는 엘리트 동기이다...) 약간 1회성 이벤트

	//-1 어... 그래 도와줄게  -2 아니 나도 바빠죽겠는데 싫어.
	
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
		
		Util.print("저기 인턴아 나 바빠서 그러는데 이거 혹시 해줄 수 있어?");
		Util.print("1. 어.. 그래 도와줄게\t2. 아니 나도 바빠 죽겠는데");
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
}
