package DB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// DAO : Data Access Object
// DB에 관련된 기능들을 전부 가지고 있는 클래스
public class DAO {
	PreparedStatement psmt = null;
	PreparedStatement psmt2 = null;
	Connection conn = null;

	// DB 연결
	public void conn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";
			String user = "campus_24SW_DD_p1_2";
			String password = "smhrd2";
			conn = DriverManager.getConnection(url, user, password);
			if (conn != null) {
				// System.out.println("DB 연결 성공");
			} else {
				// System.out.println("DB 연결 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// DB 연결 끊기
	public void dbClose() {
		try {
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 경험치, 스트레스, 현재 시간 수정
	// 변경할 값으로 매개변수를 받아온다
	public void updateUser(int exp, int stress) {
		String sql = "UPDATE game_user SET exp = ?, stress = ?";
		int row = 0;
		try {
			conn();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, exp);
			psmt.setInt(2, stress);
			row = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		if (row > 0) {
			// System.out.println("회원정보수정 성공!😊");
		} else {
			// System.out.println("회원정보수정 실패!😢");
		}
	}

	// 정보 조회
	public ArrayList<DTO> searchUser() {
		String sql = "SELECT U.user_id, U.exp, U.stress, U.first_time, U.last_time, U.nickname, T.timeline FROM game_user U INNER JOIN timeline T ON U.nickname = ?";
		ResultSet rs = null;
		DTO dto = null;
		String currentName = getNickname();
		ArrayList<DTO> list = new ArrayList<DTO>();
		try {
			conn();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, currentName);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				int exp = rs.getInt(2);
				int stress = rs.getInt(3);
				Date firstTime = rs.getDate(4);
				Date lastTime = rs.getDate(5);
				String nickname = rs.getString(6);
				String timeline = rs.getString(7);
				// 조회해 온 결과(rs)에 담겨 있는 데이터를 DTO에 옮겨서 하나로 묶음
				dto = new DTO(id, exp, stress, firstTime, lastTime, nickname, timeline);
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		if (dto != null) {
			// System.out.println("조회 성공!😊");
		} else {
			// System.out.println("조회 실패!😢");
		}
		return list;
	}

	// 직급 불러오는 메소드
	public String RankCache() {
		String sql = "select exp from game_user";
		ResultSet rs = null;
		int exp = 0;
		try {
			conn();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				exp = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		if (rs == null) {
			// System.out.println("조회 성공!😊");
		} else {
			// System.out.println("조회 실패!😢");
		}
		if (exp >= 0 && exp < 100) {
			return "인턴";
		} else if (exp >= 100 && exp < 200) {
			return "사원";
		} else if (exp >= 200 && exp < 300) {
			return "대리";
		} else if (exp >= 300 && exp < 400) {
			return "부장";
		} else if (exp >= 400 && exp < 99900) {
			return "사장";
		} else {
			return "백수";
		}
	}

	/**
	 * @author 박민수
	 * @param String => "출근", "오전", "점심", "오후", "퇴근"
	 * @apiNote 입력한 파라미터를 DB에 저장
	 * @return 리턴값 없음
	 */
	public void updateTime(String timeline) {
		String sql = "UPDATE timeline SET timeline = ?";
		int row = 0;
		try {
			conn();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, timeline);
			row = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		if (row > 0) {
			// System.out.println("타임라인 수정 성공!");
		} else {
			// System.out.println("타임라인 수정 실패!");
		}
	}

	/**
	 * @author 박민수
	 * @apiNote 인덱스 검색
	 * @param
	 * @return
	 */
	public int idx() {
		int idx = 0;
		String sql = "SELECT * FROM game_user";
		ResultSet rs = null;
		try {
			conn();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				idx++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return idx;
	}
	
    /**
     * @author 박민수
     * @param nickname(닉네임)
     * @apiNote 회원가입 기능
     * @return 없음
     * 
     * */
	public void signUp(String nickname) {
		int user_id = idx() + 1;
		String sql = "INSERT INTO game_user (user_id, exp, stress, first_time, last_time, nickname) VALUES (?, 0, 0, sysdate, sysdate, ?)";
		String sql2 = "INSERT INTO timeline (timeline_id, timeline) VALUES (?, ?)";
		int row = 0;
		int row2 = 0;
		try {
			conn();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, user_id);
			psmt.setString(2, nickname);
			row = psmt.executeUpdate();
			
			psmt2 = conn.prepareStatement(sql2);
			psmt2.setInt(1, user_id);
			psmt2.setString(2, "출근");
			row2 = psmt2.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		if (row > 0 || row2 > 0) {
			System.out.println("등록 성공!");
		} else {
			System.out.println("등록 실패!");
		}
	}
	
	// 이름이 존재하는지 확인하는 메소드
	public boolean compareName(String nickname) {
		saveName(nickname);
		String sql = "SELECT nickname FROM game_user WHERE nickname = ?";
		int row = 0;
		try {
			conn();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, nickname);
			row = psmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			dbClose();
		}
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	/**
	 * @author 박민수
	 * @apiNote 현재 사용자 저장
	 * @param
	 * @return
	 */
	public void saveName(String nickname) {
		String sql = "INSERT INTO save (nickname) VALUES (?)";
		String save = nickname;
		int row = 0;
		try {
			conn();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, save);
			row = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}

	}
	
	public String getNickname() {
		String sql = "select * from save";
		ResultSet rs = null;
		String nickname = "";
		try {
			conn();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				nickname = rs.getString(1);
				// 조회해 온 결과(rs)에 담겨 있는 데이터를 DTO에 옮겨서 하나로 묶음
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return nickname;
	
	
	}
	
	

}