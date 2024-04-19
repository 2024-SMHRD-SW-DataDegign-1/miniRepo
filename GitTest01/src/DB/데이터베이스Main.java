package DB;

import java.sql.Date;
import java.util.ArrayList;

//import java.util.ArrayList;

public class 데이터베이스Main {
	public static void main(String[] args) {

		// DB 관련
		DAO dao = new DAO();

		// 경험치와 스트레스를 수정하는 방법
		// dao.updateUser(0, 0);

		// 사용자 정보를 불러오는 방법
		// updateUser(상승시킬exp, 상승시킬stress);
		ArrayList<DTO> data = dao.searchUser();

		// 경험치
		int id = data.get(0).getUser_id();
		String nickname = data.get(0).getNickname();
		int exp = data.get(0).getExp();
		int stress = data.get(0).getStress();
		Date firstTime = data.get(0).getFirstTime();
		Date lastTime = data.get(0).getLastTime();
		String timeline = data.get(0).getTimeline();

		
		
		
		/**
		 * 
		 * 새로 만든 메소드들 모았습니다
		 * 
		 * 
		 * */
		
		// 회원 등록 기능 매개변수는 사용하는곳에서 정하시면됩니다
//		dao.signUp("닉네임");
		
		// 닉네임이 있는지 없는지 비교하는 메소드
//		System.out.println(dao.compareName("닉네임"));
		
		
		
		
		
		
		
		
		
		
		
//		System.out.println("id \t 경험치 \t 스트레스 \t 생성시간 \t\t 현재시간 \t\t 닉네임 \t\t 타임라인");
//		System.out.println(id + " \t " + exp + " \t " + stress + " \t " + firstTime + " \t " + lastTime + " \t "
//				+ nickname + " \t " + timeline);
	}
}
