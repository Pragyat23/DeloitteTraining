package Shapes;

public class Rectangle extends Shape {

	public Rectangle(double length,double width) {
		
		super(length,width);
	}

	@Override
	public String toString() {
		return "Rectangle ";
	}

	@Override
	public void computeArea() {
		System.out.println("Area= "+ length*width);

	}

	@Override
	public void computePerimeter() {
		System.out.println("Perimeter= "+ 2*(length+width));

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
