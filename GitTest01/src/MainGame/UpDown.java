package MainGame;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import DB.DAO;
import DB.DTO;
import Util.Util;

public class UpDown {
	   
	   public boolean play() {
	      int i = 1;         
	            
	      Random ran = new Random();
	      int ranNum = ran.nextInt(100) + 1;
	      Scanner sc = new Scanner(System.in);
	      int mLife = 6;

	      int mTargetNum = 0; 
	      while (mLife > 0) {
	         
	         //상태
	          {
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
                    String timeline = data.get(0).getTimeline();

               Util.showState(dao.RankCache(),stress, exp,timeline);

	         
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
	            Util.println("====1부터 100 사이 UpDownEvent!====");
	  	        Util.println("기회는 6번!");
	         }
	         else {

	             Util.println("현재 입력값 : "+ mTargetNum);
	            
	             if (mTargetNum < ranNum) {

	                Util.println("더 큰 수로 다시 시도하세요 ~ ㅠ.ㅠ ");
	                
	                mLife--;
	                Util.println("남은 목숨 : " + mLife + "개");
	                if (mLife == 0) {
		                 Util.println("Game Over !" + "  ");
		                 Util.println("정답은" + ranNum + "입니다.");
		                 break;
		              }


	             } else if (mTargetNum > ranNum) {

	                Util.println("더 작은 수로 다시 시도하세요 ~ ㅠ.ㅠ");
	                
	                mLife--;
	                Util.println("남은 목숨 : " + mLife + "개");
	                if (mLife == 0) {
		                 Util.println("Game Over !" + "  ");
		                 Util.println("정답은" + ranNum + "입니다.");
		                 break;
		              }

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
	      Delay(2000);
	      ClearConsole();
	      
	      return false;
	     
	      
	   } 
	   
	   public void Delay(int MilTime)
	   {
	      try
	      {
	         Thread.sleep(5000);
	        }
	      catch(InterruptedException  e)
	      {
	         e.printStackTrace();
	      }
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