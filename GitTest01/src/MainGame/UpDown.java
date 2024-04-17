package MainGame;

import java.util.Random;
import java.util.Scanner;

import Util.Util;

public class UpDown {
	   
	   public boolean play() {
	      int i = 1;


	         
	            
	      Random ran = new Random();
	      int ranNum = ran.nextInt(100) + 1;
	      Scanner sc = new Scanner(System.in);
	      int mLife = 6;

	      Util.println("====1부터 100 사이 UpDownEvent!====");
	      Util.println("기회는 6번!");
	      int mTargetNum = 0; 
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
	         
	         
	         
	  
	         if(i==1)
	         {
	            i--;
	            Util.println("1부터 100사이의 정수를 입력하세요 >> ");
	         }
	         else {

	             Util.println("현재 입력값 : "+ mTargetNum);
	             if (mLife == 0) {
	                 Util.println("Game Over !" + "  ");
	                 Util.println("정답은" + ranNum + "입니다.");
	              }
	             if (mTargetNum < ranNum) {

	                Util.println("더 큰 수로 다시 시도하세요 ~ ㅠ.ㅠ ");
	                
	                mLife--;
	                Util.println("남은 목숨 : " + mLife + "개");
	                


	             } else if (mTargetNum > ranNum) {

	                Util.println("더 작은 수로 다시 시도하세요 ~ ㅠ.ㅠ");
	                
	                mLife--;
	                Util.println("남은 목숨 : " + mLife + "개");
	                

	             } else {
	                Util.println(ranNum + " 정답입니다~!!");
	                System.out.println();
	                Util.println("Game Success");
	                System.out.println();
	                break;
	             }
	         }
	 
	         
	         mTargetNum = sc.nextInt();
	         ClearConsole();
	         
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