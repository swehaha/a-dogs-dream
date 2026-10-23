/**
 * Dog player object for A Dog's Dream.
 *
 * @author Swetha Antony
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Dog extends GameObject_P8
{
    private int ySpeed;
    private BufferedImage dogImage;

    public Dog(int x, int y)
    {
        super(x, y, 120, 60);
        ySpeed = 0;

        try
        {
            dogImage = ImageIO.read(new File("dog.png"));
        }
        catch (IOException ie)
        {
            ie.printStackTrace();
        }
    }

    public void moveUp()
    {
        ySpeed = -7;
    }

    public void moveDown()
    {
        ySpeed = 7;
    }

    public void stop()
    {
        ySpeed = 0;
    }

    public void update()
    {
        y += ySpeed;

        if (y < 0)
        {
            y = 0;
        }

        if (y > CanvasPanel_P8.getCanvasHeight() - height)
        {
            y = CanvasPanel_P8.getCanvasHeight() - height;
        }
    }

    public void render(Graphics g)
    {
        if (dogImage != null)
        {
            g.drawImage(dogImage, x, y, width, height, null);
        }
        else
        {
            g.setColor(Color.WHITE);
            g.fillOval(x, y, width, height);
            g.setColor(Color.BLACK);
            g.drawString("Dog", x + 40, y + 30);
        }
    }
}