package AssignmentEmployee;

public class Address {
	
	protected int houseno;
	protected String street;
	protected String city;
	protected String state;

	@Override
	public String toString() {
		return "Address [houseno=" + houseno + ", street=" + street + ", city=" + city + ", state=" + state + "]";
	}

	public Address(int houseno, String street, String city, String state) {
		super();
		this.houseno = houseno;
		this.street = street;
		this.city = city;
		this.state = state;
	}

	public int getHouseno() {
		return houseno;
	}

	public void setHouseno(int houseno) {
		this.houseno = houseno;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public static void main(String[] args) {
		

	}

}
