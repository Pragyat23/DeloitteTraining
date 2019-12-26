package inheritpack;

public class CurrentAccount extends Account {


	
	public CurrentAccount(String name, int number, double balance) {
		super(name, number, balance);
		System.out.println("Current Account constructor called");
	}

	@Override
	public void withdraw(double amount)
	{
		balance-=amount;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
