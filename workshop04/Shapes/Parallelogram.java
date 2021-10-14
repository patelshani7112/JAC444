package Shapes;

public class Parallelogram implements Shape{
	
	private double width;
	private double height;

	// constructor
	public Parallelogram(double width, double height) throws ParallelogramException{
		setWidth(width);
		setHeight(height);
	}	

	// setters
	public void setWidth(double width) throws ParallelogramException {
		if(width> 0) {
			this.width = width;
		}else {
			throw new ParallelogramException("Invalid side!");
		}
	}
	
	public void setHeight(double height) throws ParallelogramException {
		if(height > 0) {
			this.height =  height;
		}else {
			throw new ParallelogramException("Invalid side!");
		}
	}
	
	// getters
	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
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

