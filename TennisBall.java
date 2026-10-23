/**
 * Tennis ball obstacle for A Dog's Dream.
 *
 * @author Swetha Antony
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TennisBall extends Obstacle
{
    private BufferedImage tennisBallImage;

    public TennisBall(int x, int y, int speed, int ySpeed)
    {
        super(x, y, 40, 40, speed, ySpeed);

        try
        {
            tennisBallImage = ImageIO.read(new File("tennisBall.png"));
        }
        catch (IOException ie)
        {
            ie.printStackTrace();
        }
    }

    public void render(Graphics g)
    {
        if (tennisBallImage != null)
        {
            g.drawImage(tennisBallImage, x, y, width, height, null);
        }
        else
        {
            g.setColor(Color.GREEN);
            g.fillOval(x, y, width, height);
        }
    }
}