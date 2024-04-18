package DB;

import java.sql.Date;
import java.util.ArrayList;

//import java.util.ArrayList;

public class 데이터베이스Main {
	public static void main(String[] args) {
		
		// DB 관련
		DAO dao = new DAO();
		
		// 경험치와 스트레스를 수정하는 방법
		//dao.updateUser(0, 0);
		
		// 사용자 정보를 불러오는 방법
		// updateUser(상승시킬exp, 상승시킬stress);
		ArrayList<DTO> data = dao.searchUser();
		
		
		
		// 경험치
		int exp = data.get(0).getExp();
		int stress = data.get(0).getStress();
		Date firstTime = data.get(0).getFirstTime();
		Date lastTime = data.get(0).getLastTime();
		
		
//		System.out.println("경험치 \t 스트레스 \t 생성시간 \t\t 현재시간");
//		System.out.println(exp+" \t "+stress+" \t "+firstTime+" \t "+lastTime);
	}
}
