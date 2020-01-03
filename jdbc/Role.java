package jdbc;

public class Role {
	
	public Role(int role_id, String role_name, String priv) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.priv = priv;
	}

	private int role_id;
	private String role_name;
	private String priv;

	public static void main(String[] args) {
		

	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getPriv() {
		return priv;
	}

	public void setPriv(String priv) {
		this.priv = priv;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_name=" + role_name + ", priv=" + priv + "]";
	}

}
