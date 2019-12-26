package inheritpack;

public class SavingsAccount extends Account {

	private static final double MINIMUM=10000;
	
	public SavingsAccount(String name, int number, double balance) {
		super(name, number, balance);
		System.out.println("Savings Account constructor called");
	}
	
	public void print(String s)
	{
		super.print(s);
	}

	@Override
	public void withdraw(double amount)
	{
		if(balance-amount>=MINIMUM)
		{
			balance-=amount;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
