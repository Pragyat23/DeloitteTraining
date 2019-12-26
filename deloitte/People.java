package deloitte;

public class People {

	private Person[] persons;
	int pers=5;
	int counter=0;
	
	public People()
	{
		persons=new Person[pers];
	}
	
	public void addPerson(Person p)
	{
		if (counter<pers)
			persons[counter++]=p;
	}
	
	
	public void displayPersons()
	{
		for(Person p:persons)
			System.out.println(p);
	}
	public static void main(String[] args) {

		People ppl=new People();
		ppl.addPerson(new Person("amit",9237837));
		ppl.addPerson(new Person("s",9237837));

		ppl.displayPersons();
	}

}
