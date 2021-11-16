package Shapes;

public class Square extends Rectangle{
	
	public ShapeArea area;

	public Square(double side) throws ParallelogramException, SquareException{
		super(side,side);
		
		area = () -> getWidth() * getWidth();
	}


	@Override
	public void setHeight(double side) throws ParallelogramException{
		super.setHeight(side);
	} 
	
	
	@Override
	public void setWidth(double side) throws ParallelogramException {
		super.setWidth(side);	
		 
	}
	
	
	@Override
	public String toString() {
		return String.format( "%s {s=%s} {area=%s}", this.getClass().getSimpleName(), this.getWidth(), area.getArea());

	}
}
