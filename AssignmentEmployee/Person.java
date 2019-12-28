package AssignmentEmployee;

public class Person {

	protected String name;
	protected Address address;
	
	
	
	public Person(String name) {
		super();
		this.name = name;
	}

	public Person(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + "]";
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
