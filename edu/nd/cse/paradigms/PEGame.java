// Elisabetta Caldesi

package edu.nd.cse.paradigms;
import java.util.List;
import java.util.ArrayList;

public abstract class PEGame{
  public abstract void start();
  public abstract void tick();
  public abstract void keyPressed(int keycode);
  public abstract void collisionDetected(List<PEWorldObject> list);
}
