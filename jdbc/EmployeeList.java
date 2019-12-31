package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeList {
	
	Connection con=null;
	List<Employee> emps=new ArrayList<>();

	public void EmployeeListBeforeDate(String date) 
	{
		DBConnector connector=new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con=connector.getConnection();
		String sql="select employee_id, first_name,last_name,department_id,salary,to_char(hire_date,'DD-MON-YYYY') as hire_date from employees where hire_date<?";
		try 
		{
			PreparedStatement pst=con.prepareStatement(sql);//prepared statement is pre compiled
			pst.setString(1, date);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
					{
					int id=rs.getInt(1);
					String fname=rs.getString(2);
					String lname=rs.getString(3);
					int depId=rs.getInt(4);
					double sal=rs.getDouble(5);
					String jdate=rs.getString(6);
					SimpleDateFormat sdf=new SimpleDateFormat("DD-MMM-YYYY");
					Date joinDate=null;
					try {
						joinDate = sdf.parse(jdate);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Employee e=new Employee(id,fname+" "+lname,depId,joinDate,sal);
					emps.add(e);
					System.out.println(e);
					//System.out.println(rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3));
					}
		}
		catch (SQLException e)
		{
			
			System.out.println(e);
		}
	}
	
	
	public void listEmployeesByDept(String deptName)
	{
		DBConnector connector=new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con=connector.getConnection();
		String sql="select * from employees where department_id=(select department_id from departments where department_name='"+deptName+"')";
		try 
		{
			PreparedStatement pst=con.prepareStatement(sql);//prepared statement is pre compiled
			
			ResultSet rs=pst.executeQuery();
			while(rs.next())
					{
						System.out.println(rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3));
					}
		}
		catch (SQLException e)
		{
			
			System.out.println(e);
		}
	}
	
	public void listEmployeesByDept(int dept)
	{
		DBConnector connector=new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con=connector.getConnection();
		//String sql="select * from employees where department_id="+dept;
		String sql="select * from employees where department_id=?";//? is place holder

		try 
		{
			PreparedStatement pst=con.prepareStatement(sql);//prepared statement is pre compiled else every time new obj is created
			pst.setInt(1, dept);//1 is for 1st Qmark,there can be many
			ResultSet rs=pst.executeQuery();
			while(rs.next())
					{
						System.out.println(rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3));
					}
		}
		catch (SQLException e)
		{
			
			System.out.println(e);
		}
	}

	public static void main(String[] args)
	{
		EmployeeList list= new EmployeeList();
		list.listEmployeesByDept("Executive");
		list.listEmployeesByDept(90);
		list.EmployeeListBeforeDate("01-JAN-10");
		System.out.println(list.emps.size());
	}

}
