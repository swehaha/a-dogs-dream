
/**
 * Bird obstacle for A Dog's Dream.
 *
 * @author Swetha Antony
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Bird extends Obstacle
{
    private BufferedImage birdImage;

    public Bird(int x, int y, int speed, int ySpeed)
    {
        super(x, y, 65, 45, speed, ySpeed);

        try
        {
            birdImage = ImageIO.read(new File("bird.png"));
        }
        catch (IOException ie)
        {
            ie.printStackTrace();
        }
    }

    public void render(Graphics g)
    {
        if (birdImage != null)
        {
            g.drawImage(birdImage, x, y, width, height, null);
        }
        else
        {
            g.setColor(Color.BLACK);
            g.fillOval(x, y, width, height);
        }
    }
}