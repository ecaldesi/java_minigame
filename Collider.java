import edu.nd.cse.paradigms.*;

public abstract class Collider {

    public abstract void processCollision(PECircle circle, PEWorldObject wo);
    public abstract void processCollision(Enemy enemy, PEWorldObject wo);
    public abstract void processCollision(PESquare square, PEWorldObject wo);

    public int removeprojectile = 0;
    public int removecircle = 0;

    public void processCollision(PEWorldObject wo1, PEWorldObject wo2) {
        if (wo1 instanceof PECircle)
            processCollision((PECircle)wo1, wo2);
        else if (wo1 instanceof Enemy)
            processCollision((Enemy)wo1, wo2);
        else if (wo1 instanceof PESquare)
            processCollision((PESquare)wo1, wo2);
    }
}
