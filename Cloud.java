/**
 * Cloud background object.
 *
 * @author Swetha Antony
 */
import java.awt.*;

public class Cloud extends GameObject_P8
{
    private int speed;
    

    public Cloud(int x, int y, int speed)
    {
        super(x, y, 100, 45);
        this.speed = speed;
    }

    public void update()
    {
        x -= speed + CanvasPanel_P8.getScrollSpeed() / 4;

        if (x + width < 0)
        {
            x = CanvasPanel_P8.getCanvasWidth();
        }
    }

    public void render(Graphics g)
    {
        g.setColor(Color.WHITE);

        g.fillOval(x, y + 10, 40, 25);
        g.fillOval(x + 25, y, 50, 35);
        g.fillOval(x + 60, y + 10, 40, 25);
    }
}