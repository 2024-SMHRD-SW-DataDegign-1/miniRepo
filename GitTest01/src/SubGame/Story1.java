package SubGame;

import java.util.Scanner;

import Util.Util;

public class Story1 {
	
	  public static void main(String[] args) {
		  
		  Scanner sc = new Scanner(System.in);
		  
		  Util.print("===== 비상! 부장님이 찾아오셨다 =====");
		  Util.print("부장님 : 자네 혹시 등산 좋아하나??");
		  Util.print("맨날 앉아있으니 건강이 나빠지지 "
		  		+ "등산을 해야 건강에도 좋고 어때 이번 주말에 같이 갈텐가?");
		  Util.print("1. 등산 좋죠 같이 가시죠! 2. 저 주말에 약속이 있어서요.. 3. 다음에 같이 가시죠");
		  
		  int choice = sc.nextInt();
		  
		  if(choice == 1) {
			  Util.print("경험치 증가! 하지만 나의 스트레스는 쌓인다.. -.-zzz");
			  // 경험치는 증가하지만 스트레스 증가
		  }else if(choice == 2){
			  Util.print("가기 싫은 등산은 피했지만 부장님의 표정이 좋지 않다..");
			  // 경험치는 변화 없지만 스트레스 감소
		  }else {
			  
		  }
	
}
}
