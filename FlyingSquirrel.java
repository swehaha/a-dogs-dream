/**
 * Flying squirrel obstacle for A Dog's Dream.
 *
 * @author Swetha Antony
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FlyingSquirrel extends Obstacle
{
    private BufferedImage squirrelImage;

    public FlyingSquirrel(int x, int y, int speed, int ySpeed)
    {
        super(x, y, 75, 50, speed, ySpeed);

        try
        {
            squirrelImage = ImageIO.read(new File("squirrel.png"));
        }
        catch (IOException ie)
        {
            ie.printStackTrace();
        }
    }

    public void render(Graphics g)
    {
        if (squirrelImage != null)
        {
            g.drawImage(squirrelImage, x, y, width, height, null);
        }
        else
        {
            g.setColor(new Color(150, 90, 40));
            g.fillOval(x, y, width, height);
        }
    }
}