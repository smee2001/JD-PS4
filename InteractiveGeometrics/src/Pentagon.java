import processing.core.PApplet;

public class Pentagon extends GeometricShape{

	float sidelength;
	
	public Pentagon(float sidelength, float initx, float inity, PApplet p) {
		
		this.initx = initx;
		this.inity = inity;
		this.sidelength = sidelength;
		this.p = p;
		
		this.setArea(calculateArea());
	}
	
	public double calculateArea() {
		return 1.72048 * sidelength * sidelength;
	}

	public void render() {
		
		float curx = initx;
		float cury = inity;
		
		p.beginShape();
			p.vertex(curx, cury);
				curx += sidelength;
			p.vertex(curx, cury);
				curx = curx + sidelength*p.cos(p.radians(72));
				cury = cury - sidelength*p.sin(p.radians(72));
			p.vertex(curx, cury);
				curx = initx + (sidelength / 2);
				cury = cury - sidelength*p.cos(p.radians(54));
			p.vertex(curx, cury);
				curx = initx - sidelength*p.cos(p.radians(72));
				cury = inity - sidelength*p.sin(p.radians(72));
			p.vertex(curx, cury);
		p.endShape();		
		
	}
	
}
