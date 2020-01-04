package BookAssignment;

public class Publisher {
	
	private int publisher_id;
	private String publisher_name;
	private String city;

	public Publisher(int publisher_id, String publisher_name, String city) {
		super();
		this.publisher_id = publisher_id;
		this.publisher_name = publisher_name;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Publisher [publisher_id=" + publisher_id + ", publisher_name=" + publisher_name + ", city=" + city
				+ "]";
	}

	public int getPublisher_id() {
		return publisher_id;
	}

	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}

	public String getPublisher_name() {
		return publisher_name;
	}

	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public static void main(String[] args) {
		
		

	}

}
