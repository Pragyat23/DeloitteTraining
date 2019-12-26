package inheritpack;

public class FilePrinter implements Printer{

	@Override
	public void print(String s) {

		System.out.println("writing to a file");		
	}
	

}
