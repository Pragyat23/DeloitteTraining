package Assignment;

public class Role {

	@Override
	public String toString() {
		return "Role [name=" + name + "]";
	}

	private String name;
	
	public static void main(String[] args) {
		
		

	}

	public Role(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
