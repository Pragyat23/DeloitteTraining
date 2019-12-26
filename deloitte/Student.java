package deloitte;

public class Student {
	private String name;
	private int rollnumber;
	
	Student(String name, int roll)
	{
		this.name=name;
		this.rollnumber=rollnumber;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", rollnumber=" + rollnumber + "]";
	}

	public static void main(String[] args) {

		
	}

}
