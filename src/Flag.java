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

 private final double F = E;  // See flag specification

 private final double G = 0.063;  // See flag specification

 private final double H = G;  // See flag specification

 private final double K = 0.0616;  // Diameter of star

 private final double L = 0.0769;  // Width of stripe

 

    // You will need to set values for these in paint()

 private int flag_width, flag_height, stripe_height, field_height, field_width, star_width;

 

    // init() will automatically be called when an applet is run

 public void init() {

  // Choice of width = 1.9 * height to start off

  // 760 : 400 is ratio of FLY : HOIST

  setSize(760, 400);

  //repaint needs to be called for the Applet to update properly when resized
  
  repaint();

 }

 

    // paint() will be called every time a resizing of an applet occurs

 public void paint(Graphics g) {

    flag_width = getWidth();   // width of applet    

    flag_height = getHeight();      // height of applet
    
    stripe_height = flag_height/13;
    
    field_height = (int) (flag_height * C);
    System.out.println((flag_height));
    System.out.println(field_height);
    field_width = (int) (flag_height * D);
    star_width = (int) (flag_height * K);
    

    // Figure out whether it is the flag_height or flag_width that is

    // the limiting factor on how to present the flag.

    //

    // Applets always repaint upon resizing

   
/*
    if (flag_width/flag_height > 1.0/1.9) {  // Height too tall for length of display

      flag_height = 500;

    } else {                   // Length too tall for height ofdisplay

      flag_width = flag_height*1.9;

    }
*/
   

   //calculate stripe height
    
   

   //draw commands
    drawBackground(g);
    drawStripes(g);
    drawField(g);

  }

 

 private void drawBackground(Graphics g) {

 }

 

 public void drawStripes(Graphics g) {

  //organization hint: make a Stripe class that contains a draw method
	 int temp = -stripe_height;
	 for (int i=0; i<13;i++) {
		 //g.drawRect(0, temp+stripe_height, flag_width, stripe_height);
		 //System.out.println(stripe_height + ", " + temp + ", " + i);
		 temp = temp+stripe_height;
		 if (i % 2 == 0) {
			 g.setColor(Color.red);
			 g.fillRect(0, temp, flag_width, stripe_height);
		 }
	 }
	 
 }

 

 public void drawField(Graphics g) {

  //organization hint: make a Field class that contains a draw method
	 g.setColor(Color.blue);
	 g.fillRect(0, 0, field_width, field_height);
 }

 

 public void drawStars(Graphics g) {
	 int star_pos;
	 int inner_radius = (int) (star_width * 0.382);
	 int[] xvalues = new int[10];
	 int[] yvalues = new int[10];
	 //360/10
	 int temp = -90+(360/10);
	 for (int i=0;i<10;i++) {
		 temp = temp-(360/10);
		 xvalues[i] = (int) Math.cos(temp);
		 xvalues[i] = (int) Math.sin(temp);
	 }
	 g.drawPolygon(xvalues, yvalues, 10);
  

 }

}
