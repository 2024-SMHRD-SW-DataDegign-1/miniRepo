package MainGame;

import java.util.Random;
import java.util.Scanner;

import Util.Util;

public class UpDown {

	public boolean play() {
				
		Random ran = new Random();
		int ranNum = ran.nextInt(100) + 1;
		Scanner sc = new Scanner(System.in);
		int mLife = 6;

		Util.print("====1부터 100 사이 UpDownEvent!====");
		Util.print("기회는 6번!");

		while (mLife > 0) {
			
			//상태
			 {
				
				Util.showState("인턴",40, 60);
			
			//아스키코드
				
	Util.guideLine();
	String[] str =
	{
	"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
	"⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡲⡽⣝⢽⡳⣻⡺⣝⢯⢯⡳⡽⣲⡲⡦⡦⡤⡤⣔⡕⠁⠁⡈⠈⠀⡯⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡎⡎⡎⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
	"⠀⠀⠀⠀⠀⠀⠀⠀⢀⣸⡺⣝⣞⡵⡯⣳⢝⣞⡽⣕⢯⣻⡪⡯⣞⢽⣹⢝⡮⡇⠀⠈⠏⠀⠀⡯⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⢱⢱⢱⢱⡁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
	"⠀⠀⠀⠀⠀⠀⠀⠀⣞⣞⢮⣳⡳⣝⢾⢵⡻⣺⡪⣗⢯⢞⣞⢽⡺⣝⢮⢯⢞⡇⠀⠀⠀⠀⠀⡯⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⢪⢪⢪⡪⡪⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
	" ⠀⠀⠀⠀⠀⠀⠀⣕⣗⡽⣺⣪⢗⡯⣳⢽⢕⡯⣳⣫⢯⣺⢵⣻⡪⣯⡳⡯⡎⠀⠀⠀⠀⠀⡯⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⡸⡸⡸⡪⡱⡱⡉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
	"⠀⠀⠀⠀⠀⠀⠀⢸⣺⣪⢾⢕⣗⢯⢞⣗⡽⣝⢾⢕⡷⣝⡮⣳⡳⣝⣞⢮⢯⢇⠀⠀⠀⠀⠀⡯⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡰⡸⡜⡜⡎⡎⣎⢎⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
	"⠀⠀⠀⠀⠀⠀⠀⠀⢑⣗⡽⣝⢮⢯⣳⡳⣝⣞⢽⢵⡻⣺⡺⡵⣻⢺⣪⢯⢞⡕⠀⠀⠀⠀⠀⡯⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⣀⢀⡀⣀⢀⡀⠀⠀⢠⢪⢪⢪⢪⢪⢪⡪⡪⣒⢖⢲⢰⢲⢰⢒⢆⢆⡀⠀⠀⠀⠀⠀⠀⠀",
	"⠀⠀⠀⠀⠀⠀⠀⠀⢺⣺⡪⣗⢯⣳⡳⣝⣞⢮⢯⡳⡽⣺⣪⢟⡮⡯⣺⠝⠙⣎⣀⣀⣀⣀⡀⡯⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠁⠁⠈⠀⠁⡱⡡⡢⡣⡣⡳⡱⢕⢇⢇⢇⢇⢇⢇⢇⢇⢇⢇⢇⢧⢣⠣⠀⠀⠀⠀⠀⠀",
	"⠀⠀⠀⠀⠀⠀⠀⠀⠈⠚⠮⠯⠳⠳⠝⠞⠮⡫⣗⡽⣝⣞⢮⣳⢽⠝⠊⠀⠀⠁⠁⠈⠀⠁⠉⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⢜⢜⢜⢜⢎⢎⢎⢇⢇⢇⢧⢓⢕⢵⢱⢣⢳⢹⢸⢸⢸⢡⠀⠀⠀⠀⠀⠀⠀⠀",
	"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⡯⣞⣞⢵⣳⡫⡞⠕⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣇⠀⠀⠀⠀⠀⢪⢪⢪⢣⢣⢣⢳⢱⢱⢕⢕⢕⡕⡕⡕⡕⡕⡕⡕⣕⢕⢕⠅⠀⠀⠀⠀⠀⠀⠀",
	"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡴⡽⣝⢮⢞⡽⡪⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡖⠀⠀⠀⠀⠀⡱⡱⡕⡕⣕⢵⢱⢱⡱⡱⡱⡱⡱⡱⡹⡸⡸⡪⡪⡪⡪⣊⠀⠀⠀⠀⠀⠀⠀⠀  ",
	"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⣝⣞⢮⢯⢯⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⢜⢜⢜⢜⢜⢜⢜⢜⢜⢜⢜⢎⠮⡺⡸⡸⡜⡜⣜⢜⢎⠮⠀⠀⠀⠀⠀⠀⠀⠀ ",
	"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣕⢷⢝⣗⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣇⠀⠀⢦⠀⠀⡪⡪⡪⡣⡣⡣⣣⢣⢳⢱⢱⢕⢝⢜⢜⢜⢜⢜⢜⢜⠌⠀⠀⠀⠀⠀⠀⠀⠀⠀",
	"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢺⢽⢕⡗⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡖⣀⢀⡁⣀⡀⣜⠘⠊⠊⠪⠪⠪⠪⡪⡪⡪⡪⡪⡪⡪⡪⡣⡣⡳⠱⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀"
	};
	String[] value = Util.setMiddle(str);

	System.out.println();
	System.out.println();

	Util.print(value);

	System.out.println();
	System.out.println();
	System.out.println();
	Util.guideLine();
			
			
			
			
			
			Util.print("1부터 100사이의 정수를 입력하세요 >> ");
			int mTargetNum = sc.nextInt();

			if (mTargetNum < ranNum) {

				Util.print("더 큰 수로 다시 시도하세요 ~ ㅠ.ㅠ ");
				
				mLife--;
				Util.print("남은 목숨 : " + mLife + "개");
				
				if (mLife == 0) {
					Util.print("Game Over !" + "  ");
					Util.print("정답은" + ranNum + "입니다.");
				}

			} else if (mTargetNum > ranNum) {

				Util.print("더 작은 수로 다시 시도하세요 ~ ㅠ.ㅠ");
				
				mLife--;
				Util.print("남은 목숨 : " + mLife + "개");
				
				if (mLife == 0) {
					Util.print("Game Over !" + "  ");
					Util.print("정답은" + ranNum + "입니다.");
				}

			} else {
				Util.print(ranNum + " 정답입니다~!!");
				System.out.println();
				Util.print("Game Success");
				System.out.println();
				break;
			}
			
		}
		
		}
		return false;
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
}

