// Elisabetta Caldesi

package edu.nd.cse.paradigms;

public class PESquare extends PEWorldObject{
  protected int size = 50;

  public PESquare(){

  }
  public void tick(){

  }
  public void setSize(int size){
    this.size = size;
  }

  public boolean inObjectBoundary(int qx, int qy){
    int xc = this.getX() - size/2;
    int yc = this.getY() - size/2;
    for (int i = xc; i < xc+size; i++){
      for (int j = yc; j < yc+size; j++){
        if(qx == i && qy == j){
          return true;
        }
      }
    }
    return false;
  }
  public void render(PEScreen screen){
    int xc = this.getX() - size/2;
    int yc = this.getY() - size/2;
    for (int i = xc; i < xc+size; i++){
      for (int j = yc; j < yc+size; j++){
        screen.setPixel(i, j, this.color);
      }
    }
  }
}
