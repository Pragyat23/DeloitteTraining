package AssignmentEmployee;

public class Department {
	
	protected String location;
	private String name;
	

	@Override
	public String toString() {
		return "Department [location=" + location + ", name=" + name + "]";
	}


	public Department(String location,String name) {
		super();
		this.location = location;
		this.name=name;
	}


	public String getLocation() {
		return location;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public static void main(String[] args) {
		

	}

}
