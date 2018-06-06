package edu.nd.cse.paradigms;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PEKeyEvent extends PEEvent{
  public static final int VK_DOWN = 40;
  public static final int VK_RIGHT = 39;
  public static final int VK_LEFT = 37;
  public static final int VK_UP = 38;


  private KeyEvent ke;
  PEKeyEvent(KeyEvent awtKeyEvent){
    this.ke = awtKeyEvent;
  }

  public int getKeyCode(){
    return ke.getKeyCode();
  }
}
