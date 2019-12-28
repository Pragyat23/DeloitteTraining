package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileCopier{

			
					private static String fileNameNew="D://data2.txt";
					private static String fileName="D://data.txt";
					public static void main(String[] args) {
					
					File file = new File(fileName);
					boolean fileExists = file.exists();
					System.out.println("file available? "+fileExists);
					if(fileExists)
				{		
				//System.out.println(file.getPath());
				FileWriter fw=null;
				FileReader reader = null;
				BufferedReader buffer = null;
				boolean a=true;
				//read file content
				try {
					reader = new FileReader(file);
				} catch (FileNotFoundException e) {
					System.out.println("file not found");
					e.printStackTrace();
				}
				 try 
				 {
					fw=new FileWriter(fileNameNew,a);
					
				 }
				 catch(IOException e)
				 {
					 e.printStackTrace();
				 }
				 PrintWriter out = null;
				 out = new PrintWriter(fw);
				 buffer = new BufferedReader(reader);
				 String line="";
				 try {
					 line=buffer.readLine();
				 
					 while(line !=null) 
					 {
						out.println(line);
						 // System.out.println(line);
						line=buffer.readLine();
						out.flush();
						
					 }
					 System.out.println("File copied");
				 }catch (IOException e)
				 {
					 System.out.println("Error reading file"+e.getMessage());
				 }
				
				}

	}

}
