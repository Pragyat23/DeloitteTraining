package deloitte;

import java.util.Arrays;

public class MultiAcc {

	private int withdrawLimit, totalAmount;
	private Account[] accts;
	int count=0;
	int limit=3;
	Account currentAccHolder;
	
	@Override
	public String toString() {
		return "MultiAccAtm [accts=" + Arrays.toString(accts) + "]";
	}

	public MultiAcc(int withdrawLimit, int totalAmount) {
		this.withdrawLimit = withdrawLimit;
		this.totalAmount = totalAmount;
		accts= new Account[limit];
	}
	
	public void addAccount(Account ac) {
		if(count<limit) {
			accts[count++]=ac;
		}
	}
	
	public boolean validatePin(int pin) {
		for(Account act: accts) {
			if(act.getAccPin()==pin) {
				currentAccHolder=act;
				return true;
			}
		}
		return false;
	}

	
	public int withdraw(int amt,int pin) {
		if(validatePin(pin)) {
			if(amt<=withdrawLimit) {
				if(amt< currentAccHolder.getAccBalance()-Account.minBalance) {
					totalAmount-=amt;
					currentAccHolder.setAccBalance(currentAccHolder.getAccBalance()-amt);
					return amt;
				}
			}
		}
		return 0;
	}
	

	public double deposit(int amt,int pin) {
		if(validatePin(pin)) {
			totalAmount+=amt;
			currentAccHolder.setAccBalance(currentAccHolder.getAccBalance()+amt);
			return amt;
		}
		return 0.0;
	}
	
public static void main(String[] args) {
	// TODO Auto-generated method stub
	MultiAcc atm= new MultiAcc(4000,150000);
	
	
	Account p1=new Account("amit",20000,1234);
	atm.addAccount(p1);
	
	Account p2=new Account("xyz",30000,2345);
	atm.addAccount(p2);
	//atm.addAccount(p);
	atm.withdraw(3000,1234);
	atm.deposit(5000, 1234);
	System.out.println(atm);

	
}

		
}
