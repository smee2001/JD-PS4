import processing.core.PApplet;

public abstract class GeometricShape implements AreaInformation, RenderingAlgorithm {
		
		double area;
		float initx;
		float inity;
		PApplet p;
	  
	  public double getArea() { 
		  return area;
	  } 
	  
	  public void setArea(double area) { this.area = area; } 

}
