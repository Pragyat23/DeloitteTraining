package inheritpack;

public abstract class Account implements Printer {

	protected String name;
	protected int number;
	protected double balance;
	
	
	public Account(String name, int number, double balance) {
		super();
		this.name = name;
		this.number = number;
		this.balance = balance;
		System.out.println("Account constructor called");
	}
	
	
	public void print(String s)
	{
		System.out.println("printing account info..."+s);
	}
	
	
	public abstract void withdraw(double amount);
	
	@Override
	public String toString() {
		return "Account [name=" + name + ", number=" + number + ", balance=" + balance + "]";
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
