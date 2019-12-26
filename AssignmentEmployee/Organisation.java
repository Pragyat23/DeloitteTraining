package AssignmentEmployee;

public class Organisation {
	
	static Employee[] emps=new Employee[5];
	static Department[] depts=new Department[3];
	
	
	
	
	public static void main(String[] args) {
		
		Department hr=new Department("Delhi","hr");
		Department dev=new Department("Pune","dev");
		Department test=new Department("Mumbai","test");
		
		depts[0]=hr;
		depts[1]=dev;
		depts[2]=test;
		
		
		Address a1=new Address(12,"JCity","Hyd","TS");
		Employee e1=new Employee("Raj",a1,123,hr);
		
		Address a2=new Address(12,"JCity","Hyd","TS");
		Employee e2=new Employee("Neha",a1,181,dev);
		
		Address a3=new Address(12,"JCity","Hyd","TS");
		Employee e3=new Employee("Karan",a1,25,test);
		
		Address a4=new Address(12,"JCity","Hyd","TS");
		Employee e4=new Employee("Raj",a1,311,hr);
		
		Address a5=new Address(12,"JCity","Hyd","TS");
		Employee e5=new Employee("Rohan",a1,110,null);
		
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e5);
		
		emps[0]=e1;
		emps[1]=e2;
		emps[2]=e3;
		emps[3]=e4;
		emps[4]=e5;
		
		printEmployees("hr");
		getDepartment("Karan");
		EmployeeNoDept();
		
		}
	
	public static void printEmployees(String dept)
	{
		Department d_get=null;
		for(Department d:depts)
		{
			if(d.getName().equalsIgnoreCase(dept))
			{
				d_get=d;
				break;
			}
		}
		for(Employee e:emps)
		{
			if(e.getDept()==d_get)
			{
				System.out.println(e.getName());
			}
			
		}
	}
	
	public static void getDepartment(String empName)
	{
		for (Employee e:emps)
		{
			if(e.getName().equalsIgnoreCase(empName))
			{
				System.out.println(e.getDept());
			}
			}
		}
	
	public static void EmployeeNoDept()
	{
		for(Employee e:emps)
		{
			Department d=e.getDept();
			if(d==null)
			{
				System.out.println(e.getName());
			}
		}
	}
		
	}

