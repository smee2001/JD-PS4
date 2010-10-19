
import processing.core.PApplet;

public class Circle extends GeometricShape{

	float radius;
	
	public Circle(float radius, float initx, float inity, PApplet p) {
		
		this.initx = initx;
		this.inity = inity;
		this.radius = radius;
		this.p = p;
		
		this.setArea(calculateArea());
	}
	
	public double calculateArea() {
		return 3.14159 * radius * radius;
	}

	public void render() {
		p.ellipse(initx, inity, radius, radius);
		
	}
	
}
