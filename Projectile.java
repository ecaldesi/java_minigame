import edu.nd.cse.paradigms.*;

public class Projectile extends PECircle{
    private int x_rate = 0;
    private int y_rate = 0;
    private int tx;
    private int ty;

    public int destroyed = 0;

    public Projectile(int x, int y) {
        super();
        this.tx = x;
        this.ty = y;
    }

    public void tick() {
        if (this.tx < this.x)
            this.x_rate = -1;
        else if (this.tx > this.x)
            this.x_rate = 1;
        else if (this.tx == this.x)
            this.x_rate = 0;

        if (this.ty < this.y)
            this.y_rate = -1;
        else if (this.ty > this.y)
            this.y_rate = 1;
        else if (this.ty == this.y)
            this.y_rate = 0;


        if (this.x == this.tx && this.y == this.ty) {
            this.destroyed = 1;
        }
        this.x += this.x_rate;
        this.y += this.y_rate;

    }
}
