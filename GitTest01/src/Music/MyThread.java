package Music;

import java.io.File;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

import Util.Util;
import javazoom.jl.player.MP3Player;

public class MyThread {
	private int count;
	private boolean isProcess = true;
	static int time =0;
	int idx ;
	Timer t;
	TimerTask task ;
	MP3Player play;
	boolean isStart =false;
	public void run()
	{
		File file = new File(".");
		
	   String currentPaht = System.getProperty ( "user.home" ) ;
       String[] List = 
         {
             currentPaht+"\\git\\miniRepo\\GitTest01\\player\\bgm.mp3",
               currentPaht+"\\git\\miniRepo\\GitTest01\\player\\bgm2.mp3",
               currentPaht+"\\git\\miniRepo\\GitTest01\\player\\bgm3.mp3",
               currentPaht+"\\git\\miniRepo\\GitTest01\\player\\bgm4.mp3",
               currentPaht+"\\git\\miniRepo\\GitTest01\\player\\bgm5.mp3"
               
         };
			 play = Util.MP3Player2();

;
		t = new Timer();
		task = new TimerTask()

				{
			@Override
			public void run()
			{
				time++;
				switch(time)
				{
				case 1:
					//System.out.println("3333");
					
					if(play.isPlaying())
					{
						play.stop();
						Random ran = new Random();
						play.play(List[ran.nextInt(5)]);
						time = 0;
					}
					break;
				case 100:
			        t.cancel();
			        t.purge();
			        t = null;
			        task = null;
					break;
				}

			}
			
				};
			t.schedule(task, 30000,30000);
			play.play(List[0]);
	}
	
	
	
	public void Pause()
	{
		play.stop();

        isStart = true;
        time = 99;
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
