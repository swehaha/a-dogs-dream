/**
 * Base class for all moving game objects.
 *
 * @author Swetha Antony
 */
import java.awt.*;

public abstract class GameObject_P8
{
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    public GameObject_P8(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void update();

    public abstract void render(Graphics g);

    public boolean overlaps(GameObject_P8 other)
    {
        return x < other.x + other.width &&
               x + width > other.x &&
               y < other.y + other.height &&
               y + height > other.y;
    }
}