package AssignmentEmployee;

public class Employee extends Person{

	protected Department dept;
	protected int id;

	public Employee(String name, int id, Department dept) {
		super(name);
		this.id=id;
		this.dept=dept;
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, int id, Department dep,Address addr) {
		super(name,addr);
		this.id=id;
		this.dept=dept;
		// TODO Auto-generated constructor stub
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
