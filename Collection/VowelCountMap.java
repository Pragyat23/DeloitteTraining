package Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VowelCountMap {

	
	
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		List<String> list=wordListCreation();
		Map<String,Integer> map=mapCreation(list);
		if(!map.isEmpty())
		{
			System.out.println(map);
			System.out.println("Enter a word to check the number of vowels in it");
			String str=sc.nextLine();
			displayVowelCount(str,map);
		}
		
		
	}
	
	public static void displayVowelCount(String str, Map<String, Integer> map)
	{
		if(map.containsKey(str))
				{
			System.out.println(map.get(str));
				}
	}
	
	public static List<String > wordListCreation()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter strings ---- quit to exit");
		ArrayList<String> list=new ArrayList<>();
		String str="";
		while(true)
		{
			str=sc.nextLine();
			if(str.equalsIgnoreCase("quit"))
					break;
			else
				
			list.add(str);
		}
		 
		return list;
	}
	
	public static int vowelCount(String s)
	{
		s.toLowerCase();
		int c=0;
		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
				c++;
		}
		
		return c;
	}
	
	public static Map<String,Integer> mapCreation(List<String> list)
	{
		
		Map<String,Integer> map=new HashMap<>();
		Iterator<String> iter=list.iterator();
		while(iter.hasNext()) {
			String s=iter.next();
			int vow=vowelCount(s);
			map.put(s, vow);
		}
		return map;
		
		
	}
	
	

}
