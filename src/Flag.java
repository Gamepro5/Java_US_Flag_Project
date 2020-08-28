// Flag starter code

 

/*

 * YOUR NAME HERE

 * YOUR PARTNER'S NAME HERE

 * OTHER PARTNER'S NAME (if group of three/four)

 */

 

import java.awt.Color;

import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JApplet;

 

public class Flag extends JApplet {

 private final int STRIPES = 13;

 

 // SCALE FACTORS (A through L)

 //

 // Note: Constants in Java should always be ALL_CAPS, even

 // if we are using single letters to represent them

    //

    // NOTE 2: Do not delete or change the names of any of the

    // variables given here

 

 // Set the constants to exactly what is specified in the documentation

 private final double A = 1.0;  // Hoist (width) of flag

 private final double B = 1.9;  // Fly (length) of flag

 private final double C = 0.5385;  // Hoist of Union

 private final double D = 0.76;  // Fly of Union

 private final double E = 0.054;  // See flag specification

 private final double F = 0.054;  // See flag specification

 private final double G = 0.063;  // See flag specification

 private final double H = 0.063;  // See flag specification

 private final double K = 0.0616;  // Diameter of star

 private final double L = 0.0769;  // Width of stripe


    // You will need to set values for these in paint()

 private int flag_width, flag_height, stripe_height, field_height, field_width, star_width, star_distance;
 

    // init() will automatically be called when an applet is run

 public void init() {

  // Choice of width = 1.9 * height to start off

  // 760 : 400 is ratio of FLY : HOIST
	 flag_height = 500;
  setSize(get_pixel_size(B), get_pixel_size(A));

  //repaint needs to be called for the Applet to update properly when resized
  
  repaint();

 }

public int get_pixel_size(double m) {
	
	return (int)(m * flag_height);
}

    // paint() will be called every time a resizing of an applet occurs

 public void paint(Graphics g) {

    flag_width = getWidth();   // width of applet  
    flag_height = getHeight();      // height of applet
    
    int new_flag_width = get_pixel_size(B);
    
    if (new_flag_width<=flag_width) {
 	   flag_width = new_flag_width;
    } else {
 	   flag_height = (int)(flag_width/B);
    }
    
    stripe_height = get_pixel_size(L);
    
    field_height = get_pixel_size(C);
    field_width = get_pixel_size(D);
    star_width = get_pixel_size(K);
    star_distance = get_pixel_size(H);
    

    // Figure out whether it is the flag_height or flag_width that is

    // the limiting factor on how to present the flag.

    //

    // Applets always repaint upon resizing

 

   
   //calculate stripe height
    
   

   //draw commands
    drawBackground(g);
    drawStripes(g);
    drawField(g);
        
    int x = get_pixel_size(G);
    int y = get_pixel_size(E);
    
    for(int  j=0; j < 9; ++j) {
        for(int i = 0; i < 11; ++i) {
	        if( (i+j) % 2 == 0) {
	            drawStar(g,x,y,star_width/2);
	        }
	        x += get_pixel_size(H);
    	}
        x = get_pixel_size(G);
        y += get_pixel_size(F);
    }
    
  /*
    for (int i=0;i<100;i++) {
    	if(i%2 == 0) {
    		
    		drawStar(g, i*star_distance+x_offset,(int)(E*flag_height),star_width);
    	}
    	x_offset += (int)(H * flag_height);
    }
    */
  }

 

 private void drawBackground(Graphics g) {

 }

 

 public void drawStripes(Graphics g) {

  //organization hint: make a Stripe class that contains a draw method
	 for (int i=0, y=0; i<13;i++, y+=stripe_height) {
		 if (i % 2 == 0) {
			 g.setColor(Color.red);
			 g.fillRect(0, y, flag_width, stripe_height);
		 }
	 }
 }

 

 public void drawField(Graphics g) {

  //organization hint: make a Field class that contains a draw method
	 g.setColor(Color.blue);
	 g.fillRect(0, 0, field_width, field_height);
 }

 

 public void drawStar(Graphics g, int centerXin, int centerYin, int outerRadius) {
	 	int centerX = centerXin;
		int centerY = centerYin;


		int rOut = outerRadius;  // a value I picked for the outer radius

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
		g.setColor(Color.WHITE);
		g.fillPolygon(x, y, 10);
		g.setColor(Color.WHITE);
		g.drawPolygon(x, y, 10);
  

 }

}
