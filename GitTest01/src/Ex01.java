<<<<<<< HEAD
import MainGame.UpDown;

=======
>>>>>>> branch 'main' of https://github.com/2024-SMHRD-SW-DataDegign-1/miniRepo.git
import java.sql.Date;
import java.util.ArrayList;

import DB.DAO;
import DB.DTO;
import MainGame.SentenceGame;
import MainGame.가위바위보;
<<<<<<< HEAD
import SubGame.Story2;
=======
import SubGame.Story3;
>>>>>>> branch 'main' of https://github.com/2024-SMHRD-SW-DataDegign-1/miniRepo.git
import Util.Util;


public class Ex01 {
	public static void main(String[] args) {
			
		Story2 str = new Story2();
		str.play();
		
		
		
		//String str = "⣿⣿⣿⣿⠿⠿⠿⢿⡿⠿⠿⠿⢿⣿⣿⣿\n⣿⣿⣿⡇ ⣤⣤⣤⡇⠀⣤⣤⣤⣿⣿⣿\n⣿⣿⣿⣇ ⠉⠉⠉⡇⠀⠉⠉⠉⣿⣿⣿\n⣿⣿⣿⠿⠿⠿⠿⠀ ⠿ ⠿⠿⠿⣿⣿\n⣿⣿⣿⣤⣤⣤⠤⠤⠤⠤⢤⣤⣤⣿⣿⣿\n⣿⣿⣿⣿⠉⠀⣤⣤⣤⣤⡀⠈⢻⣿⣿⣿\n⣿⣿⣿⣿⣄⡀⠉⠙⠛⠉⠁⣠⣾⣿⣿⣿\n⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿";
		//Util.print(str);
//		SentenceGame view = new SentenceGame();
//		view.Play();
		
<<<<<<< HEAD
//		UpDown up = new UpDown();
//		up.play();
=======
		DAO dao = new DAO();

		// 경험치와 스트레스를 수정하는 방법
		//dao.updateUser(exp1, stress1);
		
		// 사용자 정보를 불러오는 방법
		// updateUser(상승시킬exp, 상승시킬stress);
		Story3 view = new Story3();
		view.Play();
		
		ArrayList<DTO> data = dao.searchUser();
		// 경험치
		int exp = data.get(0).getExp();
		int stress = data.get(0).getStress();
		
		System.out.println("" + exp + stress);


>>>>>>> branch 'main' of https://github.com/2024-SMHRD-SW-DataDegign-1/miniRepo.git
	}
}
  
                                                                                        