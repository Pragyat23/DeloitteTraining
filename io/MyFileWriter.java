package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFileWriter {

	private static String fileName="D://userpass.txt";

	public static void main(String[] args) {
		
		FileWriter fw=null;
		boolean a =true;
		 try 
		 {
			fw=new FileWriter(fileName,a);
			
		 }
		 catch(IOException e)
		 {
			 e.printStackTrace();
		 }
		 PrintWriter out = null;
		 out = new PrintWriter(fw);
		 out.println("admin:admin123");
		 out.println("user1:user1123");
		 out.println("user2:user2123");
		 out.println("user3:user3123");
		 out.flush();
		 
		 if(fw !=null)
		 {
			 try
			 {
				 fw.close();
			 }
			 catch(IOException e)
			 {
				 e.printStackTrace();
			 }
		 }
	}
}
