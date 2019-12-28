package Assignment;

public class TestEmployee {

	static Employee[] emps=new Employee[5];
	static Department[] depts=new Department[2];
	static Role[] roles=new Role[3];
	static int[] flag=new int[5];
	
	public static void main(String[] args) {

		
		Department dev=new Department("dev","Bangalore");
		Department test=new Department("test","Pune");
		
		Role manager=new Role("Manager");
		Role developer=new Role("Developer");
		Role tester=new Role("Tester");
		
		Employee e1=new Employee("John",123,120000,manager,dev,null);
		
		Employee e2=new Employee("Karan",124,130000,developer,dev,e1);
		
		Employee e3=new Employee("Ajay",123,120000,developer,dev,e1);

		Employee e4=new Employee("Nikhil",123,120000,manager,test,null);

		Employee e5=new Employee("Simon",123,120000,tester,test,e4);
		
		
		emps[0]=e1;
		emps[1]=e2;
		emps[2]=e3;
		emps[3]=e4;
		emps[4]=e5;
		
		depts[0]=dev;
		depts[1]=test;
		
		roles[0]=manager;
		roles[1]=developer;
		roles[2]=tester;
		System.out.println("List of employees-----------");
		listEmployees();
		
		System.out.println("Employees in developer dept----------");
		departmentEmployees(dev);
		
		System.out.println("Employees of Developer role-------- ");
		roleEmployees(developer);
		//employeeNoDept();
		
		System.out.println(" Incrementing salaray-------- ");
		incrementSalary(developer,10);
		System.out.println("List of employees with incremented salary------");
		
		employeeIncrementSalary();
		
		System.out.println("List of employees of Manager John-----");
		managersEmployee("John");

	}
	
		
	private static void managersEmployee(String name) {
		
		for(Employee e:emps)
		{
			if(e.getManager()!=null)
			{
			
				String m=e.getManager().getName();
				if(m.equalsIgnoreCase(name))
				{
					System.out.println(e.getName());
				}
			}
			
		}
	}


	public static void listEmployees()
	{
		for(Employee e:emps)
		{
				System.out.println(e);
		}
		
	}
	
	public static void departmentEmployees(Department d)
	{
		String dept=d.getName();
		for(Employee e:emps)
		{
			String department=e.getDepartment().getName();
			if(department.equalsIgnoreCase(dept))
			{
				System.out.println(e.getName());
			}
		}
	}
	
	public static void roleEmployees(Role r)
	{
		String role=r.getName();
		for(Employee e:emps)
		{
			String roleEmp=e.getRole().getName();
			if(roleEmp.equalsIgnoreCase(role))
			{
				System.out.println(e.getName());
			}
		}
	}
	
	public static void incrementSalary(Role r,int x)
	{
		int c=0;
		String role=r.getName();
		for(Employee e:emps)
		{
			String roleEmp=e.getRole().getName();
			if(roleEmp.equalsIgnoreCase(role))
			{
				System.out.println(e.getName());
				e.setSalary(e.getSalary()+e.getSalary()*x/100);
				e.setSalaryIncr(true);
			}
			
		}
	}
	
	
	public static void employeeIncrementSalary()
	{
		
		for(Employee e:emps)
		{
			if(e.isSalaryIncr())
				System.out.println(e);
			
		}
	}
	
}
