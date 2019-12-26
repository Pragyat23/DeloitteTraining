package deloitte;

import java.util.Arrays;

public class MyArray {

	public static void main(String[] args) {
		//declaration, memory allocation, initialization
		int[] num= {1200,210,23,420,55,78};
		for(int i=0;i<num.length;i++)
		{
			System.out.println(num[i]*num[i]);
		}
		
		double[] amt; 
		amt=new double[5];
		System.out.println(amt);
		System.out.println(amt[0]);
		
		String[] a=new String[3];
		System.out.println(a[0]);
		String[] s= {"hi","hello"};
		stringLengths(args);
		change(s);
		System.out.println();
		for(int i=0;i<s.length;i++)
		{System.out.print(s[i]+" ");
		
	}
		intsort(num);
		Arrays.sort(num);
		for(int i=0;i<num.length;i++)
		{System.out.print(num[i]+" ");
	}
		
	
	}

	public static void stringLengths(String[] str)
	{
		for(int i=0;i<str.length;i++)
		{
			String a=str[i];
			int l=a.length();
			System.out.println(str[i]+ " "+l);
		}
	}
	
	public static void change(String[] s)
	{
		for(int i=0;i<s.length;i++)
		{
			s[i]=s[i]+"www";
		}
		for(int i=0;i<s.length;i++)
		{System.out.print(s[i]+" ");
	}
}
	public static void intsort(int[] num)
	{
		
	}
}
