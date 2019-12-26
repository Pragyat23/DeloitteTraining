package Shapes;

public class ShapeDrawer implements Drawable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Shape s) {

		if(s instanceof Rectangle)
		{
			System.out.println("Drawing a rectangle");
		}
		else if( s instanceof Square)
		{
			System.out.println("Drawing a square");
		}
	}

}
