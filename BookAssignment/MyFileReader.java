package BookAssignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class MyFileReader {

	
	private static String fileName="D://Books.txt";
	public static void main(String[] args) {
		
		File file = new File(fileName);
		boolean fileExists = file.exists();
		System.out.println("file available? "+fileExists);
		if(fileExists)
		{		
		System.out.println(file.getPath());
		
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
		// StringTokenizer st=new StringTokenizer();
		 try {
			 line=buffer.readLine();
		 
			 while(line !=null) 
			 {
				 System.out.println(line);
				 line=buffer.readLine();
			 }
		 }catch (IOException e)
		 {
			 System.out.println("Error reading file"+e.getMessage());
		 }
		
		}
		}
}
