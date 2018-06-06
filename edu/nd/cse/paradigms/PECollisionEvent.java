package edu.nd.cse.paradigms;
import java.util.List;
import java.util.ArrayList;

public class PECollisionEvent extends PEEvent{
  protected PEWorldObject o1;
  protected PEWorldObject o2;
  protected ArrayList<PEWorldObject> wos;


  public PECollisionEvent(PEWorldObject wo1, PEWorldObject wo2){
    this.o1 = wo1;
    this.o2 = wo2;

  }
  public List<PEWorldObject> getWorldObjects(){
    wos = new ArrayList<PEWorldObject>();
    wos.add(o1);
    wos.add(o2);
    return wos;
  }
}
