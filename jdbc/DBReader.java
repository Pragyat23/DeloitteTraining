package jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.sql.Connection;
import java.sql.DatabaseMetaData;

public class DBReader {

	public static void main(String[] args) {
		//load the driver
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("driver not found"+e.getMessage());
		}
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String username="hr";
		String password="hr";
		
	//2. get connection to the database
		try {
			con=DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("connection failed"+e.getMessage());
		}
		//database metadata
		
			try {
				DatabaseMetaData dbmeta= con.getMetaData();
				System.out.println(dbmeta.toString());
				System.out.println(dbmeta.getDatabaseMajorVersion());
				System.out.println(dbmeta.getDatabaseProductName());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		//3. create a statement object
		String sql="select first_name,last_name,employee_id from employees ";
		try {
			Statement st= con.createStatement();
			//4. pass sql query string and execute statement
			ResultSet rs=st.executeQuery(sql);
			
			ResultSetMetaData rsmd=rs.getMetaData();
			int colCount =rsmd.getColumnCount();
			System.out.println(colCount);
			
			int colType=rsmd.getColumnType(1);
			if(colType==Types.INTEGER)
			{
				System.out.println("Col 1 has integer type");
			}
			else if(colType==Types.VARCHAR)
			{
				System.out.println("Col 1 is a string (varchar)");
			}
			else if(colType==Types.NUMERIC)
			{
				System.out.println("Col is of type Numeric");
			}
			
			System.out.println(rsmd.getColumnTypeName(3));
			
			while(rs.next()) {
				int id=rs.getInt(3);
				String fname=rs.getString(1);
				System.out.println(id);
			}
			rs.close();
			st.close();
			con.close();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
