package jdbc;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
	
	public Employee(int id, String fullName, int dept, Date joinDate, double salary) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.dept = dept;
		this.joinDate = joinDate;
		this.salary = salary;
	}
	int id;
	String fullName;
	int dept;
	Date joinDate;
	double salary;
	@Override
	public String toString() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-YYYY");

		String s=sdf.format(joinDate);
		return "Employee [id=" + id + ", fullName=" + fullName + ", dept=" + dept + ", joinDate=" + s
				+ ", salary=" + salary + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getDept() {
		return dept;
	}
	public void setDept(int dept) {
		this.dept = dept;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	

}
