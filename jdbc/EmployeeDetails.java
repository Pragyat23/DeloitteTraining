package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
public class EmployeeDetails {

	Connection con=null;
	
	private static Map<String,String> map=new HashMap<>();
	
	public void listEmployeeDetails(String hireDate)
	{
		DBConnector connector=new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con=connector.getConnection();
		//String sql="select employee_id, last_name,hire_date from employees where hire_date<'"+hireDate+"'";
		String sql="select employee_id, last_name,hire_date from employees where hire_date<?";
		try 
		{
			PreparedStatement pst=con.prepareStatement(sql);//prepared statement is pre compiled
			pst.setString(1, hireDate);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
					{
				
				map.put(rs.getString(1), rs.getString(2));	
				System.out.println(rs.getString(2)+":"+rs.getString(3));
					}
		}
		catch (SQLException e)
		{
			
			System.out.println(e);
		}

	}
	public static void main(String[] args) {
		
		EmployeeDetails emp=new EmployeeDetails();
		emp.listEmployeeDetails("01-JAN-10");
		
		Set<String> set=map.keySet();
		Iterator<String> itr=set.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
		System.out.println("Map size is"+set.size());
	}

}
