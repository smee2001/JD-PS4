import java.util.*;
import processing.core.*;
import controlP5.*;

public class ShipShaper extends PApplet{

	Map<String, List<GeometricShape>> shapeMap = new HashMap<String, List<GeometricShape>>();
	
	List<GeometricShape> hexagons = new ArrayList<GeometricShape>();
	List<GeometricShape> pentagons = new ArrayList<GeometricShape>();
	List<GeometricShape> circles = new ArrayList<GeometricShape>();

	ControlP5 cp5;
	Textfield shapeIn;
	Slider numIn;
	Button showBut;
	
	Textarea txtArea;
	
	ListBox shapeList;
	
	public void setup () {
		size(640, 480);
		background(0);
		smooth();
		
		cp5 = new ControlP5(this);
		
//		shapeIn = cp5.addTextfield("What shape?", 10, 10, 250, 30);
		numIn = cp5.addSlider("How many?", 1, 10, 270, 10, 200, 20);
		numIn.setNumberOfTickMarks(10);
		showBut = cp5.addButton("SHOW", 1, 550, 10, 30, 20);
		
		txtArea = cp5.addTextarea("txTarea", "Total area = 0", 10, 440, 200, 20);
		txtArea.setColorLabel(255);
		
		shapeList = cp5.addListBox("What shape?", 10, 20, 250, 60);
		shapeList.actAsPulldownMenu(true);
		shapeList.addItem("Pentagon", 1);
		shapeList.addItem("Hexagon", 2);
		shapeList.addItem("Circle", 3);

		//Pentagons
		for (int i = 0; i < 10; i++) {
			float randSide = random(1, 100);
			float randX = random(0, 640 - randSide);
			float randY = random(randSide, 480);
			
			Pentagon pentRand = new Pentagon(randSide, randX, randY, this);
			
			pentagons.add(pentRand);
			
		}
		
		//Hexagons
		for (int i = 0; i < 10; i++) {
			float randSide = random(1, 100);
			float randX = random(0, 640 - randSide);
			float randY = random(randSide, 480);
			
			Hexagon hexRand = new Hexagon(randSide, randX, randY, this);
			
			hexagons.add(hexRand);
			
		}
	
		//Circles
		for (int i = 0; i < 10; i++) {
			float randSide = random(1, 100);
			float randX = random(0, 640 - randSide);
			float randY = random(randSide, 480);
			
			Circle circRand = new Circle(randSide, randX, randY, this);
			
			circles.add(circRand);
			
		}
		
		shapeMap.put("pentagon", pentagons);
		shapeMap.put("hexagon", hexagons);
		shapeMap.put("circle", circles);
	
	}
	
	public void draw () {
		
		background(0);
		
		if (showBut.booleanValue() && shapeList.value()!=0) {
			
			List<GeometricShape> shapes = new ArrayList<GeometricShape>();
			
			if(shapeList.value()==1){
				shapes = shapeMap.get("pentagon");
			}
			else if(shapeList.value()==2){
				shapes = shapeMap.get("hexagon");
			}
			else {
				shapes = shapeMap.get("circle");
			}
			
			showBut.setCaptionLabel("HIDE");
			
			int numHex = (int)numIn.value();
			double totalArea = 0;
			
			fill(125);
			
			for (int i = 0; i < numHex; i++) {
								
				if(shapeList.value()==1){
					Pentagon drawPent = (Pentagon)shapes.get(i);
					drawPent.render();
					totalArea+=drawPent.getArea();
				}
				else if(shapeList.value()==2){
					Hexagon drawHex = (Hexagon)shapes.get(i);
					drawHex.render();
					totalArea+=drawHex.getArea();
				}
				else {
					Circle drawCirc = (Circle)shapes.get(i);
					drawCirc.render();
					totalArea+=drawCirc.getArea();
				}
	
			}
			
			String totalAreaOut = "Total Area = " + Double.toString(totalArea);
			txtArea.setText(totalAreaOut);
			
		}
		else {
			showBut.setSwitch(false);
			showBut.setCaptionLabel("SHOW");
			txtArea.setText("Total Area = 0");
		}
		
	}
	
	public static void main(String[] args) {
		PApplet.main(new String[] {"ShipShaper" });

	}

}
