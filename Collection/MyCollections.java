package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import Compare.Employee;

public class MyCollections {

	public static void main(String[] args) {
		
		System.out.println("VECTOR");

		Vector<String> v=new Vector<>(); 
		v.add("ankit");
		v.add("comp");
		v.add("mobile");
		v.add("pizza");
		System.out.println(v.size());
		
		System.out.println();
		System.out.println("1 for -----");

		int len=v.size();
		for(int i=0;i<len;i++)
		{
			System.out.println(v.get(i));
		}
		System.out.println("2 enhanced for -----");
		for(String s:v)
			System.out.println(s);
		
		
		System.out.println("3 enumeration -----");

		Enumeration<String> E=v.elements();
		while(E.hasMoreElements())
			System.out.println(E.nextElement());
		
		
		System.out.println("4 iterator -----");
		Iterator<String> it=v.iterator();
		while(it.hasNext())
			System.out.println(it.next());
		
		
		System.out.println("ARRAY LIST");
		ArrayList<Integer> list=new ArrayList<>();
		list.add(12);
		list.add(23);
		list.add(51);
		list.add(43);

		int sum=0;
		Iterator<Integer> iter=list.iterator();
		while(iter.hasNext()) {
			int i=iter.next();
			System.out.println(i);
			sum+=i;
		}
		System.out.println("sum is "+sum);
		System.out.println("sorted array");

		Collections.sort(list);System.out.println(list);
		
		List<Student> students=new ArrayList<>();
		students.add(new Student("asha",123));
		students.add(new Student("sasha",124));
		students.add(new Student("akash",126));
		students.add(new Student("amit",127));
		students.add(new Student("ananya",120));
		students.add(new Student("masha",122));
		students.add(new Student("lasha",121));

		System.out.println(students);
		Iterator<Student> sdit=students.iterator();
		while(sdit.hasNext())
		{
			Student st=sdit.next();
			System.out.println(st.getName());
		}
		
		System.out.println("Sorted object-by name");
		Collections.sort(students,new Comparator<Student>()
		{
	@Override
	public int compare(Student s1, Student s2) {
	return s1.getName().compareTo(s2.getName());
	}
		});
		
		
		sdit=students.iterator();
		while(sdit.hasNext())
		{
			Student st=sdit.next();
			System.out.println(st.getName());
		}


		System.out.println("Sorted object-by id");
		Collections.sort(students,new Comparator<Student>()
		{
	@Override
	public int compare(Student s1, Student s2) {
	return s1.getRoll()-(s2.getRoll());
	}
		});
		
		
		sdit=students.iterator();
		while(sdit.hasNext())
		{
			Student st=sdit.next();
			System.out.println(st.getRoll());
		}
		
		
		System.out.println("sort using separate class");
		Collections.sort(students,new StudentNameSorter());
		sdit=students.iterator();
		while(sdit.hasNext())
		{
			Student st=sdit.next();
			System.out.println(st.getName());
		}

		
		System.out.println("Print names strting with a");
		sdit=students.iterator();
		while(sdit.hasNext())
		{
			Student st=sdit.next();

			if(st.getName().charAt(0)=='a')
				System.out.println(st.getName());
		}
		
		System.out.println("Name Search");
		String search_name="amit";
		System.out.println(getRollNumber(students,search_name));
		
		
		
	}
	
	public static void sortByName(List<Student> students)
	{
		
	}
	
	public static int getRollNumber(List<Student> students ,String name)
	{
	
		for(Student s:students)
		{
			if(s.getName().equalsIgnoreCase(name))
				return s.getRoll();
		}
		
		return 0;
		
	}

}
