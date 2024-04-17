package DB;

import java.sql.Date;

public class DTO {
	
	// 1. 필드 = db 컬럼
	// 플레이어식별자, 경험치, 스트레스 지수, 생성시간, 종료시간
	private int user_id;
	private int exp;
	private int stress;
	private Date firstTime;
	private Date lastTime;

	// 2. 메소드
	public DTO(int user_id, int exp, int stress, Date firstTime, Date lastTime) {
		super();
		this.user_id = user_id;
		this.exp = exp;
		this.stress = stress;
		this.firstTime = firstTime;
		this.lastTime = lastTime;
	}

	// Getter
	public int getUser_id() {
		return user_id;
	}

	public int getExp() {
		return exp;
	}

	public int getStress() {
		return stress;
	}

	public Date getFirstTime() {
		return firstTime;
	}

	public Date getLastTime() {
		return lastTime;
	}

	// Setter
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public void setStress(int stress) {
		this.stress = stress;
	}

	public void setFirstTime(Date firstTime) {
		this.firstTime = firstTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	
	
}