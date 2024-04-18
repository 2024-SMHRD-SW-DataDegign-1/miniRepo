package Music;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import Util.Util;
import javazoom.jl.player.MP3Player;

public class MyThread extends Thread {
	private int count;
	private boolean isProcess = true;

	int idx ;
	public void run()
	{
		 String[] List = 
			{
					"C:\\Users\\smhrd\\git\\miniRepo\\GitTest01\\player\\bgm.mp3",
					"C:\\Users\\smhrd\\git\\miniRepo\\GitTest01\\player\\bgm2.mp3",
					"C:\\Users\\smhrd\\git\\miniRepo\\GitTest01\\player\\bgm3.mp3",
					"C:\\Users\\smhrd\\git\\miniRepo\\GitTest01\\player\\bgm4.mp3",
					"C:\\Users\\smhrd\\git\\miniRepo\\GitTest01\\player\\bgm5.mp3"
					
			};
			 MP3Player play = Util.MP3Player2();
		  play.play(List[0]);
		while(true)
		{ 
			if(!play.isPlaying()) {
				Util.println("음악 끝");
				Random ran = new Random();
			 play.play(List[ran.nextInt(5)]);
			
			}
		}
	}
	
	public void Pause()
	{
		isProcess = !isProcess;
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
    
    public String[] moveConsole(String[] str, int type)
    {
    	String[] value = new String[str.length];
    	for(int i = 0; i< str.length; i++)
    	{
    		String val = str[i];
    		int idx = val.length();
        	switch(type)
        	{
        	case 0:
        		value[i] = str[i].substring(1, idx);
        		break;
        	case 1:
        		value[i] = "  "+str[i];
        		break;
        	}
    	}
    	return value;

    }
}
