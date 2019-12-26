package Shapes;

public class Square extends Shape {

	public Square(double length) {
		super(length);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String toString() {
		return "Sqaure ";
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void computeArea() {
		System.out.println("Area= "+ length*length);
		
	}

	@Override
	public void computePerimeter() {
		System.out.println("perimeter= "+ 4*(length));
		
	}

}
