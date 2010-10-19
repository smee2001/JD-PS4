
import processing.core.PApplet;

public class Hexagon extends GeometricShape{

	float sidelength;
	
	public Hexagon(float sidelength, float initx, float inity, PApplet p) {
		
		this.initx = initx;
		this.inity = inity;
		this.sidelength = sidelength;
		this.p = p;
		
		this.setArea(calculateArea());
	}
	
	public double calculateArea() {
		return 2.59808 * sidelength * sidelength;
	}

	public void render() {
		
		float curx = initx;
		float cury = inity;
		
		p.beginShape();
			p.vertex(curx, cury);
				curx += sidelength;
			p.vertex(curx, cury);
				curx = curx + sidelength*p.cos(p.radians(60));
				cury = cury - sidelength*p.sin(p.radians(60));
			p.vertex(curx, cury);
				curx = initx + sidelength;
				cury = cury - sidelength*p.sin(p.radians(60));
			p.vertex(curx, cury);
				curx = initx;
			p.vertex(curx, cury);
				curx = initx - sidelength*p.cos(p.radians(60));
				cury = inity - sidelength*p.sin(p.radians(60));
			p.vertex(curx, cury);
		p.endShape();
		
	}
	
}