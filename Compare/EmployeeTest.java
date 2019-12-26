package Compare;

public class EmployeeTest {

	public static void main(String[] args) {

		Employee e1=new Employee("Akhil b",123);
		Employee e2=new Employee("Akhil b",567);
		Employee e3=new Employee("Akhil b",123);


		System.out.println(e1.equals(e2));
		System.out.println(e1.equals(e3));

	}

}
