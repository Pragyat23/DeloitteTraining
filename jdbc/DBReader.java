package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBReader {
	
	

	public static void main(String[] args) {
		
		//1.load the driver
		Connection con=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Driver not found"+e.getMessage());
		}
		
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String username="hr";
		String password="hr";
		//2.Get connection
		try {
			con=DriverManager.getConnection(url,username,password);
		}
		catch (SQLException e) 
		{
			System.out.println("Connection failed. "+e.getMessage());
		}
		//3.Create statement object
		String sql="select count(*) from departments";
		try
		{
			Statement st= con.createStatement();
			//4.pass sql query string and execute statement
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())// to call cursor to first row, initially above first row
			{
//				String id=rs.getString("employee_id");//String id=rs.getString(1);
//				String fname=rs.getString("first_name");
//				String lname=rs.getString("last_name");
//				System.out.println(id+":"+fname+":"+lname);
				String dname=rs.getString(1);
				System.out.println(dname);
			}
			rs.close();
			st.close();
			con.close();
			
		}
		catch(SQLException sqle)
		{
			System.out.println((sqle.getMessage()));
		}
	}

}
