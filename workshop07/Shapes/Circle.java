package Shapes;

public class Circle implements Shape {
	
	private double radius;
	private final double PI= Math.PI;
	public ShapeArea area;
	// constructor
	public Circle(double radius) throws CircleException {
		setRadius(radius);
		
        area = () -> this.radius * this.radius * PI;

	}

	// setters
	public void setRadius(double radius) throws CircleException {
		if(radius > 0) {
			this.radius = radius;
		}else {
			throw new CircleException("Invalid radius!");
		}
	}

	// getters
	public double getRadius() {
		return radius;
	}
	
	@Override
	public double getPerimeter() {
		return (getRadius() * 2) * PI;
	}


	@Override
	public String toString() {
		return String.format("%s {r=%s} {area=%s}",this.getClass().getSimpleName(), this.getRadius(), area.getArea());
	}
}

