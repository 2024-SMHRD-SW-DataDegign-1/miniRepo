package Util;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javazoom.jl.player.MP3Player;





public class Util {
	// 콘솔의 총 세로 길이
	private static int mHight = 30;
	
	// 콘솔의 총 가로 길이
	private static int mWidth = 120;
	// 아트가 차지하는 세로 길이는 22입니다
	
	// 도트 아트를 넣기위한 print 메소드
	public static void print(String[] console)
	{
		String value = "";
		for(int i = 0; i< console.length; i++)
		{
			value += console[i] + "\n";
		}
		PrintWriter out;
		try {
			out = new PrintWriter(new OutputStreamWriter(System.out, "UTF-8"), true);
			out.printf(value, null);
		
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// 일반 출력문을 위한 print 메소드
	public static void print(String console)
	{
		PrintWriter out;
		try {
			out = new PrintWriter(new OutputStreamWriter(System.out, "UTF-8"), true);
			out.printf(console,null);
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void println(String console)
	{
		PrintWriter out;
		try {
			out = new PrintWriter(new OutputStreamWriter(System.out, "UTF-8"), true);
			out.println(console);
		
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 구분선 출력을 위한 메소드
	public static void guideLine()
	{
		for(int i = 0; i< mWidth-1; i++)
		{
			System.out.print("*");
		}
		System.out.println();
	}
	
	private static String getStr(String str, int idx)
	{
		String Result = "";
		for(int i = 0; i< idx; i++)
		{
			Result += str;
		}
		return Result;
	}
	
	public static String[] setMiddle(String[] str)
	{
		String[] Result = new String[str.length];
		int idx = str[0].length();
		int gabCount = (mWidth/2) - (idx/2);
		for(int i = 0; i < str.length; i++)
		{
			Result[i] = getStr(" ", gabCount) + str[i];
		}
		return Result;
	}
	
	private static String setExp(int exp)
	{
		String result = "";
		
		for(int i = 0; i< 10; i++)
		{
			if(i<exp/10)
			{
				result += "■";
			}
			else
			{
				result += "  ";
			}
		}
		return result;
	}
	
	public static void showState(String level, int 스트레스, int exp, String time)
	{
    	System.out.println();
    	Util.println("직급 : "+ level + "\t\t스트레스 : " + 스트레스 + "%\t\t"
    			+ "\t경험치 : [" + setExp(exp%100)   + "]"+ "\t\t 현재시간 : " + time);
    	System.out.println();
	}
	
    public static void setEncoding() {
        try {
           ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "chcp 65001");
           Process startProcess = pb.inheritIO().start();
           startProcess.waitFor();
           
      } catch (Exception e) {
         e.printStackTrace();
      }
    }
    public static MP3Player MP3Player2(){
    MP3Player mp3 = new MP3Player();
	return mp3;
    }
}
