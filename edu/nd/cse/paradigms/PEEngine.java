// Elisabetta Caldesi

package edu.nd.cse.paradigms;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

public class PEEngine extends Frame implements KeyListener{
    protected PEGame game;
    protected PEScreen screen;
    protected int width = 640;
    protected int height = 480;
    protected int titlebarHeight = 0;

    protected PECentralClock cc; // clock

    protected ArrayList<PEWorldObject> wl; // list of world objects
    protected Queue<PEEvent> q; // queue of events

    protected ArrayList<PEWorldObject> collision; // list of objects colliding

    public PEEngine(PEGame game){
        this.game = game;
        screen = new PEScreen(width, height);
        this.setSize(width, height);
        this.setVisible(true);
        cc = new PECentralClock(this, 1);
        wl = new ArrayList<PEWorldObject>();
        q = new LinkedList<PEEvent>();
        addKeyListener(this);
    }

    public void processEvent(PEKeyEvent evt) {
        game.keyPressed(evt.getKeyCode());
    }

    public void processEvent(PECollisionEvent evt) {
        game.collisionDetected(evt.getWorldObjects());
    }

    private void eventLoopIterate(){
        while(!q.isEmpty()) {
            PEEvent e = q.remove();
            if (e instanceof PEKeyEvent) {
                this.processEvent((PEKeyEvent)e);
            } else if (e instanceof PECollisionEvent) {
                this.processEvent((PECollisionEvent)e);

            }
        }
    }

    public void keyPressed(KeyEvent evt) {
        PEKeyEvent event = new PEKeyEvent(evt);
        q.add(event);
    }

    public void keyReleased(KeyEvent evt){
    }

    public void keyTyped(KeyEvent evt) {
    }

    public boolean detectCollision(PEWorldObject wo1, PEWorldObject wo2) {
        for (int i =0; i< width; i++) {
            for (int k = 0; k<height; k++) {
                if (wo1.inObjectBoundary(i,k) && wo2.inObjectBoundary(i,k)){
                    return true;
                }
            }
        }
        return false;
    }

    public void add(PEWorldObject wo) {
        wl.add(wo);
    }

    public void remove(PEWorldObject wo) {
        wl.remove(wo);
    }

    public void tick() {

        collision = new ArrayList<PEWorldObject>();
        screen.clear();
        this.eventLoopIterate();
        for (PEWorldObject w1: wl) {
            collision.add(w1); // add to collision list
            for (PEWorldObject w2: wl) {
                if (!collision.contains(w2)) { // if in collision
                    if (detectCollision(w1, w2)){ // collision is happening
                        PECollisionEvent coll = new PECollisionEvent(w1,w2);
                        q.add(coll); // add collision to queue of events
                    }
                }
            }
            w1.tick();
            w1.render(screen);
        }
        this.repaint();
    }

    public void update(Graphics g) {
        this.paint(g);
    }
    public void paint(Graphics g) {
        g.drawImage(screen.render(), 0, titlebarHeight, width, height, Color.BLACK, null);
    }
}
