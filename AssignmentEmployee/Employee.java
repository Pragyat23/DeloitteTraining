package AssignmentEmployee;

public class Employee extends Person {
	
	protected Department dept;
	protected int id;

	public Employee(String name, int id,Department dept)
	{
		super(name);
		this.id=id;
		this.dept=dept;				
	}

	@Override
	public String toString() {
		return "Employee [dept=" + dept + ", id=" + id + "]";
	}

	public Employee(String name,Address addr,int id,Department dept)
	{
		super(name,addr);
		this.id=id;
		this.dept=dept;
	}
		
	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static void main(String[] args) {
		

	}

}
