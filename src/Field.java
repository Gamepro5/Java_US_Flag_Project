
 

 

//Here's the Field class.  This will give you clues as to how to create the other classes. 

import java.awt.Color;

import java.awt.Graphics;

 

public class Field {

 

 Color color;

 

 public Field(Color c)

 {

  this.color = c;

 }

 

 public void draw(Graphics g, int x, int y, int w, int h)

 {

  Color orig = g.getColor();

  g.setColor(color);

  g.fillRect(x, y, w, h);

  g.setColor(orig);

 

 }

 

}