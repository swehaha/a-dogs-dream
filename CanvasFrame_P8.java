
/**
 * CanvasFrame for Project 8
 *
 * Swetha Antony
 * @version 1.0(5/6/2026)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CanvasFrame_P8
{
    private JFrame           frame;  // the actual frame(window) we'll be showing
    private CanvasPanel_P8 canvas; // the canvas we'll be drawing
    
    /**
     * Creates a new CanvasFrame object.
     */
    public CanvasFrame_P8()
    {
        frame = new JFrame("A Dog's Dream CanvasFrame"); //make the JFrame, and set thw window bar title 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        canvas = new CanvasPanel_P8();  // CanvasPanel extends a JPanel
        canvas.setPreferredSize(new Dimension(2 * canvas.getCanvasXBorder() + canvas.getCanvasWidth(), 
                                              2 * canvas.getCanvasYBorder() + canvas.getCanvasHeight() ));
        frame.getContentPane().add(canvas); //put the canvas (JPanel) in the frame

        frame.pack();                     //make everything the preferred size
        frame.setVisible(true);           //show the frame
    }
}