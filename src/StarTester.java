import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JApplet;

//This class can be used to help you determine how to draw one star
public class StarTester extends JApplet {


	public void init(){
		setSize(500,500);
	}


	public void paint(Graphics g){

		int centerX = 100;
		int centerY = 100;


		int rOut = 50;  // a value I picked for the outer radius

		//calculate the inner radius using math!
		double innerRadius = rOut * 0.382;

		// the arrays of x and y coordinates of the star
		int[] x = new int[10];
		int[] y = new int[10];

		//determine how to fill in the arrays of the coordinates
		int temp = 0;
		 for (int i=0;i<10;i++) {
			 if (i%2==0) {
				 //temp = temp-(360/10);
				 x[i] = (int) (centerX+rOut*Math.cos(Math.toRadians(18+(72*temp))));
				 y[i] = (int) (centerY-rOut*Math.sin(Math.toRadians(18+(72*temp))));
				 //temp = temp+1;
			 } else {
				 //temp = temp-(360/10);
				 x[i] = (int) (centerX+innerRadius*Math.cos(Math.toRadians(54+(72*temp))));
				 y[i] = (int) (centerY-innerRadius*Math.sin(Math.toRadians(54+(72*temp))));
				 temp = temp+1;
			 }
		 }


		//actually drawing the star
		g.setColor(Color.BLACK);
		g.fillPolygon(x, y, 10);
		g.setColor(Color.RED);
		g.drawPolygon(x, y, 10);

}
}