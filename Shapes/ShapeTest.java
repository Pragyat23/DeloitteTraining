package Shapes;

public class ShapeTest {

	public static void main(String[] args) {

		Shape box=new Rectangle(20,30);
		box.computeArea();
		box.computePerimeter();
		System.out.println(box.toString());
		
		Shape box1=new Square(20);
		box1.computeArea();
		box1.computePerimeter();
		System.out.println(box1.toString());
		
		//draw(new ShapeDrawer(),box);
		
		ShapeDrawer sd=new ShapeDrawer();
		draw(sd,box);
		 
		
		//anonymous inner class
		Drawable d=new Drawable()
				{
					@Override
					public void draw(Shape s)
					{
						if(s instanceof Rectangle)
							System.out.println("Drawing rectangle shape using my drawable");
						if(s instanceof Square)
							System.out.println("Drawing square shape using my drawable");
							
					
					}
					
				};
				
			draw(d,box); //anonymous inner class
			draw(new MyDrawable(),box);//named inner class
				
		
	}
	
	public static void draw(Drawable d,Shape s)
	{
		d.draw(s);
	}


//named inner class
static class MyDrawable implements Drawable
{
	@Override
	public void draw(Shape s)
	{
		if(s instanceof Rectangle)
			System.out.println("Drawing rectangle shape using my drawable");
		if(s instanceof Square)
			System.out.println("Drawing square shape using my drawable");
			
	
	}
}
}
