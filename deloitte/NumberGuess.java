package deloitte;

import java.util.Scanner;

//import java.util.*;
public class NumberGuess {
	private static Scanner sc=new Scanner(System.in);

	private static int target=(int)(Math.random()*100 +1);
	private static int attempts=5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(target);
		play();
	
	}
	
	private static int getInput()
	{
		return sc.nextInt();

	}
	private static void play()
	{
		for(int i=0;i<attempts;i++)
		{
			int input=getInput();
			if(input==target)
			{
				System.out.println("correct");
				return;
			}
			else
				System.out.println("wrong");
			
		}
		
		
	}

}
