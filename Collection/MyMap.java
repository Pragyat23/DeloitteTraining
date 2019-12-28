package Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyMap {

	public static void main(String[] args) {

	Map<Integer,String> map=new HashMap<>();
	map.put(1, "laptop");
	map.put(2, "mobile");
	map.put(3, "tablet");
	map.put(4, "desktop");
	
	String device=map.get(3);
	System.out.println(device);
	Set<Integer> set=map.keySet();
	Iterator<Integer> itr=set.iterator();
	while(itr.hasNext())
	{
		Integer key=itr.next();
		String value=map.get(key);
		System.out.println(key+" : "+value);
	}
	
	List<Student> students=new ArrayList<>();
	students.add(new Student("asha",123));
	students.add(new Student("sasha",124));
	students.add(new Student("akash",126));
	students.add(new Student("amit",127));
	students.add(new Student("ananya",120));
	students.add(new Student("masha",122));
	students.add(new Student("lasha",121));

	Map<Integer,String> studmap=new HashMap<>();
	Iterator<Student> itr1=students.iterator();
	while(itr1.hasNext())
	{
		Student s=itr1.next();
		String name=s.getName();
		int roll=s.getRoll();
		System.out.println(name+":"+roll);
		studmap.put(roll,name);
	}
	
	getStudentName(123,studmap);
	
	}
	
	public static void getStudentName(int roll,Map<Integer,String> studmap)
	{
//		Set<Integer> set=studmap.keySet();
//		Iterator<Integer> itr=set.iterator();
//		while(itr.hasNext())
//		{
//			Integer key=itr.next();
//			String name="";
//			if(key==roll)
//			{
//				name=studmap.get(key);
//				System.out.println("Name found"+name);
//
//			}
//		}
		System.out.println("-----debug-----"+roll+"\n"+studmap);
		if(studmap.containsKey(roll))
		{
			String st=studmap.get(roll);
			System.out.println("name is "+st);

		}
	}

}
