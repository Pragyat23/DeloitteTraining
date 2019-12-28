package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserPassword {

	
	private static String fileName="D://userpass.txt";
	public static void main(String[] args) {
		
		
		File file = new File(fileName);
		boolean fileExists = file.exists();
		System.out.println("file available? "+fileExists);
		if(fileExists)
		{		
		//System.out.println(file.getPath());
		
		FileReader reader = null;
		BufferedReader buffer = null;
		//read file content
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			e.printStackTrace();
		}
		 buffer = new BufferedReader(reader);
		 String line="";
		 String[] arr=new String[2];
		
		 try {
			 line=buffer.readLine();
			 
		 
			 while(line !=null) 
			 {
				 arr=line.split(":");
				 //System.out.println(arr.toString());
				 System.out.println("Username is "+arr[0]+" Password is "+arr[1]);
				 line=buffer.readLine();
			 }
		 }
		 catch (IOException e)
		 {
			 System.out.println("Error reading file"+e.getMessage());
		 }
		finally {
			if(buffer !=null)
			{
				try 
				{
					reader.close();
				}
				catch(IOException e){
					e.printStackTrace();
					
				}
			}
			if(reader !=null)
			{
				try
				{
					reader.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
					
				}
			}
		}
	}
}

}
