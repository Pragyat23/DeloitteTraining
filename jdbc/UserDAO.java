package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Data Access Object
public class UserDAO {
	
	Connection con=null;
	List<User> users=new ArrayList<>();
	List<Role> roles=new ArrayList<>();
	
	public UserDAO()
	{
		DBConnector connector=new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con=connector.getConnection();
	}

	public static void main(String[] args) {
		
		
		UserDAO obj=new UserDAO();
		obj.listUsers();
		obj.printUsers();
		obj.returnRole("pragyat");
		
		
	}
	
	public void listUsers()
	{
		
		String sql="select u.id,u.name,u.username,u.password,u.email,u.mobile,r.role_id,r.role_name,r.priv from users u,role r where u.role_id=r.role_id";//? is place holder
		try 
		{
			PreparedStatement pst=con.prepareStatement(sql);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next())
					{
						int id=rs.getInt(1);
						String name=rs.getString(2);
						String username=rs.getString(3);
						String password=rs.getString(4);
						String email=rs.getString(5);
						String mobile=rs.getString(6);
						int role_id=rs.getInt(7);
						String role_name=rs.getString(8);
						String priv=rs.getString(9);
						
						Role r =new Role(role_id,role_name,priv);
						roles.add(r);
						User u=new User(id,name,username,password,email,r,mobile);
						users.add(u);
				System.out.println(u);
					}
		}
		catch (SQLException e)
		{
			
			System.out.println(e);
		}
	}
	
	public void printUsers()
	{
		Iterator<User> itr=users.iterator();
		System.out.println("id\tname\tuname\tpwd\temail\trole");

		while(itr.hasNext())
		{
			//System.out.println(itr.next());
			User usr=itr.next();
			String name=usr.getName();
			String pwd="****";
			String email=usr.getEmail();
			String uname=usr.getUsername();
			int id=usr.getId();
			String role=usr.getRole().getRole_name();
			System.out.println(id+"\t"+name +"\t"+uname+"\t"+pwd+"\t"+email+"\t"+role);
		}
				
	}
	public void returnRole(String name)
	{
		Iterator<User> itr=users.iterator();
		

		while(itr.hasNext())
		{
			
			//System.out.println(itr.next());
			User usr=itr.next();
			if(usr.getName().equals(name))
			{
				System.out.println(usr.getRole().getRole_name());
			}
			
		}
			
	}
}
