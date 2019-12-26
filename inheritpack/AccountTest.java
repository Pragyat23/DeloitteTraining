package inheritpack;

public class AccountTest {

	public static void showBalance(Account ac) //dynamic invocation- all sub types Account, savings, current acceptable
	{
		System.out.println(ac.getBalance());
	}
	
	public static void printAccount(Account ac,Printer p)
	{
		ac.print("from accounts " );
		p.print("from printer class");
	}
	
	public static void main(String[] args) {

		SavingsAccount sa=new SavingsAccount("Neha",123,100000);
		System.out.println(sa);
		sa.withdraw(4000);
		System.out.println(sa);
		
		CurrentAccount ca=new CurrentAccount("Dolla",121,200000);
		System.out.println(ca);
		ca.withdraw(1000);
		System.out.println(ca);
		
		Account ac=new SavingsAccount("Amit",670,300000);
		System.out.println(ac);
		ac.withdraw(5000);
		System.out.println(ac);
		
		showBalance(sa); //dynamic invocation
		showBalance(ac);
		
		ac.print("hello account");
		sa.print("from saving");
		ac.print("hello account");

		
		printAccount(ac,new  ConsolePrinter());
		printAccount(ac,new FilePrinter());
	}

}
