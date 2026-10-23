
/**
 * CanvasPanel for Project 8
 *
 * Swetha Antony
 * @version 1.0(5/6/2026)
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.geom.AffineTransform;
import java.util.Random;

// For Sprites 
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class CanvasPanel_P8 extends JPanel
{
    private final static int X_CORNER = 25;
    private final static int Y_CORNER = 25;
    private final static int CANVAS_WIDTH = 600;
    private final static int CANVAS_HEIGHT = 600;

    private Dog dog;
    private List<Obstacle> obstacles = new ArrayList<>();
    private List<Cloud> clouds = new ArrayList<>();

    private Random random = new Random();

    private int frameNumber;
    private int score;
    private int difficultyLevel;
    private static int scrollSpeed;
    private int spawnRate;

    private boolean gameOver;


    /**
     * Constructor for objects of class CanvasPanel_P8
     */
    public CanvasPanel_P8()
    {
        dog = new Dog(100, 300);

        clouds.add(new Cloud(50, 450, 1));
        clouds.add(new Cloud(250, 520, 1));
        clouds.add(new Cloud(450, 430, 1));

        frameNumber = 0;
        score = 0;
        difficultyLevel = 1;
        scrollSpeed = 4;
        spawnRate = 90;
        gameOver = false;

        this.setFocusable(true);
        this.addKeyListener(new myActionListener());

        Timer renderLoop = new Timer(30, (ActionEvent ev) -> {
            frameNumber++;
            Simulate();
            repaint();
        });

        renderLoop.start();
    }

    public void Simulate()
    {
        if (gameOver)
        {
            return;
        }

        score++;

        dog.update();

        for (Cloud cloud : clouds)
        {
            cloud.update();
        }

        updateDifficulty();

        if (frameNumber % spawnRate == 0)
        {
            spawnObstacle();
        }

        for (int i = 0; i < obstacles.size(); i++)
        {
            Obstacle obstacle = obstacles.get(i);
            obstacle.update();

            if (obstacle.overlaps(dog))
            {
                gameOver = true;
            }

            if (obstacle.isOffScreen())
            {
                obstacles.remove(i);
                i--;
            }
        }
    }

    public void updateDifficulty()
    {
        if (frameNumber < 300)
        {
            difficultyLevel = 1;
            scrollSpeed = 5;
            spawnRate = 70;
        }
        else if (frameNumber < 600)
        {
            difficultyLevel = 2;
            scrollSpeed = 8;
            spawnRate = 45;
        }
        else
        {
            difficultyLevel = 3;
            scrollSpeed = 10 + (frameNumber - 600) / 150;
            spawnRate = 30;
        }
    }

    public void spawnObstacle()
    {
        //rsndom y-position
        int y = random.nextInt(450) + 50;
        
        //random type of obstacle
        int type = random.nextInt(3);
        
        //random vertical movement
        int ySpeed = random.nextInt(4) + 1;
        
        // randomly flip direction
        if (random.nextBoolean())
        {
            ySpeed *= -1;
        }
        
        if (type == 0)
        {
            obstacles.add(new Bird(650, y, scrollSpeed, ySpeed));
        }
        else if (type == 1)
        {
            obstacles.add(new FlyingSquirrel(650, y, scrollSpeed, ySpeed));
        }
        else
        {
            obstacles.add(new TennisBall(650, y, scrollSpeed, ySpeed));
        }
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g.create();

        // border
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, CANVAS_WIDTH + 2 * X_CORNER, CANVAS_HEIGHT + 2 * Y_CORNER);

        // night sky background
        g2.setColor(new Color(10, 15, 45));
        g2.fillRect(X_CORNER, Y_CORNER, CANVAS_WIDTH, CANVAS_HEIGHT);

        // stars
        g2.setColor(Color.WHITE);
        g2.fillOval(80, 80, 3, 3);
        g2.fillOval(180, 140, 3, 3);
        g2.fillOval(300, 90, 3, 3);
        g2.fillOval(430, 180, 3, 3);
        g2.fillOval(560, 100, 3, 3);
        g2.fillOval(520, 300, 3, 3);
        g2.fillOval(150, 350, 3, 3);

        // moon
        g2.setColor(new Color(245, 245, 210));
        g2.fillOval(500, 60, 60, 60);

        Graphics2D canvasG = (Graphics2D) g2.create();
        canvasG.translate(X_CORNER, Y_CORNER);

        for (Cloud cloud : clouds)
        {
            cloud.render(canvasG);
        }

        dog.render(canvasG);

        for (Obstacle obstacle : obstacles)
        {
            obstacle.render(canvasG);
        }

        canvasG.dispose();

        // score text
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Consolas", Font.BOLD, 18));
        g2.drawString("Score: " + score, 40, 50);
        String difficultyText;
        if (difficultyLevel == 1)
        {
            difficultyText = "Easy";
        }
        else if (difficultyLevel == 2)
        {
            difficultyText = "Medium";
        }
        else
        {
            difficultyText = "Hard";
        }

        g2.drawString("Difficulty: " + difficultyText, 40, 75);

        if (gameOver)
        {
            drawGameOver(g2);
        }

        g2.dispose();
    }
    

    public void drawGameOver(Graphics2D g2)
    {
        g2.setColor(Color.WHITE);
        g2.fillRoundRect(180, 250, 320, 120, 60, 60);

        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Consolas", Font.BOLD, 30));
        g2.drawString("GAME OVER", 245, 305);

        g2.setFont(new Font("Consolas", Font.PLAIN, 18));
        g2.drawString("Final Score: " + score, 255, 335);
        g2.drawString("Press R to Restart", 255, 360);
    }

    public static int getCanvasWidth()
    {
        return CANVAS_WIDTH;
    }

    public static int getCanvasHeight()
    {
        return CANVAS_HEIGHT;
    }

    public static int getCanvasXBorder()
    {
        return X_CORNER;
    }

    public static int getCanvasYBorder()
    {
        return Y_CORNER;
    }
    
    public static int getScrollSpeed()
    {
        return scrollSpeed;
    }

    public class myActionListener extends KeyAdapter
    {
        public void keyPressed(KeyEvent e)
        {
            switch (e.getKeyCode())
            {
                case KeyEvent.VK_UP:
                    dog.moveUp();
                    break;

                case KeyEvent.VK_DOWN:
                    dog.moveDown();
                    break;

                case KeyEvent.VK_R:
                    resetGame();
                    break;

                default:
                    System.out.println("press up/down arrows");
            }
        }

        public void keyReleased(KeyEvent e)
        {
            dog.stop();
        }
    }

    public void resetGame()
    {
        dog = new Dog(100, 300);
        obstacles.clear();

        frameNumber = 0;
        score = 0;
        difficultyLevel = 1;
        scrollSpeed = 5;
        spawnRate = 70;
        gameOver = false;
    }
}