import edu.nd.cse.paradigms.*;

public class Enemy extends PESquare{
    private int x_rate = 2;
    private int y_rate = 1;

    public Enemy() {
        super();
    }
    public void tick() {
        this.x += this.x_rate;
        if (x >=640)
            this.x_rate = -2;
        if (x <= 0)
            this.x_rate = 2;
    }
}
