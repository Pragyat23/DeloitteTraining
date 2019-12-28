package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class FileCopierBinary {

	public static void main(String[] args) {
		
		if(args.length <2)
		{
			System.out.println("Usage: java FileCopier infile outFile");
		}
		
		else
			
		{String inFile=args[0];
		String outFile=args[1];
		
		InputStream in;
	
		FileInputStream fis=null;
		
		try 
		{
			fis=new FileInputStream(inFile);
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		
		FileOutputStream fout=null;
		PrintStream out=null;
		try 
		{
			fout=new FileOutputStream(outFile);
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		
		out=new PrintStream(fout);
		try 
		{
			int bite = fis.read();
			while(bite!=-1)
			{
				out.print((char)bite);
				bite=fis.read();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		finally
		{
			if(fis!=null)
			{
				try
				 {
					 fis.close();
				 }
				 catch(IOException e)
				 {
					 e.printStackTrace();
				 }
			}
		}

	}

}}
