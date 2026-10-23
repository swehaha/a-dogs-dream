/**
 * Superclass for all obstacle objects.
 *
 * @author Swetha Antony
 */
import java.awt.*;

public abstract class Obstacle extends GameObject_P8
{
    protected int speed;
    protected int ySpeed;

    public Obstacle(int x, int y, int width, int height,
                       int speed, int ySpeed)
    {
        super(x, y, width, height);

        this.speed = speed;
        this.ySpeed = ySpeed;
    }

    public void update()
    {
        x -= speed;
        y += ySpeed;

        if (y <= 0 || y >= CanvasPanel_P8.getCanvasHeight() - height)
        {
            ySpeed *= -1;
        }
    }

    public boolean isOffScreen()
    {
        return x + width < 0;
    }

    public abstract void render(Graphics g);
}