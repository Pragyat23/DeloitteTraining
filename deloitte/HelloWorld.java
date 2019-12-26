package deloitte;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("hiiiiiiiiiiii ");
		String s="hellloooo";
		String s1=new String("hellloooo");
		System.out.println(s);
		System.out.println((s.equals(s1))?"y":"n");
		//System.out.print(10/0);
		int a='A',z='Z';
		for(int i='0';i<='9';i++)
		{System.out.print(i+" ");
	}
		System.out.println();
		
		int m=200,n=0;
		//swapRef(&m,&n);
		rangeSum(m,n);
		String op="//";
		calculate(m,n,op);
	}
	
	public static void rangeSum(int m,int n)
	{
		int s=0;

		if(m>n)
			swap(m,n);
		else
		{
			for(int i=m;i<=n;i++)
			{
				s=s+i;
			}
			System.out.println(s);

		}

	}
	
	public static void swap(int m,int n)
	{
		int temp=m;
		m=n;
		n=temp;
		rangeSum(m,n);
	}
	
	public static void swapRef(int m,int n)
	{
		int t=m;m=n;n=t;
	}
	
	public static void calculate(int m,int n,String op)
	{
		switch (op)
		{
		case"+":
			System.out.println(m+n);break;
		case"-":
			System.out.println(m-n);break;
		case"*":
			System.out.println(m*n);break;
		case"/":
			if(n==0)
				System.out.println("error");
			else
				System.out.println(m/n);
			break;
		default:
			System.out.println("default");
			
		}
			
	}

}
