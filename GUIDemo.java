import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

/**
 * Minimal Java Swing application.
 * 
 * @author Nathan Sprague
 * @author Tessa Nyquist
 */
public class GUIDemo extends JFrame
{
    private JPanel panel;
    private JButton biggerButton,smallerButton,colorButton;

    /**
     * Set up the application.
     */
    public GUIDemo()
    {
    setTitle("Bigger/Smaller/Color");
        setSize(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        biggerButton = new JButton("BIGGER");
        smallerButton = new JButton("SMALLER");
        colorButton = new JButton("COLOR");
        biggerButton.addActionListener(new ButtonHandler());
        smallerButton.addActionListener(new ButtonHandler());
        colorButton.addActionListener(new ButtonHandler());
        add(panel);
        panel.add(biggerButton);
        panel.add(smallerButton);
        panel.add(colorButton);
        setVisible(true);
    }

    /**
     * This inner class exists to handle button events. There are other ways
     * this could have been done:
     * 
     * 1. GUIDemo could implement ActionListener itself. 
     * 2. Anonymous inner classes could be used to hand the events.
     */
    private class ButtonHandler implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            Dimension size = getSize();

            if (e.getSource().equals(biggerButton))
            {
                setSize(size.width + 10, size.height + 10);
            }
            if (e.getSource().equals(smallerButton))
            {
                setSize(size.width - 10, size.height - 10);
            }
	    if (e.getSource().equals(colorButton))
	    {
	        Random rand = new Random();
	        int colorRed = rand.nextInt(255) + 0;
	        int colorGreen =  rand.nextInt(255) + 0;
	        int colorBlue = rand.nextInt(255) + 0;
	        //int  = (int) Math.random() * 255 - 1 + 0;
	        //int colorGreen =(int) Math.random() * 255 - 1 + 0;
	        //int colorBlue = (int) Math.random() * 255 - 1 + 0;
	        panel.setBackground(new java.awt.Color(colorRed, colorGreen, colorBlue));
	    }
        }
    }

    /**
     * Start the app by creating a GUIDemo object.
     */
    public static void main(String[] args)
    {
        GUIDemo app = new GUIDemo();
    }
}