package deloitte;

public class Course {

	private Student[] studs;
	private String sub1,sub2;
	private int counter=0,limit=3,numcourses=0;
	private Course[] courses=new Course[1];

	public Course() {
		studs=new Student[limit];
	}
	
	
	public Course(String sub1,String sub2)
	{
		this();
		this.sub1=sub1;
		this.sub2=sub2;
	}
	public void addStudents(Student s)
	{
		if(counter<limit)
			studs[counter++]=s;
		else
			System.out.println("full");
	}
	
	public void addCourse(Course c)
	{
		if(numcourses<limit)
			courses[numcourses++]=c;
	}
	
	public void display()
	{
		for (Student s:studs)
			System.out.println(s);
	}
	
	public void printStudentName(String subject)
	{
		for(Course c:courses)
		{
			if(c.sub1.equalsIgnoreCase(subject)||c.sub2.equalsIgnoreCase(subject))
			{
				for(Student ss:c.studs)
				{
					System.out.println(ss);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Course phy=new Course("phy1","phy2");
		phy.addStudents(new Student("Amit",12));
		phy.addStudents(new Student("sAmit",13));
		phy.display();
		phy.addCourse(phy);
		
		phy.printStudentName("phy1");
		
	}
	

}
