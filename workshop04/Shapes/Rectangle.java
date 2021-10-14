package Shapes;

public class Rectangle extends Parallelogram {
	
	public Rectangle(double width, double height) throws ParallelogramException {
		super(width,height);
	}

	
	@Override
	public double getPerimeter() {
		return  (getWidth() + getHeight())*2;
	}

	@Override
	public String toString() {
		return String.format( "%s {w=%s, h=%s} ", this.getClass().getSimpleName(), this.getWidth(), this.getHeight());
	}
}
