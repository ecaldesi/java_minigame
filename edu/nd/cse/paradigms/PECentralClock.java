package edu.nd.cse.paradigms;
import java.util.TimerTask;
import java.util.Timer;
import java.util.*;

public class PECentralClock extends TimerTask{

  protected PEEngine engine;
  protected Timer timer;

  public PECentralClock(PEEngine engine, int rate){
    this.engine = engine;
    timer = new Timer();
    timer.scheduleAtFixedRate(this,0,50*rate);
  }

  public void run(){
    engine.tick();
  }
}
