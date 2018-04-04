// Elisabetta Caldesi
// Daily 2- Java
// 3/23/18

import edu.nd.cse.paradigms.*;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class myGame extends PEGame {
    protected PEEngine engine;
    private PECircle circle;
    private PECircle circle2;
    private Collider collider;
    private Projectile projectile;
    private PEKeyEvent keyevent;
    private Enemy enemy1;
    private Enemy enemy2;
    private PESquare target;

    public void collisionDetected(List<PEWorldObject> worldObject){
        int i = 0;
        for (PEWorldObject wo: worldObject) {
            collider.processCollision(wo, worldObject.get(i^1));
            i++;
        }
        if (collider.removeprojectile == 1 && projectile != null) {
            engine.remove(projectile);
            projectile = null;
            collider.removeprojectile = 0;
        }
        if (collider.removecircle == 1 && circle != null) {
            engine.remove(circle);
            circle = null;
        }
    }

    public void tick(){
        if (projectile != null) {
            if (projectile.destroyed == 1) {
                engine.remove(projectile);
                projectile = null;
            }
        }
    }

    public void start(){
        engine = new PEEngine(this,50);
        collider = new mediumCollider(engine);

        circle = new PECircle();
        circle.setCenter(100,100);
        circle.setRadius(20);
        circle.setColor(0xFFFFFF);

        enemy1 = new Enemy();
        enemy1.setCenter(50,50);
        enemy1.setSize(40);
        enemy1.setColor(0xffb3da);

        enemy2 = new Enemy();
        enemy2.setCenter(610, 400);
        enemy2.setSize(40);
        enemy2.setColor(0x33ff33);

        target = new PESquare();
        target.setCenter(200,200);
        target.setSize(10);
        target.setColor(0x666699);

        engine.add(circle);
        engine.add(enemy1);
        engine.add(enemy2);
        engine.add(target);
    }
    public void keyPressed(int keycode){
        if (keycode == keyevent.VK_DOWN && circle != null){ // arrow down
            int y = circle.getY();
            int x = circle.getX();
            circle.setCenter(x,y+10);
        }
        if (keycode == keyevent.VK_UP && circle != null){ // arrow up
            int y = circle.getY();
            int x = circle.getX();
            circle.setCenter(x,y-10);
        }
        if (keycode == keyevent.VK_LEFT && circle != null){ // left arrow
            int y = circle.getY();
            int x = circle.getX();
            circle.setCenter(x-10,y);
        }
        if (keycode == keyevent.VK_RIGHT && circle != null){ // right arrow
            int y = circle.getY();
            int x = circle.getX();
            circle.setCenter(x+10,y);
        }
        if (keycode == keyevent.VK_SPACE) { // if space bar is pressed
            if (projectile == null & circle != null) {
                int tx = target.getX();
                int ty = target.getY();
                projectile = new Projectile(tx,ty);
                projectile.setRadius(5);
                projectile.setColor(0xf47a42);
                projectile.setCenter(circle.getX(), circle.getY());
                engine.add(projectile);
            }
        }
        if (keycode == keyevent.VK_S){ // arrow down
            target.setCenter(target.getX(), (target.getY() +7));
        }
        if (keycode == keyevent.VK_W){ // arrow up
            target.setCenter(target.getX(),(target.getY() -7));
        }
        if (keycode == keyevent.VK_A){ // left arrow
            target.setCenter(target.getX()-7,target.getY());
        }
        if (keycode == keyevent.VK_D){ // right arrow
            target.setCenter(target.getX()+7,target.getY());
        }
    }
}
