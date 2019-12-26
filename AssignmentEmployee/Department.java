package AssignmentEmployee;

public class Department {

	protected String name; //city
	protected String location; //city
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Department(String location,String name) {
		super();
		this.location = location;
		this.name=name;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", location=" + location + "]";
	}


}
