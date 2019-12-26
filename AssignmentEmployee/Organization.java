package AssignmentEmployee;

public class Organization {

	public static void main(String[] args) {

		Department hr=new Department("Mumbai","hr");
		Department dev=new Department("Bangalore","dev");
		Department test=new Department("Pune","test");
                                                  
		Address a1=new Address(12,"st1","hyd","ts");
		Employee e1=new Employee("Neha",123,hr,a1);
		

		Address a2=new Address(13,"st1","blr","ktaka");
		Employee e2=new Employee("Sneha",123,hr,a2);
		

		Address a3=new Address(14,"st1","delhi","delhi");
		Employee e3=new Employee("amit",123,hr,a3);

		Address a4=new Address(15,"st1","hyd","ts");
		Employee e4=new Employee("rohan",123,dev,a4);

		Address a5=new Address(16,"st1","hyd","ts");
		Employee e5=new Employee("raj",123,null,a5);
		
	}

}
