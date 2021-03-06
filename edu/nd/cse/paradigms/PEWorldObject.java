// Elisabetta Caldesi

package edu.nd.cse.paradigms;

abstract public class PEWorldObject{

  protected int x = 20;
  protected int y = 20;
  protected int color = 0xffffff;

  public PEWorldObject(){
  }
  public void setCenter(int x, int y){
    this.x = x;
    this.y = y;
  }
  public void setColor(int color){
    this.color = color;
  }
  public int getX(){
    return this.x;
  }
  public int getY(){
    return this.y;
  }
  public abstract void tick();
  public abstract void render(PEScreen screen);
  public abstract boolean inObjectBoundary(int qx, int qy);
}
