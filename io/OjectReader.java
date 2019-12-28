package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import Collection.Student;

public class OjectReader {

	public static void main(String[] args) {
		try
		{
			FileInputStream fis=new FileInputStream("D://std.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Student st = (Student)ois.readObject();
			System.out.println(st);
			ois.close();
		}
		catch(IOException ioe)
		{
			System.out.println("Object could not be read "+ioe.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("class not found "+e.getMessage());
		}
		

	}

}
