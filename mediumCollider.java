import edu.nd.cse.paradigms.*;

public class mediumCollider extends Collider {
    protected PEEngine engine;
    int counter = 0;

    public mediumCollider(PEEngine engine) {
        this.engine = engine;
    }

    public void processCollision(PECircle circle, PEWorldObject wo) {
        if (!(circle instanceof Projectile)){
            if (wo instanceof Enemy) {
                this.removecircle = 1;
                this.removeprojectile = 0;
            }
        }
    }

    public void processCollision(Enemy enemy, PEWorldObject wo) {
        if (wo instanceof Projectile) {
            if (counter == 0) {
                counter++;
                enemy.setColor(0xff3300);
                this.removeprojectile = 1;
                this.removecircle = 0;
            } else if (counter == 1) {
                this.removeprojectile = 1;
                this.removecircle = 0;
                counter = 0;
                engine.remove(enemy);
            }
        }
    }

    public void processCollision(PESquare square, PEWorldObject wo) {
        if (wo instanceof Projectile) {
            this.removeprojectile = 1;
            this.removecircle = 0;
        }
    }
}
