package deloitte;

public class Person {

	//instance variables=non static=called using object
	private String name;
	private long mobileNumber;
	private static int c=0;
	
	//default or no arg constructor
	public Person()
	{
		c++;
	}
	
	public Person(String name,long num)
	{
		this();

		this.name=name;
		mobileNumber=num;
				
	}
	
	public Person(String name)
	{
		this(name,0L);

				
	}
	//setter or mutator
	public void setName(String name)
	{
		this.name=name;
	}
	
	//getter or accessor
	public String getName()
	{
		return name;
	}
	
	public void setMobileNumber(long num)
	{
		mobileNumber=num;
	}
	public long getMobileNumber()
	{
		return mobileNumber;
	}
	
	
	@Override
	public String toString()
	{
		return name+":"+mobileNumber;
	}
	
	public static void main(String[] args) {
		Person neha=new Person();
		neha.setName("Nehar sss");
		neha.setMobileNumber(991111111);

		System.out.println(neha.getName());
		System.out.println(neha.getMobileNumber());
		
		Person sneha=new Person();
		sneha.setName("ssssNehar sss");
		sneha.setMobileNumber(991111111);

		System.out.println(sneha.getName());
		System.out.println(sneha.getMobileNumber());
		System.out.println(c);

		System.out.println(neha);
		Person tan=new Person("tan",9900000);
		System.out.println(tan);
		System.out.println(c);
		
		Person ban=new Person("ban");
		System.out.println(ban);
		System.out.println(c);
		
		Person[] person_arr=new Person[8];
		person_arr[0]=neha;
		System.out.println(person_arr[0]);

	}

}
