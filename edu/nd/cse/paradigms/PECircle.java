// Elisabetta Caldesi
// Java Milestone

package edu.nd.cse.paradigms;
import java.lang.Math;

public class PECircle extends PEWorldObject{
  protected int radius = 50;

  public PECircle(){

  }
  public void tick(){

  }
  public void setRadius(int radius){
    this.radius = radius;
  }

  public boolean inObjectBoundary(int qx, int qy){
    double distance = Math.sqrt((Math.pow((this.getX() - qx),2)) + (Math.pow((this.getY() - qy),2)));
    if (distance <= this.radius){
      return true;
    }
    return false;

  }

  public void render(PEScreen screen){
    int xc = this.getX() - radius;
    int yc = this.getY() - radius;
    for (int i = xc; i < this.getX()+radius; i++){
      for (int j = yc; j < this.getY()+radius; j++){
        if (this.inObjectBoundary(i,j)){
          screen.setPixel(i, j, this.color);
        }
      }
    }
  }
}
